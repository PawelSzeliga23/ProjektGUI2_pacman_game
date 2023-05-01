package Components.Panels;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class HighScorePanel extends JPanel {
    public HighScorePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);


        JLabel head = new JLabel("High Scores Board");
        head.setFont(CustomFont.getFont(CustomFont.TITLE_SIZE));
        head.setForeground(Color.YELLOW);
        head.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new FlowLayout());

        panel.setBackground(Color.BLACK);

        CustomButton backButton = new CustomButton("Back");
        CustomButton deleteButton = new CustomButton("Delete Score");

        panel.add(backButton);
        panel.add(Box.createHorizontalStrut(100));
        panel.add(deleteButton);

        add(head, BorderLayout.NORTH);
        add(new MenuBackgroundPanel(new CustomJScrollPane(new CustomJList())),BorderLayout.CENTER);
        add(panel, BorderLayout.PAGE_END);
    }
}
