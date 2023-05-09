package Controllers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    public static final Image backgroundImage = getBackgroundImage();

    public static Image getBackgroundImage() {
        try {
            return ImageIO.read(new File("src/Content/Images/MenuBackground.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getLeftDownCorner() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/corner_LD.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getLeftUpCorner() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/corner_LU.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getRightUpCorner() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/corner_RU.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getRightDownCorner() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/corner_RD.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getBarEndRight() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/barEndRIGHT.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getBarEndLeft() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/barEndLEFT.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getBarEndDown() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/barEndDOWN.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getBarEndUp() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/barEndUP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getHorizontalBar() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/horizontalBar.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getVerticalBar() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/verticalBar.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getThreeWayIntersectionRight() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/threeWayIntersectionRIGHT.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getThreeWayIntersectionLeft() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/threeWayIntersectionLEFT.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getThreeWayIntersectionUp() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/threeWayIntersectionUP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getThreeWayIntersectionDown() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/threeWayIntersectionDOWN.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getDot() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/dot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getFourWayIntersection() {
        try {
            return ImageIO.read(new File("src/Content/Images/LevelComponents/fourWayIntersection.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getFullHeart() {
        try {
            return ImageIO.read((new File("src/Content/Icons/full_heart.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getEmptyHeart() {
        try {
            return ImageIO.read((new File("src/Content/Icons/empty_heart.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManClosedRight() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManClosedRight.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManClosedUp() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManClosedUp.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManClosedDown() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManClosedDown.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManClosedLeft() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManClosedLeft.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManOpenRight() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManOpenRight.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManOpenUp() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManOpenUp.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManOpenLeft() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManOpenLeft.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getPacManOpenDown() {
        try {
            return ImageIO.read((new File("src/Content/Icons/PacManOpenDown.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Image getCoin() {
        try {
            return ImageIO.read((new File("src/Content/Icons/coin.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Image getBlueGhost() {
        try {
            return ImageIO.read((new File("src/Content/Icons/blueGhost.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Image getOrangeGhost() {
        try {
            return ImageIO.read((new File("src/Content/Icons/orangeGhost.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Image getRedGhost() {
        try {
            return ImageIO.read((new File("src/Content/Icons/redGhost.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Image getPinkGhost() {
        try {
            return ImageIO.read((new File("src/Content/Icons/pinkGhost.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
