package Data;

import Controllers.PlayerComparator;

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
    public void addPlayer(Player player){
        playersLeaderBoard.add(player);
        playersLeaderBoard.sort(new PlayerComparator());
    }
    public void removePlayer(int index){
        playersLeaderBoard.remove(index);
        fireIntervalRemoved(this,index,index);
    }
}
