package Components.Windows;

import Components.CustomFont;
import Components.CustomJLabel;
import Components.CustomJTable;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow(int sizeOfLevel) {
        setLayout(new BorderLayout());
        setSize(new Dimension(600,600));
        add(new CustomJTable(sizeOfLevel,this),BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
