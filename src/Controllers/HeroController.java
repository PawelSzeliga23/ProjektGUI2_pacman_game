package Controllers;

import Components.CustomJTable;
import Components.Panels.ScorePanel;

public class HeroController extends Thread {
    public static boolean heroIsAlive;
    GameController gameController;
    CustomJTable table;
    public static KeyHandler keyHandler;
    private int heroPositionY;
    private int heroPositionX;
    private final int defaultHeroPositionX;
    private final int defaultHeroPositionY;
    public long speed;


    public HeroController(GameController gameController, CustomJTable table, int heroPositionY, int heroPositionX, long speed) {
        heroIsAlive = true;
        this.gameController = gameController;
        this.table = table;
        keyHandler = new KeyHandler(this, table);
        this.heroPositionX = heroPositionX;
        this.heroPositionY = heroPositionY;
        this.defaultHeroPositionX = heroPositionX;
        this.defaultHeroPositionY = heroPositionY;
        this.speed = speed;
        table.setValueAt(103, heroPositionY, heroPositionX);
    }

    public void update() {
        if (possibleMoveUp()) {
            int[] direction = new int[]{-1, 0};
            if(actionChecker(direction))
                setNewPosition(direction, 102);
        } else if (possibleMoveDown()) {
            int[] direction = new int[]{+1, 0};
            if(actionChecker(direction))
                setNewPosition(direction, 104);
        } else if (possibleMoveLeft()) {
            int[] direction = new int[]{0, -1};
            if(actionChecker(direction))
                setNewPosition(direction, 105);
        } else if (possibleMoveRight()) {
            int[] direction = new int[]{0, +1};
            if(actionChecker(direction))
                setNewPosition(direction, 103);
        }
    }


    @Override
    public synchronized void run() {
        while (GameController.gameIsRunning) {
            update();
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("end");
        interrupt();
    }

    private boolean possibleMoveUp() {
        return keyHandler.upAction && heroPositionY - 1 >= 0 &&
                (int) (table.getValueAt(heroPositionY - 1, heroPositionX)) > 98;
    }

    private boolean possibleMoveDown() {
        return keyHandler.downAction && heroPositionY + 1 < table.getRowCount() &&
                (int) (table.getValueAt(heroPositionY + 1, heroPositionX)) > 98;
    }

    private boolean possibleMoveLeft() {
        return keyHandler.leftAction && heroPositionX - 1 >= 0 &&
                (int) (table.getValueAt(heroPositionY, heroPositionX - 1)) > 98;
    }

    private boolean possibleMoveRight() {
        return keyHandler.rightAction && heroPositionY + 1 < table.getRowCount() &&
                (int) (table.getValueAt(heroPositionY, heroPositionX + 1)) > 98;
    }

    private void setNewPosition(int[] direction, int directionValue) {
        int newPositionY = heroPositionY + direction[0];
        int newPositionX = heroPositionX + direction[1];
        table.setValueAt(directionValue, newPositionY, newPositionX);
        table.setValueAt(100, heroPositionY, heroPositionX);
        heroPositionY = newPositionY;
        heroPositionX = newPositionX;
    }

    private synchronized boolean actionChecker(int[] direction) {
        int nextValueInTable = (int) (table.getValueAt(heroPositionY + direction[0], heroPositionX + direction[1]));
        switch (nextValueInTable) {
            case 99 -> {
                gameController.heroGetsCoin();
            }
            case 120, 121, 122, 123 -> {
                gameController.heroDies();
                return false;
            }
        }
        return true;
    }

    public void setDefaultPositions() {
        table.setValueAt(100,heroPositionY,heroPositionX);
        heroPositionY = defaultHeroPositionY;
        heroPositionX = defaultHeroPositionX;
        table.setValueAt(103, defaultHeroPositionY, defaultHeroPositionX);
    }

    public int getHeroPositionY() {
        return heroPositionY;
    }

    public int getHeroPositionX() {
        return heroPositionX;
    }

}

