package Components;

import Controllers.ImageLoader;
import Controllers.LevelGenerator;
import Data.JTableModel;

import javax.swing.*;
import java.awt.*;

public class CustomJTable extends JTable {
    public CustomJTable(int sizeOfLevel, JFrame frame) {
        setBackground(Color.BLACK);
        setShowGrid(false);
        setModel(new JTableModel(LevelGenerator.generateLevel(sizeOfLevel)));
        setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        setRowHeight(frame.getHeight()/getRowCount());
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setPreferredWidth(frame.getWidth()/getColumnCount());
        }
    }

   // @Override
    /*protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < getColumnCount(); i++) {
            for (int j = 0; j < getRowCount(); j++) {
                if ((int) getValueAt(i, j) == 1) {
                    g.setColor(new Color(0,0,0,0));
                    g.fillRect(x, y, 16, 16);
                } else {
                    int sum = 0;
                    if (i - 1 >= 0 && (int) getValueAt(i - 1, j) == 0) {
                        sum += 1;
                    }
                    if (i + 1 < getRowCount() && (int) getValueAt(i + 1, j) == 0) {
                        sum += 2;
                    }
                    if (j - 1 >= 0 && (int) getValueAt(i, j - 1) == 0) {
                        sum += 4;
                    }
                    if (j + 1 < getColumnCount() && (int) getValueAt(i, j + 1) == 0) {
                        sum += 8;
                    }
                    g.drawImage(
                            switch (sum) {
                                case 1 -> ImageLoader.barEndDown;
                                default -> ImageLoader.dot;
                            }, x, y, null
                    );
                }
                x += 16;
            }
            x = 0;
            y += 16;
        }
    }*/
}
