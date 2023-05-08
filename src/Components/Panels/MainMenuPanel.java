package Components.Panels;

import Components.CustomButton;
import Components.CustomFont;
import Components.CustomJLabel;
import Components.Windows.ExitConfirmationWindow;
import Components.Windows.HighScoreWindow;
import Components.Windows.SizeSetterWindow;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final JFrame actualFrame;
    public static final Dimension preferredSize = new Dimension(650, 500);

    public MainMenuPanel(JFrame jFrame) {
        actualFrame = jFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,5,true));

        CustomButton newGameButton = new CustomButton("New Game");
        CustomButton highScoresButton = new CustomButton("High Scores");
        CustomButton exitButton = new CustomButton("Exit");

        newGameButton.setAlignmentX(CENTER_ALIGNMENT);
        highScoresButton.setAlignmentX(CENTER_ALIGNMENT);
        exitButton.setAlignmentX(CENTER_ALIGNMENT);

        CustomJLabel title = new CustomJLabel("PJATKMAN", CustomFont.TITLE_SIZE);

        add(title);
        add(Box.createVerticalStrut(100));
        add(newGameButton);
        add(Box.createVerticalStrut(30));
        add(highScoresButton);
        add(Box.createVerticalStrut(30));
        add(exitButton);

        setPreferredSize(preferredSize);

        newGameButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            actualFrame.setEnabled(false);
            new SizeSetterWindow(actualFrame);
        }));

        highScoresButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            new HighScoreWindow(actualFrame);
            actualFrame.dispose();
        }));

        exitButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            actualFrame.setEnabled(false);
            ExitConfirmationWindow exitWindow = new ExitConfirmationWindow(actualFrame);
            exitWindow.setLocationRelativeTo(this);
        }));
    }
}
