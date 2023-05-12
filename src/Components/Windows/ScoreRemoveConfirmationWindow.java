package Components.Windows;

import Components.CustomButton;
import Components.CustomFont;
import Components.CustomJLabel;
import Components.CustomJList;
import Controllers.SoundController;
import Data.JListModel;
import Data.Player;

import javax.swing.*;
import java.awt.*;

public class ScoreRemoveConfirmationWindow extends JFrame {
    public ScoreRemoveConfirmationWindow(JFrame highScoreWindow, CustomJList list, int index) {
        setTitle(":(");

        JListModel model = (JListModel) list.getModel();
        Player player = model.getElementAt(index);

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setBackground(Color.BLACK);
        confirmationPanel.setLayout(new BoxLayout(confirmationPanel, BoxLayout.Y_AXIS));

        JPanel confirmationButtonsPanel = new JPanel(new FlowLayout());
        confirmationButtonsPanel.setBackground(Color.BLACK);

        CustomJLabel questionText = new CustomJLabel("Are you sure you want to remove:", CustomFont.NORMAL_SIZE);
        CustomJLabel playerScore = new CustomJLabel(player.name() + " with " + player.score() + " points", CustomFont.NORMAL_SIZE);

        CustomButton yesButton = new CustomButton("Yes");
        CustomButton noButton = new CustomButton("No");

        yesButton.addActionListener(e -> {
            highScoreWindow.setEnabled(true);
            SoundController.clickSound();
            model.removePlayer(index);
            dispose();
        });

        noButton.addActionListener(e -> {
            highScoreWindow.setEnabled(true);
            SoundController.clickSound();
            dispose();
        });

        confirmationButtonsPanel.add(yesButton);
        confirmationButtonsPanel.add(noButton);

        confirmationPanel.add(questionText);
        confirmationPanel.add(playerScore);
        confirmationPanel.add(confirmationButtonsPanel);

        add(confirmationPanel);

        pack();
        setLocationRelativeTo(highScoreWindow);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 120));
        setResizable(false);
        setVisible(true);
    }
}
