package Components;

import Controllers.GameController;
import Controllers.ImageLoader;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.HashMap;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private final HashMap<Integer, Image> levelComponents;

    public CustomTableCellRenderer() {
        levelComponents = new HashMap<>();
        for (int i = 0; i < 17; i++) {
            levelComponents.put(i, switch (i) {
                case 1 -> ImageLoader.getBarEndDown();
                case 2 -> ImageLoader.getBarEndUp();
                case 3 -> ImageLoader.getVerticalBar();
                case 4 -> ImageLoader.getBarEndRight();
                case 5 -> ImageLoader.getRightDownCorner();
                case 6 -> ImageLoader.getRightUpCorner();
                case 7 -> ImageLoader.getThreeWayIntersectionLeft();
                case 8 -> ImageLoader.getBarEndLeft();
                case 9 -> ImageLoader.getLeftDownCorner();
                case 10 -> ImageLoader.getLeftUpCorner();
                case 11 -> ImageLoader.getThreeWayIntersectionRight();
                case 12 -> ImageLoader.getHorizontalBar();
                case 13 -> ImageLoader.getThreeWayIntersectionUp();
                case 14 -> ImageLoader.getThreeWayIntersectionDown();
                case 15 -> ImageLoader.getFourWayIntersection();
                default -> ImageLoader.getDot();
            });
        }
        levelComponents.put(99, ImageLoader.getCoin());
        levelComponents.put(102, ImageLoader.getPacManClosedUp());
        levelComponents.put(103, ImageLoader.getPacManClosedRight());
        levelComponents.put(104, ImageLoader.getPacManClosedDown());
        levelComponents.put(105, ImageLoader.getPacManClosedLeft());
        levelComponents.put(106, ImageLoader.getPacManOpenUp());
        levelComponents.put(107, ImageLoader.getPacManOpenRight());
        levelComponents.put(108, ImageLoader.getPacManOpenDown());
        levelComponents.put(109, ImageLoader.getPacManOpenLeft());
        levelComponents.put(120, ImageLoader.getBlueGhost());
        levelComponents.put(121, ImageLoader.getPinkGhost());
        levelComponents.put(122, ImageLoader.getOrangeGhost());
        levelComponents.put(123, ImageLoader.getRedGhost());
        levelComponents.put(130, ImageLoader.getBanana());
        levelComponents.put(131, ImageLoader.getFreeze());
        levelComponents.put(132, ImageLoader.getCoinX2());
        levelComponents.put(133, ImageLoader.getFlash());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        try {
        if ((int) table.getValueAt(row, column) == 100) {
            return label;
        }
        ImageIcon icon = new ImageIcon(levelComponents.get((Integer) value));

        Image img = icon.getImage().getScaledInstance(table.getRowHeight(), table.getRowHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));}
        catch (NullPointerException e){
            System.out.println("blad graficzny");
        }
        return label;
    }
}
