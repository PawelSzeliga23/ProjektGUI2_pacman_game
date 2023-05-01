package Components.Panels;

import Components.CustomButton;
import Components.CustomFont;
import Components.Windows.ExitConfirmationWindow;
import Components.Windows.HighScoreWindow;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final JFrame actualFrame;
    public static final Dimension preferredSize = new Dimension(650, 500);

    public MainMenuPanel(JFrame jFrame) {
        actualFrame = jFrame;
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
        highScoresButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            actualFrame.setEnabled(false);
            new HighScoreWindow(actualFrame);
        }));

        exitButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            actualFrame.setEnabled(false);
            ExitConfirmationWindow exitWindow = new ExitConfirmationWindow(actualFrame);
            exitWindow.setLocationRelativeTo(this);
        }));
    }
}
