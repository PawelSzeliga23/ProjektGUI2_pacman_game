package Controllers;

import Components.CustomJTable;

public class AnimationController extends Thread {
    int animationCounter;
    HeroController heroController;
    CustomJTable table;

    public AnimationController(HeroController heroController, CustomJTable table) {
        this.animationCounter = 4;
        this.heroController = heroController;
        this.table = table;
    }

    private void animateHero() {
        int positionX = heroController.getHeroPositionX();
        int positionY = heroController.getHeroPositionY();
        if ((int) (table.getValueAt(positionY, positionX)) > 105) {
            table.setValueAt((int) (table.getValueAt(positionY, positionX)) - animationCounter, positionY, positionX);
        } else if ((int) (table.getValueAt(positionY, positionX)) < 110){
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
