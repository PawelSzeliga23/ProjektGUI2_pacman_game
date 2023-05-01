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
        setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (index0 != 0) {
                    super.setSelectionInterval(index0, index1);
                }
            }

            @Override
            public void addSelectionInterval(int index0, int index1) {
                if (index0 != 0) {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
    }
}
