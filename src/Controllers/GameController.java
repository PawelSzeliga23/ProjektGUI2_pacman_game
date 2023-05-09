package Controllers;

import Components.CustomJTable;
import Components.Panels.ScorePanel;
import Data.Hero;

public class GameController extends Thread {
    public static boolean gameIsRunning;
    CustomJTable table;
    KeyHandler keyHandler;
    private final Hero hero;


    public GameController(CustomJTable table, KeyHandler keyHandler, Hero hero) {
        GameController.gameIsRunning = true;
        this.table = table;
        this.keyHandler = keyHandler;
        this.hero = hero;
    }

    public void update() {
        int heroPositionX = hero.getHeroPositionX();
        int heroPositionY = hero.getHeroPositionY();
        if (keyHandler.upAction && heroPositionY - 1 >= 0 && (int) (table.getValueAt(heroPositionY - 1, heroPositionX)) > 98) {
            if ((int) (table.getValueAt(heroPositionY - 1, heroPositionX)) == 99) {
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(102, --heroPositionY, heroPositionX);
        } else if (keyHandler.downAction && heroPositionY + 1 < table.getRowCount() &&
                (int) (table.getValueAt(heroPositionY + 1, heroPositionX)) > 98) {
            if ((int) (table.getValueAt(heroPositionY + 1, heroPositionX)) == 99) {
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(104, ++heroPositionY, heroPositionX);
        } else if (keyHandler.leftAction && heroPositionX - 1 >= 0 &&
                (int) (table.getValueAt(heroPositionY, heroPositionX - 1)) > 98) {
            if ((int) (table.getValueAt(heroPositionY, heroPositionX - 1)) == 99) {
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(105, heroPositionY, --heroPositionX);
        } else if (keyHandler.rightAction && heroPositionY + 1 < table.getRowCount() &&
                (int) (table.getValueAt(heroPositionY, heroPositionX + 1)) > 98) {
            if ((int) (table.getValueAt(heroPositionY, heroPositionX + 1)) == 99) {
                ScorePanel.coinScore();
            }
            table.setValueAt(100, heroPositionY, heroPositionX);
            table.setValueAt(103, heroPositionY, ++heroPositionX);
        }
        hero.setHeroPositionX(heroPositionX);
        hero.setHeroPositionY(heroPositionY);
    }

    @Override
    public synchronized void run() {
        while (gameIsRunning) {
            System.out.println("Kupa");
            update();
            try {
                sleep(300);
            } catch (InterruptedException e) {
                System.out.println("gameController ended");
            }
        }
    }
}
