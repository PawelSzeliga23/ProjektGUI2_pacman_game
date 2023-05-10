package Controllers;

import Components.CustomJTable;

public class GhostController extends Thread {
    private boolean isAlive;
    CustomJTable table;
    private long speed;
    private int positionX;
    private int positionY;
    private final int valueColour;

    public GhostController(CustomJTable table, long speed, int valueColour, int positionX, int positionY) {
        this.valueColour = valueColour;
        this.isAlive = true;
        this.table = table;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
        table.setValueAt((int) table.getValueAt(positionY, positionX) + 20, positionY, positionX);
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

    private void update() {
        int valueAtCurrentPosition = (int) table.getValueAt(positionY, positionX);
        if (valueAtCurrentPosition < 119 && valueAtCurrentPosition > 100) {
            GameController.gameIsRunning = false;
        } else {
            int[] possibleMove = new int[4];
            int counter = 0;
            if (positionY - 1 >= 0 && (int) (table.getValueAt(positionY - 1, positionX)) > 98) {
                possibleMove[counter++] = 0;
            }
            if (positionY + 1 < table.getRowCount() && (int) (table.getValueAt(positionY + 1, positionX)) > 98) {
                possibleMove[counter++] = 1;
            }
            if (positionX - 1 >= 0 && (int) (table.getValueAt(positionY, positionX - 1)) > 98) {
                possibleMove[counter++] = 2;
            }
            if (positionX + 1 < table.getRowCount() && (int) (table.getValueAt(positionY, positionX + 1)) > 98) {
                possibleMove[counter++] = 3;
            }
            switch (possibleMove[(int) (Math.random() * counter)]) {
                case 0 -> {
                    table.setValueAt((int) table.getValueAt(positionY - 1, positionX) + valueColour, --positionY, positionX);
                    table.setValueAt(valueAtCurrentPosition - valueColour, positionY + 1, positionX);
                }
                case 1 -> {
                    table.setValueAt((int) table.getValueAt(positionY + 1, positionX) + valueColour, ++positionY, positionX);
                    table.setValueAt(valueAtCurrentPosition - valueColour, positionY - 1, positionX);
                }
                case 2 -> {
                    table.setValueAt((int) table.getValueAt(positionY, positionX - 1) + valueColour, positionY, --positionX);
                    table.setValueAt(valueAtCurrentPosition - valueColour, positionY, positionX + 1);
                }
                case 3 -> {
                    table.setValueAt((int) table.getValueAt(positionY, positionX + 1) + valueColour, positionY, ++positionX);
                    table.setValueAt(valueAtCurrentPosition - valueColour, positionY, positionX - 1);
                }
            }
        }
    }
}
