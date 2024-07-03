package Vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Fuentes {


    private static Font playwriteFont;
    private static Font robotoFont;
    private static Font aptosblackFont;

    static {
        try {
            playwriteFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuentes/PLAYWRITEITMODERNA-REGULAR.ttf")).deriveFont(18f);
            robotoFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuentes/Roboto-Regular.ttf")).deriveFont(18f);
            aptosblackFont = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fuentes/Aptos-Black.ttf")).deriveFont(18f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Font getPlaywriteFont(float size, int style) {
        return playwriteFont.deriveFont(style, size);
    }

    public static Font getRobotoFont(float size, int style) {
        return robotoFont.deriveFont(style, size);
    }

    public static Font getAptosBackFont(float size, int style){
        return aptosblackFont.deriveFont(style, size);
    }

}
