package Controllers;

import Components.CustomJTable;

public class GhostController extends Thread {
    private boolean isAlive;
    GameController gameController;
    CustomJTable table;
    private long speed;
    private int positionX;
    private int positionY;
    private final int defaultPositionX;
    private final int defaultPositionY;
    private final int valueColour;
    private int valueUnderCurrentPosition;
    private int temporaryValue;

    public GhostController(GameController gameController, CustomJTable table, long speed, int valueColour, int positionX, int positionY) {
        this.gameController = gameController;
        this.valueColour = valueColour;
        this.isAlive = true;
        this.table = table;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
        defaultPositionX = positionX;
        defaultPositionY = positionY;
        setValueUnderDefaultPosition();
        table.setValueAt(valueColour, positionY, positionX);
    }

    @Override
    public void run() {
        while (GameController.gameIsRunning) {
            update();
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        interrupt();
    }

    private synchronized void update() {
        int[] possibleMove = new int[4];
        int counter = 0;
        if (possibleMoveUp()) {
            possibleMove[counter++] = 0;
        }
        if (possibleMoveDown()) {
            possibleMove[counter++] = 1;
        }
        if (possibleMoveLeft()) {
            possibleMove[counter++] = 2;
        }
        if (possibleMoveRight()) {
            possibleMove[counter++] = 3;
        }
        switch (possibleMove[(int) (Math.random() * counter)]) {
            case 0 -> {
                int[] direction = new int[]{-1, 0};
                if (getValue(direction))
                    setValueInTable(direction);
            }
            case 1 -> {
                int[] direction = new int[]{+1, 0};
                if (getValue(direction))
                    setValueInTable(direction);
            }
            case 2 -> {
                int[] direction = new int[]{0, -1};
                if (getValue(direction))
                    setValueInTable(direction);
            }
            case 3 -> {
                int[] direction = new int[]{0, +1};
                if (getValue(direction))
                    setValueInTable(direction);
            }
        }
        valueUnderCurrentPosition = temporaryValue;
    }

    private synchronized boolean possibleMoveUp() {
        return positionY - 1 >= 0 && (int) (table.getValueAt(positionY - 1, positionX)) > 98;
    }

    private synchronized boolean possibleMoveDown() {
        return positionY - 1 >= 0 && (int) (table.getValueAt(positionY + 1, positionX)) > 98;
    }

    private synchronized boolean possibleMoveRight() {
        return positionY - 1 >= 0 && (int) (table.getValueAt(positionY, positionX + 1)) > 98;
    }

    private synchronized boolean possibleMoveLeft() {
        return positionY - 1 >= 0 && (int) (table.getValueAt(positionY, positionX - 1)) > 98;
    }

    private synchronized boolean getValue(int[] direction) {
        int tempValue = (int) table.getValueAt(positionY + direction[0], positionX + direction[1]);
        if (tempValue == 99) {
            temporaryValue = 99;
        } else if (tempValue == 100) {
            temporaryValue = 100;
        } else if (tempValue == 120) {
            temporaryValue = gameController.getGhostController1().getValueUnderCurrentPosition();
        } else if (tempValue == 121) {
            temporaryValue = gameController.getGhostController2().getValueUnderCurrentPosition();
        } else if (tempValue == 122) {
            temporaryValue = gameController.getGhostController3().getValueUnderCurrentPosition();
        } else if (tempValue == 123) {
            temporaryValue = gameController.getGhostController4().getValueUnderCurrentPosition();
        } else if (tempValue > 100 && tempValue < 110){
            gameController.heroDies();
            return false;
        }
        return true;
    }

    private synchronized void setValueInTable(int[] direction) {
        int newPositionY = positionY + direction[0];
        int newPositionX = positionX + direction[1];
        table.setValueAt(valueColour, newPositionY, newPositionX);
        table.setValueAt(valueUnderCurrentPosition, positionY, positionX);
        positionY = newPositionY;
        positionX = newPositionX;
    }
    public synchronized void setDefaultPositions(){
        table.setValueAt(valueUnderCurrentPosition,positionY,positionX);
        positionY = defaultPositionY;
        positionX = defaultPositionX;
        setValueUnderDefaultPosition();
        table.setValueAt(valueColour,defaultPositionY,defaultPositionX);
    }

    public int getValueUnderCurrentPosition() {
        return valueUnderCurrentPosition;
    }

    private void setValueUnderDefaultPosition() {
        valueUnderCurrentPosition = (int) table.getValueAt(positionY, positionX);
    }
}
