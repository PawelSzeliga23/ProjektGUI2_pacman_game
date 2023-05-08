package Components.Panels;

import Components.CustomJTable;

import javax.swing.*;
import java.awt.*;

public class TableCastPanel extends JPanel {
    public TableCastPanel(CustomJTable table) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        setBackground(Color.BLACK);
        add(table);
    }
}
