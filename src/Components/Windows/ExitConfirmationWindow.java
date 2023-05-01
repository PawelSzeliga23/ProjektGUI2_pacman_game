package Components.Windows;

import Components.CustomButton;
import Components.CustomFont;
import Controllers.SoundController;

import javax.swing.*;
import java.awt.*;

public class ExitConfirmationWindow extends JFrame {
    private final JFrame frameToClose;

    public ExitConfirmationWindow(JFrame jFrame) {
        frameToClose = jFrame;
        setTitle(":(");

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setBackground(Color.BLACK);
        confirmationPanel.setLayout(new BoxLayout(confirmationPanel, BoxLayout.Y_AXIS));

        JPanel confirmationButtonsPanel = new JPanel(new FlowLayout());
        confirmationButtonsPanel.setBackground(Color.BLACK);

        JLabel questionText = new JLabel("Are you sure you wont to exit?");
        questionText.setForeground(Color.YELLOW);
        questionText.setFont(CustomFont.getFont(CustomFont.NORMAL_SIZE));
        questionText.setAlignmentX(Component.CENTER_ALIGNMENT);

        CustomButton yesButton = new CustomButton("Yes");
        CustomButton noButton = new CustomButton("No");

        yesButton.addActionListener(e -> {
            SoundController.clickSound();
            dispose();
            frameToClose.dispose();
        });

        noButton.addActionListener(e -> {
            frameToClose.setEnabled(true);
            SoundController.clickSound();
            dispose();
        });

        confirmationPanel.add(questionText);
        confirmationButtonsPanel.add(yesButton);
        confirmationButtonsPanel.add(noButton);
        confirmationPanel.add(confirmationButtonsPanel);

        add(confirmationPanel);

        pack();
        setLocationRelativeTo(jFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900,120));
        setResizable(false);
        setVisible(true);
    }
}
