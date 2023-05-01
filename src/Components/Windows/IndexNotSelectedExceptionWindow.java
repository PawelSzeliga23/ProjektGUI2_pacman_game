package Components.Windows;

import Components.CustomButton;
import Components.CustomFont;
import Controllers.SoundController;

import javax.swing.*;
import java.awt.*;

public class IndexNotSelectedExceptionWindow extends JFrame {
    public IndexNotSelectedExceptionWindow(JFrame highScoreWindow) {
        SoundController.errorSound();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel head = new JLabel("Index not selected");
        head.setFont(CustomFont.getFont(CustomFont.NORMAL_SIZE));
        head.setForeground(Color.YELLOW);
        head.setHorizontalAlignment(SwingConstants.CENTER);

        CustomButton okButton = new CustomButton("OK");
        okButton.setHorizontalAlignment(SwingConstants.CENTER);

        okButton.addActionListener(e -> {
            SoundController.clickSound();
            highScoreWindow.setEnabled(true);
            this.dispose();
        });

        panel.setBackground(Color.BLACK);

        panel.add(head, BorderLayout.NORTH);
        panel.add(okButton, BorderLayout.SOUTH);

        add(panel);

        pack();
        setResizable(false);
        setLocationRelativeTo(highScoreWindow);
        setVisible(true);
    }
}
