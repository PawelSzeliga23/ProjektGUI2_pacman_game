package Controllers;

import Components.CustomJLabel;
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
        /*System.out.println(positionX);
        System.out.println(positionY);*/
        if ((int)(table.getValueAt(positionY,positionX)) > 105) {
            table.setValueAt((int) (table.getValueAt(positionY, positionX)) - animationCounter, positionY, positionX);
        } else{
            table.setValueAt((int) (table.getValueAt(positionY, positionX)) + animationCounter, positionY, positionX);
        }
/*
        System.out.println(table.getValueAt(positionY, positionX ));
*/
    }

    @Override
    public synchronized void run() {
        while (GameController.gameIsRunning){
            System.out.println("Dupa");
            animateHero();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
