package Components.Panels;

import Controllers.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class HeartPanel extends JPanel {
    private final ImageIcon fullHeart;
    private final ImageIcon emptyHeart;

    private final JLabel[] heartSlots;

    public HeartPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,1,true));
        this.fullHeart = new ImageIcon(ImageLoader.getFullHeart().getScaledInstance(32,32,Image.SCALE_SMOOTH));
        this.emptyHeart = new ImageIcon(ImageLoader.getEmptyHeart());
        heartSlots = new JLabel[5];
        for (JLabel label : heartSlots) {
            label = new JLabel();
            label.setIcon(fullHeart);
            add(label);
        }
    }
    public void emptyHeartSlot(int index){
        if (index < 5){
            heartSlots[index].setIcon(emptyHeart);
        }
    }
}
