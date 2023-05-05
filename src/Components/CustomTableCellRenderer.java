package Components;

import Controllers.ImageLoader;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if ((int) value != 1) {
            int cellWidth = table.getColumnModel().getColumn(column).getWidth();
            int cellHeight = table.getRowHeight();

            int sum = 0;

            if (row - 1 >= 0 && (int) table.getValueAt(row - 1, column) == 0) {
                sum += 1;
            }
            if (row + 1 < table.getRowCount() && (int) table.getValueAt(row + 1, column) == 0) {
                sum += 2;
            }
            if (column - 1 >= 0 && (int) table.getValueAt(row, column - 1) == 0) {
                sum += 4;
            }
            if (column + 1 < table.getColumnCount() && (int) table.getValueAt(row, column + 1) == 0) {
                sum += 8;
            }


            ImageIcon icon = new ImageIcon(switch (sum) {
                case 1 -> ImageLoader.barEndDown;
                case 2 -> ImageLoader.barEndUp;
                case 3 -> ImageLoader.verticalBar;
                case 4 -> ImageLoader.barEndRight;
                case 5 -> ImageLoader.cornerRD;
                case 6 -> ImageLoader.cornerRU;
                case 7 -> ImageLoader.threeWayIntersectionLeft;
                case 8 -> ImageLoader.barEndLeft;
                case 9 -> ImageLoader.cornerLD;
                case 10 -> ImageLoader.cornerLU;
                case 11 -> ImageLoader.threeWayIntersectionRight;
                case 12 -> ImageLoader.horizontalBar;
                case 13 -> ImageLoader.threeWayIntersectionUp;
                case 14 -> ImageLoader.threeWayIntersectionDown;
                case 15 -> ImageLoader.fourWayIntersection;
                default -> ImageLoader.dot;
            });
            Image img = icon.getImage().getScaledInstance(cellWidth, cellHeight, Image.SCALE_FAST);
            label.setIcon(new ImageIcon(img));
        }
        return label;
    }
}
