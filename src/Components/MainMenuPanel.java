package Components;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    public static final Dimension preferredSize = new Dimension(650,500);
    public MainMenuPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        CustomButton newGameButton = new CustomButton("New Game");
        CustomButton highScoresButton = new CustomButton("High Scores");
        CustomButton exitButton = new CustomButton("Exit");
        newGameButton.setAlignmentX(CENTER_ALIGNMENT);
        highScoresButton.setAlignmentX(CENTER_ALIGNMENT);
        exitButton.setAlignmentX(CENTER_ALIGNMENT);
        JLabel title = new JLabel("PJATKMAN");
        title.setForeground(Color.YELLOW);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(CustomFont.getFont(CustomFont.TITLE_SIZE));
        add(title);
        add(Box.createVerticalStrut(100));
        add(newGameButton);
        add(Box.createVerticalStrut(30));
        add(highScoresButton);
        add(Box.createVerticalStrut(30));
        add(exitButton);
        setPreferredSize(preferredSize);
    }
}
