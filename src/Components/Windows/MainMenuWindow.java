package Components.Windows;

import Components.MainMenuPanel;
import Components.MenuBackgroundPanel;

import javax.swing.*;

public class MainMenuWindow extends JFrame {
    public MainMenuWindow() {
        setTitle("Menu");
        add(new MenuBackgroundPanel());
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(MainMenuPanel.preferredSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
