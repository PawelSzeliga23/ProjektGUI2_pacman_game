package Controllers;

import Components.CustomJTable;

public class GameController extends Thread {
    public static boolean gameIsRunning = true;
    CustomJTable table;
    HeroController heroController;
    AnimationController animationController;
    GhostController ghostController1;
    GhostController ghostController2;
    GhostController ghostController3;
    GhostController ghostController4;

    public GameController(CustomJTable table) {
        this.table = table;
        this.heroController = new HeroController(this, table, 1, 1, 280);
        this.animationController = new AnimationController(heroController, table);
        this.ghostController1 = new GhostController(this, table, 300, 120, table.getRowCount() / 2, table.getColumnCount() / 2);
        this.ghostController2 = new GhostController(this, table, 300, 122, 1, table.getColumnCount() - 2);
        this.ghostController3 = new GhostController(this, table, 300, 124, table.getRowCount() - 2, 1);
        this.ghostController4 = new GhostController(this, table, 300, 126, table.getRowCount() - 2, table.getColumnCount() - 2);

    }

    public GhostController getGhostController1() {
        return ghostController1;
    }

    public GhostController getGhostController2() {
        return ghostController2;
    }

    public GhostController getGhostController3() {
        return ghostController3;
    }

    public GhostController getGhostController4() {
        return ghostController4;
    }

    public void start() {
        heroController.start();
        ghostController1.start();
        ghostController2.start();
        ghostController3.start();
        ghostController4.start();
    }
}
