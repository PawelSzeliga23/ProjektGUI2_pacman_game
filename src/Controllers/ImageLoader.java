package Controllers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    public static final Image backgroundImage = getBackgroundImage();
    public static final Image cornerLD = getLeftDownCorner();
    public static final Image cornerLU = getLeftUpCorner();
    public static final Image cornerRD = getRightDownCorner();
    public static final Image cornerRU = getRightUpCorner();
    public static final Image barEndUp = getBarEndUp();
    public static final Image barEndDown = getBarEndDown();
    public static final Image barEndLeft = getBarEndLeft();
    public static final Image barEndRight = getBarEndRight();
    public static final Image horizontalBar = getHorizontalBar();
    public static final Image verticalBar = getVerticalBar();
    public static final Image threeWayIntersectionUp = getThreeWayIntersectionUp();
    public static final Image threeWayIntersectionDown = getThreeWayIntersectionDown();
    public static final Image threeWayIntersectionLeft = getThreeWayIntersectionLeft();
    public static final Image threeWayIntersectionRight = getThreeWayIntersectionRight();
    public static final Image dot = getDot();
    public static final Image fourWayIntersection = getFourWayIntersection();

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
}
