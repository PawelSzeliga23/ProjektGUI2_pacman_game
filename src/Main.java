import Components.Windows.HighScoreWindow;
import Components.Windows.MainMenuWindow;
import Controllers.FileStreamController;
import Data.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuWindow::new);
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("ADAM1",12000);
        players.add(player1);
        Player player2 = new Player("ADAM2",121230);
        players.add(player2);
        Player player3 = new Player("ADAM3",12122600);
        Player player4 = new Player("ADAM4",121830);
        for (int i = 0; i < 10; i++) {
            players.add(new Player("A", 200));
        }
        players.add(player3);
        players.add(player4);

        FileStreamController.writeFile(players);
        System.out.println(FileStreamController.readFile());
    }
}
