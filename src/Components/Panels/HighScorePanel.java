package Components.Panels;

import Components.*;
import Components.Windows.IndexNotSelectedExceptionWindow;
import Controllers.SoundController;

import javax.swing.*;
import java.awt.*;
//border factory z tego filmiku https://www.youtube.com/watch?v=Eb2QydjQvV4
public class HighScorePanel extends JPanel {
    public HighScorePanel(JFrame mainMenu, JFrame highScoreWindow) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        CustomJLabel head = new CustomJLabel("High Scores Board", CustomFont.TITLE_SIZE);
        head.setBorder(BorderFactory.createLineBorder(Color.GRAY,5,true));

        CustomJList list = new CustomJList();
        CustomJScrollPane scrollPane = new CustomJScrollPane(list);
        MenuBackgroundPanel menuBackgroundPanel = new MenuBackgroundPanel(scrollPane);

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY,5,true));

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
