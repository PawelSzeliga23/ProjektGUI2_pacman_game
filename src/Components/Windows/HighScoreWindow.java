package Components.Windows;

import Components.Panels.HighScorePanel;
import javax.swing.*;
import java.awt.*;

public class HighScoreWindow extends JFrame {
    public HighScoreWindow(JFrame mainMenu) {
        setTitle("High Scores");
        HighScorePanel highScorePanel = new HighScorePanel( this);
        add(highScorePanel);
        pack();
        setLocationRelativeTo(mainMenu);
        setMinimumSize(new Dimension(highScorePanel.getWidth()+100,highScorePanel.getHeight()+100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
