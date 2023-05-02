package Components;

import javax.swing.*;
import java.awt.*;

public class CustomJLabel extends JLabel {
    public CustomJLabel(String text,float fontSize) {
        super(text);
        setForeground(Color.YELLOW);
        setOpaque(false);
        setFont(CustomFont.getFont(fontSize));
        setHorizontalAlignment(CENTER);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
