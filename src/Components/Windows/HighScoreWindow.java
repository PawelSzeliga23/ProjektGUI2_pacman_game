package Components.Windows;

import Components.Panels.HighScorePanel;
import javax.swing.*;
import java.awt.*;

public class HighScoreWindow extends JFrame {
    public HighScoreWindow(JFrame jFrame) throws HeadlessException {
        setTitle("High Scores");
        HighScorePanel highScorePanel = new HighScorePanel();
        add(highScorePanel);
        pack();
        setLocationRelativeTo(jFrame);
        setMinimumSize(new Dimension(highScorePanel.getWidth()+100,highScorePanel.getHeight()+100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
