package Components;

import Controllers.*;
import Data.JTableModel;

import javax.swing.*;
import java.awt.*;

public class CustomJTable extends JTable {
    GameController gameController;

    public CustomJTable(int sizeOfLevel, JFrame currentFrame) {
        int[][][] levelInformation = LevelGenerator.generateLevel(sizeOfLevel);
        int[][] level = levelInformation[0];
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        setBackground(Color.BLACK);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setModel(new JTableModel(level));
        setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        setCellSelectionEnabled(false);
        gameController = new GameController(this, levelInformation[1][0][0], currentFrame);
        addKeyListener(HeroController.keyHandler);
        gameController.start();
    }
}
