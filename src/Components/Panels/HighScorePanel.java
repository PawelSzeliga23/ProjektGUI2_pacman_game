package Components.Panels;

import Components.*;
import Components.Windows.IndexNotSelectedExceptionWindow;
import Controllers.SoundController;

import javax.swing.*;
import java.awt.*;

public class HighScorePanel extends JPanel {
    public HighScorePanel(JFrame mainMenu, JFrame highScoreWindow) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);


        JLabel head = new JLabel("High Scores Board");
        head.setFont(CustomFont.getFont(CustomFont.TITLE_SIZE));
        head.setForeground(Color.YELLOW);
        head.setHorizontalAlignment(SwingConstants.CENTER);

        CustomJList list = new CustomJList();
        CustomJScrollPane scrollPane = new CustomJScrollPane(list);
        MenuBackgroundPanel menuBackgroundPanel = new MenuBackgroundPanel(scrollPane);

        JPanel panel = new JPanel(new FlowLayout());

        panel.setBackground(Color.BLACK);

        CustomButton backButton = new CustomButton("Back");
        CustomButton deleteButton = new CustomButton("Delete Score");

        backButton.addActionListener(e ->{
            mainMenu.setEnabled(true);
            SoundController.clickSound();
            highScoreWindow.dispose();
        });

        deleteButton.addActionListener(e -> {
            int i = list.getSelectedIndex();
            if (i < 0){
                SwingUtilities.invokeLater(() -> {
                    highScoreWindow.setEnabled(false);
                    new IndexNotSelectedExceptionWindow(highScoreWindow);
                });
            }
        });

        panel.add(backButton);
        panel.add(Box.createHorizontalStrut(100));
        panel.add(deleteButton);

        add(head, BorderLayout.NORTH);
        add(menuBackgroundPanel,BorderLayout.CENTER);
        add(panel, BorderLayout.PAGE_END);
    }
}
