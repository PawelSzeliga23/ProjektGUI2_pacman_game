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

    private void update() {
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
                table.setValueAt(valueColour, --positionY, positionX);
                table.setValueAt(99, positionY + 1, positionX);
            }
            case 1 -> {
                table.setValueAt(valueColour, ++positionY, positionX);
                table.setValueAt(99, positionY - 1, positionX);
            }
            case 2 -> {
                table.setValueAt(valueColour, positionY, --positionX);
                table.setValueAt(99, positionY, positionX + 1);
            }
            case 3 -> {
                table.setValueAt(valueColour, positionY, ++positionX);
                table.setValueAt(99, positionY, positionX - 1);
            }
        }
    }
}
