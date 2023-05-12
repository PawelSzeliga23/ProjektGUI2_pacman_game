package Components.Windows;

import Components.Panels.WinPanel;

import javax.swing.*;

public class WinGameWindow extends JFrame {
    public WinGameWindow(JFrame gameFrame) {
        add(new WinPanel(this,gameFrame));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
