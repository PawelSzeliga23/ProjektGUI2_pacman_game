import Components.Windows.MainMenuWindow;
import Controllers.FileStreamController;
import Data.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuWindow::new);
        /*ArrayList<Player> arrayList = new ArrayList<>();
        arrayList.add(new Player("Kasia", 2000));
        FileStreamController.writeFile(arrayList);*/
    }
}
