package Components;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomFont {
    public static final float NORMAL_SIZE = 35f;
    public static final float TITLE_SIZE = 80f;

    public static Font getFont(float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File("src/Content/Font.TTF")).deriveFont(size);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
