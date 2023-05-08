package Components;

import Controllers.GameController;
import Controllers.KeyHandler;
import Controllers.LevelGenerator;
import Data.JTableModel;

import javax.swing.*;
import java.awt.*;

public class CustomJTable extends JTable {
    KeyHandler keyHandler;
    GameController gameController;

    public CustomJTable(int sizeOfLevel) {
        keyHandler = new KeyHandler();
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        setBackground(Color.BLACK);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setModel(new JTableModel(LevelGenerator.generateLevel(sizeOfLevel)));
        setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        setCellSelectionEnabled(false);
        addKeyListener(keyHandler);
        gameController = new GameController(this, keyHandler);
        gameController.start();
    }

    public GameController getGameController() {
        return gameController;
    }
}
