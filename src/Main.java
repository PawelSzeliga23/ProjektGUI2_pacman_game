import Components.Windows.MainMenuWindow;
import Controllers.FileStreamController;
import Controllers.LevelGenerator;
import Data.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuWindow::new);
        ArrayList<Player> arrayList = new ArrayList<>();
        arrayList.add(new Player("a",Integer.MAX_VALUE));
        FileStreamController.writeFile(arrayList);
    }
}