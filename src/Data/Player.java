package Data;

import java.io.Serializable;

public record Player(String name, int score) implements Serializable {

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
