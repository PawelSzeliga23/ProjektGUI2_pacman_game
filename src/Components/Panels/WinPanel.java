package Components.Panels;

import Components.*;
import Components.Windows.MainMenuWindow;
import Data.JListModel;
import Data.Player;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends JPanel {
    public WinPanel(JFrame currentFrame, JFrame gameFrame) {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        CustomJLabel textLabel = new CustomJLabel("Congratulations", CustomFont.TITLE_SIZE);

        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(Color.BLACK);

        CustomJLabel textFieldTitle = new CustomJLabel("Enter nickname:", CustomFont.NORMAL_SIZE);

        JTextField nickField = new JTextField();
        nickField.setFont(CustomFont.getFont(CustomFont.NORMAL_SIZE));
        nickField.setForeground(Color.YELLOW);
        nickField.setBackground(Color.BLACK);
        nickField.setPreferredSize(new Dimension(400, 40));

        textPanel.add(textFieldTitle);
        textPanel.add(nickField);

        CustomButton mainMenuButton = new CustomButton("Main Menu");

        mainMenuButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            JListModel model = (JListModel) HighScorePanel.list.getModel();
            model.addPlayer(new Player(nickField.getText(), ScorePanel.score));
            HighScorePanel.list.setModel(model);
            currentFrame.dispose();
            gameFrame.dispose();
            new MainMenuWindow();
        }));

        add(textLabel, BorderLayout.NORTH);
        add(mainMenuButton, BorderLayout.SOUTH);
        add(textPanel, BorderLayout.CENTER);
    }
}
