package Controllers;

import Components.CustomJTable;
import Components.Panels.ScorePanel;
import Data.Hero;

public class GameController extends Thread {
    public static boolean gameIsRunning;
    CustomJTable table;
    KeyHandler keyHandler;
    private final Hero hero;
    public long speed;


    public GameController(CustomJTable table, KeyHandler keyHandler, Hero hero, long speed) {
        GameController.gameIsRunning = true;
        this.table = table;
        this.keyHandler = keyHandler;
        this.hero = hero;
        this.speed = speed;
    }

    public void update() {
        int heroPositionX = hero.getHeroPositionX();
        int heroPositionY = hero.getHeroPositionY();
        int valueAtCurrentPosition = (int) (table.getValueAt(heroPositionY, heroPositionX));
        if (valueAtCurrentPosition > 118) {
            gameIsRunning = false;
        } else {
            if (keyHandler.upAction && heroPositionY - 1 >= 0 && (int) (table.getValueAt(heroPositionY - 1, heroPositionX)) > 98) {
                if ((int) (table.getValueAt(heroPositionY - 1, heroPositionX)) == 99) {
                    SoundController.chompSound();
                    ScorePanel.coinScore();
                }
                table.setValueAt(102, --heroPositionY, heroPositionX);
                table.setValueAt(100, heroPositionY + 1, heroPositionX);
            } else if (keyHandler.downAction && heroPositionY + 1 < table.getRowCount() &&
                    (int) (table.getValueAt(heroPositionY + 1, heroPositionX)) > 98) {
                if ((int) (table.getValueAt(heroPositionY + 1, heroPositionX)) == 99) {
                    SoundController.chompSound();
                    ScorePanel.coinScore();
                }
                table.setValueAt(104, ++heroPositionY, heroPositionX);
                table.setValueAt(100, heroPositionY - 1, heroPositionX);
            } else if (keyHandler.leftAction && heroPositionX - 1 >= 0 &&
                    (int) (table.getValueAt(heroPositionY, heroPositionX - 1)) > 98) {
                if ((int) (table.getValueAt(heroPositionY, heroPositionX - 1)) == 99) {
                    SoundController.chompSound();
                    ScorePanel.coinScore();
                }
                table.setValueAt(105, heroPositionY, --heroPositionX);
                table.setValueAt(100, heroPositionY, heroPositionX + 1);
            } else if (keyHandler.rightAction && heroPositionY + 1 < table.getRowCount() &&
                    (int) (table.getValueAt(heroPositionY, heroPositionX + 1)) > 98) {
                if ((int) (table.getValueAt(heroPositionY, heroPositionX + 1)) == 99) {
                    SoundController.chompSound();
                    ScorePanel.coinScore();
                }
                table.setValueAt(103, heroPositionY, ++heroPositionX);
                table.setValueAt(100, heroPositionY, heroPositionX - 1);
            }
            hero.setHeroPositionX(heroPositionX);
            hero.setHeroPositionY(heroPositionY);
        }
    }

    @Override
    public synchronized void run() {
        while (gameIsRunning) {
            update();
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("gameController ended");
            }
        }
        System.out.println("end");
        interrupt();
    }
}
