import Components.Windows.MainMenuWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuWindow::new);
    }
}
