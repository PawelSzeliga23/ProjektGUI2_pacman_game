package Components;

import Controllers.FileStreamController;
import Data.JListModel;

import javax.swing.*;
import java.awt.*;

public class CustomJList extends JList {
    public CustomJList() {
        setBackground(Color.BLACK);
        setModel(new JListModel(FileStreamController.readFile()));
        setCellRenderer(new CustomListCellRenderer());
    }
}
