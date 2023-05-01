package Components;

import Controllers.SoundController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setBackground(Color.BLACK);
        setForeground(Color.GRAY);
        setFont(CustomFont.getFont(CustomFont.NORMAL_SIZE));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SoundController.clickSound();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(new Color(255, 196, 17, 255));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(Color.YELLOW);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.GRAY);
            }
        });
    }
}
