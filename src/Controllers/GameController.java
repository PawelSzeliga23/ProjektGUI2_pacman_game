package Controllers;

import Components.CustomJTable;
import Components.Panels.HeartPanel;
import Components.Panels.ScorePanel;
import Components.Windows.LossGameWindow;
import Components.Windows.WinGameWindow;

import javax.swing.*;

public class GameController extends Thread {
    public static boolean gameIsRunning;
    private int heartCounter;
    private int coinCounter;
    JFrame currentFrame;
    CustomJTable table;
    HeroController heroController;
    AnimationController animationController;
    GhostController ghostController1;
    GhostController ghostController2;
    GhostController ghostController3;
    GhostController ghostController4;

    public GameController(CustomJTable table, int coinCounter, JFrame currentFrame) {
        gameIsRunning = true;
        this.currentFrame = currentFrame;
        this.heartCounter = 4;
        this.coinCounter = coinCounter - 1;
        this.table = table;
        this.heroController = new HeroController(this, table, 1, 1, 280);
        this.animationController = new AnimationController(heroController, table);
        this.ghostController1 = new GhostController(this, table, 300, 120, table.getRowCount() / 2, table.getColumnCount() / 2);
        this.ghostController2 = new GhostController(this, table, 300, 121, 1, table.getColumnCount() - 2);
        this.ghostController3 = new GhostController(this, table, 300, 122, table.getRowCount() - 2, 1);
        this.ghostController4 = new GhostController(this, table, 300, 123, table.getRowCount() - 2, table.getColumnCount() - 2);
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
        animationController.start();
        ghostController1.start();
        ghostController2.start();
        ghostController3.start();
        ghostController4.start();
    }
    public void heroDies(){
        heroController.setDefaultPositions();
        ghostController1.setDefaultPositions();
        ghostController2.setDefaultPositions();
        ghostController3.setDefaultPositions();
        ghostController4.setDefaultPositions();
        HeartPanel.emptyHeartSlot(heartCounter--);
        if (heartCounter == -1){
            gameIsRunning = false;
            SwingUtilities.invokeLater(() -> new LossGameWindow(table.getRowCount(),currentFrame));
        }
    }
    public void heroGetsCoin(){
        SoundController.chompSound();
        ScorePanel.coinScore();
        coinCounter--;
        if (coinCounter == 0){
            gameIsRunning = false;
            SwingUtilities.invokeLater(() -> {
                new WinGameWindow(currentFrame);
            });
        }
    }
}
