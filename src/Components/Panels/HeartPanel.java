package Components.Panels;

import Controllers.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class HeartPanel extends JPanel {
    private static final ImageIcon fullHeart = new ImageIcon(ImageLoader.getFullHeart().getScaledInstance(32,32,Image.SCALE_SMOOTH));
    private static final ImageIcon emptyHeart =new ImageIcon(ImageLoader.getEmptyHeart().getScaledInstance(32,32,Image.SCALE_SMOOTH));

    private static final JLabel[] heartSlots = new JLabel[5];

    public HeartPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,1,true));
        for (int i = 0; i < heartSlots.length; i++) {
            heartSlots[i] = new JLabel();
            heartSlots[i].setIcon(fullHeart);
            add(heartSlots[i]);
        }
    }
    public static void emptyHeartSlot(int index){
        if (index < 5){
            heartSlots[index].setIcon(emptyHeart);
        }
    }
}
