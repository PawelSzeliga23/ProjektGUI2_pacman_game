package Data;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
