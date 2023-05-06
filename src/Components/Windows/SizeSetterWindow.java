package Components.Windows;

import Components.CustomButton;
import Components.CustomFont;
import Components.CustomJLabel;
import Controllers.SoundController;

import javax.swing.*;
import java.awt.*;

public class SizeSetterWindow extends JFrame {
    public SizeSetterWindow(JFrame mainMenu) throws HeadlessException {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.setBackground(Color.BLACK);


        JSlider slider = new JSlider(JSlider.HORIZONTAL, 10,100,10);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setBackground(Color.BLACK);
        slider.setForeground(Color.YELLOW);

        CustomJLabel head = new CustomJLabel("Select game size", CustomFont.NORMAL_SIZE);
        head.setBorder(BorderFactory.createLineBorder(Color.GRAY,5,true));
        CustomJLabel currentValue = new CustomJLabel("Value : 10", CustomFont.NORMAL_SIZE);


        slider.addChangeListener(e -> {
            int value = slider.getValue();
            currentValue.setText("Value : " + value);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY,5,true));

        CustomButton backButton = new CustomButton("Back");
        CustomButton startGame = new CustomButton("Start");

        backButton.addActionListener(e -> {
            SoundController.clickSound();
            mainMenu.setEnabled(true);
            this.dispose();
        });

        startGame.addActionListener(e -> SwingUtilities.invokeLater(() ->{
            new GameWindow(slider.getValue());
        }));

        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        buttonPanel.add(startGame);

        panel.add(head);
        panel.add(slider);
        panel.add(currentValue);
        panel.add(buttonPanel);

        add(panel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500,250));
        setLocationRelativeTo(mainMenu);
        setVisible(true);
    }
}
