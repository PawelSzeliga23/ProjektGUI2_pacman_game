package Components.Panels;

import Components.CustomButton;
import Components.CustomFont;
import Components.CustomJLabel;
import Components.Windows.GameWindow;
import Components.Windows.MainMenuWindow;

import javax.swing.*;
import java.awt.*;

public class LossPanel extends JPanel {
    public LossPanel(int sizeOfLevel, JFrame currentFrame, JFrame lastGameFrame) {
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        CustomJLabel textLabel = new CustomJLabel("Game Over", CustomFont.TITLE_SIZE);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.BLACK);

        CustomButton tryAgainButton = new CustomButton("Try Again");
        CustomButton mainMenuButton = new CustomButton("Main Menu");

        tryAgainButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            currentFrame.dispose();
            lastGameFrame.dispose();
            new GameWindow(sizeOfLevel);
        }));
        mainMenuButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            currentFrame.dispose();
            lastGameFrame.dispose();
            new MainMenuWindow();
        }));

        buttonPanel.add(tryAgainButton);
        buttonPanel.add(mainMenuButton);

        add(textLabel);
        add(buttonPanel);
    }
}
