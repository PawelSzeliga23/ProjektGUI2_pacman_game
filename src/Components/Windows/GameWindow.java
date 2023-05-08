package Components.Windows;

import Components.CustomJTable;
import Components.Panels.HeartPanel;
import Components.Panels.MenuBackgroundPanel;
import Components.Panels.ScorePanel;
import Controllers.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    CustomJTable table;
    MenuBackgroundPanel backGroundPanel;
    HeartPanel heartPanel;
    ScorePanel scorePanel;
    KeyStroke quitShortcut;

    public GameWindow(int sizeOfLevel) {

        this.table = new CustomJTable(sizeOfLevel);
        this.backGroundPanel = new MenuBackgroundPanel(table);
        heartPanel = new HeartPanel();
        scorePanel = new ScorePanel();

        setBackground(Color.BLACK);
        Action dispose = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.gameIsRunning = false;
                table.getGameController().interrupt();
                getContentPane().removeAll();
                dispose();
                SwingUtilities.invokeLater(MainMenuWindow::new);
            }
        };

        this.quitShortcut = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        table.getInputMap().put(quitShortcut, "dispose");
        table.getActionMap().put("dispose", dispose);

        setLayout(new BorderLayout());

        setSize(new Dimension(600, 600));

        add(new HeartPanel(), BorderLayout.NORTH);
        add(new ScorePanel(), BorderLayout.SOUTH);
        add(backGroundPanel, BorderLayout.CENTER);

        setMinimumSize(new Dimension(200, 200));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
