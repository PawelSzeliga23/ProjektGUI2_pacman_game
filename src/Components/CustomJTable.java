package Components;

import Controllers.*;
import Data.Hero;
import Data.JTableModel;

import javax.swing.*;
import java.awt.*;

public class CustomJTable extends JTable {
    KeyHandler keyHandler;
    GameController gameController;
    Hero hero;
    AnimationController animationController;
    Object synchronizer;

    public CustomJTable(int sizeOfLevel) {
        this.synchronizer = new Object();
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        setBackground(Color.BLACK);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setModel(new JTableModel(LevelGenerator.generateLevel(sizeOfLevel)));
        setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        setCellSelectionEnabled(false);
        boolean heroPositionFound = false;
        for (int i = 0; i < getRowCount() && !heroPositionFound; i++) {
            for (int j = 0; j < getRowCount() && !heroPositionFound; j++) {
                if ((int) (getValueAt(i, j)) == 99) {
                    this.hero = new Hero(i, j);
                    setValueAt(102, i, j);
                    heroPositionFound = true;
                }
            }
        }
        GhostController ghostController1 = new GhostController(this,300,20,getRowCount()/2,getRowCount()/2);
        //GhostController ghostController2 = new GhostController(this,300,22,getRowCount()/2,getRowCount()/2);
        //GhostController ghostController3 = new GhostController(this,300,124,getRowCount()/2,getRowCount()/2);
        //GhostController ghostController4 = new GhostController(this,300,126,getRowCount()/2,getRowCount()/2);
        keyHandler = new KeyHandler(hero, this);
        addKeyListener(keyHandler);
        gameController = new GameController(this, keyHandler, hero, 300);
        this.animationController = new AnimationController(hero, this);
        gameController.start();
        animationController.start();
        ghostController1.start();
        //ghostController2.start();
        //ghostController3.start();
        //ghostController4.start();
    }
}
