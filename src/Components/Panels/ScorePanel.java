package Components.Panels;

import Components.CustomFont;
import Components.CustomJLabel;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    public static int score;
    static CustomJLabel scoreLabel;

    public ScorePanel() {
        ScorePanel.score = 0;
        scoreLabel = new CustomJLabel("Score : " + score, CustomFont.NORMAL_SIZE);
        setBackground(Color.black);
        add(scoreLabel);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
    }

    public static void coinScore() {
        score += 10;
        scoreLabel.setText("Score : " + score);
    }

    public static void bananaScore() {
        score += 200;
        scoreLabel.setText("Score : " + score);
    }

    public static void coinX2Score() {
        score += 20;
        scoreLabel.setText("Score : " + score);
    }
}
