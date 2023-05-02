package Components;

import Data.Player;

import javax.swing.*;
import java.awt.*;

public class CustomListCellRenderer extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Player player = (Player) value;

        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
        setFont(CustomFont.getFont(CustomFont.NORMAL_SIZE));
        setForeground(Color.YELLOW);
        setOpaque(false);

        if (index == 0){
            setText("Number  Name  Score");
        }else {
            setText(index + ". " + player.getName() + " " + player.getScore());

            if (isSelected) {
                setForeground(new Color(255, 196, 17, 255));
            }
        }
        return this;
    }
}
