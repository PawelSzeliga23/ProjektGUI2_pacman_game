package Data;

import javax.swing.table.AbstractTableModel;

public class JTableModel extends AbstractTableModel {
    private final int[][] level;

    public JTableModel(int[][] level) {
        this.level = level;
    }

    @Override
    public int getRowCount() {
        return level.length;
    }

    @Override
    public int getColumnCount() {
        return level.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return level[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.level[rowIndex][columnIndex] = (int) (aValue);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
}
