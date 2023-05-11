package Components;

import Controllers.*;
import Data.JTableModel;

import javax.swing.*;
import java.awt.*;

public class CustomJTable extends JTable {
    GameController gameController;

    public CustomJTable(int sizeOfLevel) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        setBackground(Color.BLACK);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setModel(new JTableModel(LevelGenerator.generateLevel(sizeOfLevel)));
        setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        setCellSelectionEnabled(false);
        gameController = new GameController(this);
        addKeyListener(HeroController.keyHandler);
        gameController.start();
    }
}
