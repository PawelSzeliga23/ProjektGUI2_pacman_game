package Data;

public class Hero {
    private int heroPositionX;
    private int heroPositionY;

    public Hero(int heroPositionX, int heroPositionY) {
        this.heroPositionX = heroPositionX;
        this.heroPositionY = heroPositionY;
    }

    public int getHeroPositionX() {
        return heroPositionX;
    }

    public void setHeroPositionX(int heroPositionX) {
        this.heroPositionX = heroPositionX;
    }

    public int getHeroPositionY() {
        return heroPositionY;
    }

    public void setHeroPositionY(int heroPositionY) {
        this.heroPositionY = heroPositionY;
    }
}
