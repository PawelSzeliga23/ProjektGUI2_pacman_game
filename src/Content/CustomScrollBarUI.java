package Content;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
//klasa stworzona przy pomocy materialu https://www.youtube.com/watch?v=gxhTjQMqjJY&t=386s
public class CustomScrollBarUI extends BasicScrollBarUI {
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.fill(thumbBounds);
        g2d.setColor(Color.BLACK);
        g2d.draw(thumbBounds);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fill(trackBounds);
        int orientation = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int height;
        if (orientation == JScrollBar.VERTICAL) {
            size = trackBounds.width / 2;
            x = trackBounds.x + ((trackBounds.width - size) / 2);
            y = trackBounds.y;
            width = size;
            height = trackBounds.height;
        } else {
            size = trackBounds.height/2;
            y = trackBounds.y + ((trackBounds.height- size)/2);
            x = 0;
            width = trackBounds.width;
            height = size;
        }
        g2d.setColor(Color.GRAY);
        g2d.fillRect(x,y,width,height);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return blankButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return blankButton();
    }

    private JButton blankButton() {
        JButton button = new JButton();
        Dimension dimension = new Dimension(0,0);
        button.setPreferredSize(dimension);
        button.setMinimumSize(dimension);
        button.setMaximumSize(dimension);
        return button;
    }
}
