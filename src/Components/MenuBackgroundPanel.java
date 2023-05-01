package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class MenuBackgroundPanel extends JPanel {
    public MenuBackgroundPanel() {
        setLayout(new GridBagLayout());
        add(new MainMenuPanel());
    }

    @Override
    protected void paintComponent(Graphics g) {
        BufferedImage mainBackground = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = mainBackground.createGraphics();
        Image image = new ImageIcon("src/Content/Images/MenuBackground.png").getImage();
        double x = (double) getWidth() / image.getWidth(null);
        double y = (double) getHeight() / image.getHeight(null);
        AffineTransform transform = AffineTransform.getScaleInstance(x, y);
        graphics2D.drawImage(image, transform, null);
        g.drawImage(mainBackground, 0, 0, null);
    }
}
