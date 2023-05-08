package Controllers;

import Components.CustomJTable;
import Components.Panels.ScorePanel;

public class GameController extends Thread {
    public static boolean gameIsRunning;
    CustomJTable table;
    KeyHandler keyHandler;
    private int heroPositionX;
    private int heroPositionY;
    private int animation;


    public GameController(CustomJTable table, KeyHandler keyHandler) {
        GameController.gameIsRunning = true;
        this.animation = 0;
        this.table = table;
        this.keyHandler = keyHandler;
        boolean foundPosition = false;
        for (int i = 0; i < table.getRowCount() && !foundPosition; i++) {
            for (int j = 0; j < table.getColumnCount() && !foundPosition; j++) {
                if ((int) table.getValueAt(i, j) == 99) {
                    heroPositionX = j;
                    heroPositionY = i;
                    foundPosition = true;
                }
            }
        }
        table.setValueAt(102, heroPositionY, heroPositionX);
    }

    public void update() {
        if (keyHandler.upAction && heroPositionY - 1 >= 0 &&
                (int) (table.getValueAt(heroPositionY - 1, heroPositionX)) > 98) {
            if ((int) (table.getValueAt(heroPositionY - 1, heroPositionX )) == 99){
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(102 + animation, --heroPositionY, heroPositionX);
        } else if (keyHandler.downAction && heroPositionY + 1 < table.getRowCount() &&
                (int) (table.getValueAt(heroPositionY + 1, heroPositionX)) > 98) {
            if ((int) (table.getValueAt(heroPositionY + 1, heroPositionX)) == 99){
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(104 + animation, ++heroPositionY, heroPositionX);
        } else if (keyHandler.leftAction && heroPositionX - 1 >= 0 &&
                (int) (table.getValueAt(heroPositionY, heroPositionX - 1)) > 98) {
            if ((int) (table.getValueAt(heroPositionY, heroPositionX - 1)) == 99){
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(105 + animation, heroPositionY, --heroPositionX);
        } else if (keyHandler.rightAction && heroPositionY + 1 < table.getRowCount() &&
                (int) (table.getValueAt(heroPositionY, heroPositionX + 1)) > 98) {
            if ((int) (table.getValueAt(heroPositionY, heroPositionX + 1)) == 99){
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(103 + animation, heroPositionY, ++heroPositionX);
        }
    }

    @Override
    public void run() {
        while (gameIsRunning) {
            update();
            if (animation == 0) {
                animation = 4;
            } else {
                animation = 0;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("gameController ended");
            }
        }
    }
}
