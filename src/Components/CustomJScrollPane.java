package Components;

import Content.CustomScrollBarUI;

import javax.swing.*;
import java.awt.*;
//klasa została utworzona z pomoca dokumentacji https://docs.oracle.com/javase/8/docs/api/javax/swing/JScrollPane.html
public class CustomJScrollPane extends JScrollPane {
    public CustomJScrollPane(Component component) {
        super(component);
        setBackground(Color.BLACK);

        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        getVerticalScrollBar().setUI(new CustomScrollBarUI());
        getHorizontalScrollBar().setUI(new CustomScrollBarUI());

        setPreferredSize(new Dimension(150, 100));
        setBorder(null);
    }
}
