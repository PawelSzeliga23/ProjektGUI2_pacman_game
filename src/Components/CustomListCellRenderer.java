package Components;

import Data.Player;

import javax.swing.*;
import java.awt.*;

public class CustomListCellRenderer extends JLabel implements ListCellRenderer {
    public CustomListCellRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Player player = (Player) value;

        setText(index + 1 + ". " + player.getName() + " " + player.getScore());
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
        setFont(CustomFont.getFont(CustomFont.NORMAL_SIZE));
        setForeground(Color.YELLOW);

        if (isSelected) {
            setForeground(new Color(255, 196, 17, 255));
        }

        return this;
    }
}
