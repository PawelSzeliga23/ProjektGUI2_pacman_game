package Components.Windows;

import Components.Panels.HighScorePanel;
import javax.swing.*;
import java.awt.*;

public class HighScoreWindow extends JFrame {
    public HighScoreWindow(JFrame mainMenu) throws HeadlessException {
        setTitle("High Scores");
        HighScorePanel highScorePanel = new HighScorePanel(mainMenu, this);
        add(highScorePanel);
        pack();
        setLocationRelativeTo(mainMenu);
        setMinimumSize(new Dimension(highScorePanel.getWidth()+100,highScorePanel.getHeight()+100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
