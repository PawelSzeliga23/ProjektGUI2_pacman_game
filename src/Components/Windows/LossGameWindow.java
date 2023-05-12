package Components.Windows;

import Components.Panels.LossPanel;

import javax.swing.*;

public class LossGameWindow extends JFrame {
    public LossGameWindow(int sizeOfLevel, JFrame currentFrame) {

        add(new LossPanel(sizeOfLevel, this, currentFrame));

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(currentFrame);
    }
}
