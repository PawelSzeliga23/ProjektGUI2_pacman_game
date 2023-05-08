package Data;

import Controllers.FileStreamController;
import Controllers.PlayerComparator;

import javax.swing.*;
import java.util.ArrayList;

public class JListModel extends AbstractListModel<Player> {
    ArrayList<Player> playersLeaderBoard;

    public JListModel(ArrayList<Player> playersLeaderBoard) {
        this.playersLeaderBoard = playersLeaderBoard;
    }

    @Override
    public int getSize() {
        return playersLeaderBoard.size();
    }

    @Override
    public Player getElementAt(int index) {
        return playersLeaderBoard.get(index);
    }
    public void addPlayer(Player player){
        playersLeaderBoard.add(player);
        playersLeaderBoard.sort(new PlayerComparator().reversed());
        FileStreamController.writeFile(playersLeaderBoard);
        fireIntervalAdded(this, getSize(),getSize());
    }
    public void removePlayer(int index){
        playersLeaderBoard.remove(index);
        FileStreamController.writeFile(playersLeaderBoard);
        fireIntervalRemoved(this,index,index);
    }
}
