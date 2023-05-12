package Components.Windows;

import Components.Panels.MainMenuPanel;
import Components.Panels.MenuBackgroundPanel;
import Controllers.SoundController;

import javax.swing.*;

public class MainMenuWindow extends JFrame {
    public MainMenuWindow() {
        setTitle("Menu");

        SoundController.mainMenuMusic();

        add(new MenuBackgroundPanel(this));

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(MainMenuPanel.preferredSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
