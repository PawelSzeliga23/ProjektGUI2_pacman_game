package Components.Panels;

import Components.CustomJTable;
import Controllers.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class MenuBackgroundPanel extends JPanel {
    public MenuBackgroundPanel(JFrame actualFrame) {
        setLayout(new GridBagLayout());
        add(new MainMenuPanel(actualFrame));
    }

    public MenuBackgroundPanel(Component component) {
        setLayout(new GridLayout(1, 3));
        add(Box.createHorizontalStrut(10));
        add(component);
        add(Box.createHorizontalStrut(10));
    }

    public MenuBackgroundPanel(CustomJTable table) {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                int size = Math.min(getWidth() / table.getColumnCount(), getHeight() / table.getRowCount());

                table.setRowHeight(size);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setMaxWidth(size);
                    table.getColumnModel().getColumn(i).setMinWidth(size);
                }
            }
        });
        add(new TableCastPanel(table));
    }

    @Override
    protected void paintComponent(Graphics g) {
        BufferedImage mainBackground = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = mainBackground.createGraphics();

        double x = (double) getWidth() / ImageLoader.backgroundImage.getWidth(null);
        double y = (double) getHeight() / ImageLoader.backgroundImage.getHeight(null);

        AffineTransform transform = AffineTransform.getScaleInstance(x, y);

        graphics2D.drawImage(ImageLoader.backgroundImage, transform, null);

        g.drawImage(mainBackground, 0, 0, null);
    }
}
