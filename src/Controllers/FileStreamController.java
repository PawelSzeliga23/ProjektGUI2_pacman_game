package Controllers;

import Data.Player;

import java.io.*;
import java.util.ArrayList;

public class FileStreamController {
    public  static ArrayList<Player>  readFile(){
        try {
            ArrayList<Player> playerLeaderBoard;
            File path = new File("src/Data/LeaderBoard.txt");
            FileInputStream fileInputStream = new FileInputStream(path);
            if (path.length() != 0){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            playerLeaderBoard =(ArrayList<Player>) objectInputStream.readObject();
            objectInputStream.close();
            playerLeaderBoard.sort(new PlayerComparator().reversed());
            }else {
                playerLeaderBoard = new ArrayList<Player>();
            }
            return playerLeaderBoard;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void  writeFile(ArrayList<Player> playerLeaderBoard){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/Data/LeaderBoard.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(playerLeaderBoard);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
