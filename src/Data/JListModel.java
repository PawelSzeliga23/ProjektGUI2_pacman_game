package Data;

import javax.swing.*;
import java.util.ArrayList;

public class JListModel extends AbstractListModel {
    ArrayList<Player> playersLeaderBoard;

    public JListModel(ArrayList<Player> playersLeaderBoard) {
        this.playersLeaderBoard = playersLeaderBoard;
    }

    @Override
    public int getSize() {
        return playersLeaderBoard.size();
    }

    @Override
    public Object getElementAt(int index) {
        return playersLeaderBoard.get(index);
    }
}
