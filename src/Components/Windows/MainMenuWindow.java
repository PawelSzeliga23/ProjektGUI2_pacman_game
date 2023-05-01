package Components.Windows;

import Components.Panels.MainMenuPanel;
import Components.Panels.MenuBackgroundPanel;

import javax.swing.*;

public class MainMenuWindow extends JFrame {
    public MainMenuWindow() {
        setTitle("Menu");

        add(new MenuBackgroundPanel(this));

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(MainMenuPanel.preferredSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
