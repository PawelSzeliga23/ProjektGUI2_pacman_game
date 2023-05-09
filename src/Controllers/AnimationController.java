package Controllers;

import Components.CustomJTable;
import Data.Hero;

public class AnimationController extends Thread {
    int animationCounter;
    Hero hero;
    CustomJTable table;

    public AnimationController(Hero hero, CustomJTable table) {
        this.animationCounter = 4;
        this.hero = hero;
        this.table = table;
    }

    private void animateHero() {
        int positionX = hero.getHeroPositionX();
        int positionY = hero.getHeroPositionY();
        if ((int) (table.getValueAt(positionY, positionX)) > 105) {
            table.setValueAt((int) (table.getValueAt(positionY, positionX)) - animationCounter, positionY, positionX);
        } else {
            table.setValueAt((int) (table.getValueAt(positionY, positionX)) + animationCounter, positionY, positionX);
        }
    }

    @Override
    public synchronized void run() {
        while (GameController.gameIsRunning) {
            animateHero();
            try {
                sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        interrupt();
    }
}
