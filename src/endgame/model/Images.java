package endgame.model;

import javax.swing.*;
import java.awt.*;

public class Images {
    
    public static final int ID_FRAME_ICON = -1;
    
    public static final int ID_THANOS = 0;
    public static final int ID_MJONIR = 10;
    public static final int ID_CAP_SHIELD = 11;
    public static final int ID_STORMBREAKER = 12;
    
    public static final int ID_MIND_STONE = 20;
    public static final int ID_REALITY_STONE = 21;
    public static final int ID_POWER_STONE = 22;
    public static final int ID_SOUL_STONE = 23;
    public static final int ID_SPACE_STONE = 24;
    public static final int ID_TIME_STONE = 25;
    
    public static final int ID_GAUNTLET = 4;
    public static final int ID_BACKGROUND = 5;
    public static final int ID_BACKGROUND2 = 6;

    
    private static final Image FRAME_ICON = new ImageIcon(Image.class.getResource("/rec/thanos1.png")).getImage();
    private static final Image THANOS = new ImageIcon(Image.class.getResource("/rec/thanos2.png")).getImage();
    private static final Image MJONIR = new ImageIcon(Image.class.getResource("/rec/weapon/mjonir.png")).getImage();
    private static final Image CAP_SHIELD = new ImageIcon(Image.class.getResource("/rec/weapon/cap_shield.png")).getImage();
    private static final Image STORMBREAKER = new ImageIcon(Image.class.getResource("/rec/weapon/stormbreaker.png")).getImage();
    private static final Image MIND_STONE = new ImageIcon(Image.class.getResource("/rec/stones/mindstone.png")).getImage();
    private static final Image REALITY_STONE = new ImageIcon(Image.class.getResource("/rec/stones/realitystone.png")).getImage();
    private static final Image POWER_STONE = new ImageIcon(Image.class.getResource("/rec/stones/powerstone.png")).getImage();
    private static final Image SOUL_STONE = new ImageIcon(Image.class.getResource("/rec/stones/soulstone.png")).getImage();
    private static final Image SPACE_STONE = new ImageIcon(Image.class.getResource("/rec/stones/spacestone.png")).getImage();
    private static final Image TIME_STONE = new ImageIcon(Image.class.getResource("/rec/stones/timestone.png")).getImage();
    private static final Image GAUNTLET = new ImageIcon(Image.class.getResource("/rec/gauntlet.png")).getImage();
    private static final Image BACKGROUND = new ImageIcon(Image.class.getResource("/rec/background.jpg")).getImage();
    private static final Image BACKGROUND2 = new ImageIcon(Image.class.getResource("/rec/background2.jpg")).getImage();

    public static Image getImage(int id) {
        switch (id) {
            
            case ID_FRAME_ICON:
                return FRAME_ICON;
            case ID_THANOS:
                return THANOS;
            case ID_MJONIR:
                return MJONIR;
            case ID_CAP_SHIELD:
                return CAP_SHIELD;
            case ID_STORMBREAKER:
                return STORMBREAKER;
            case ID_MIND_STONE:
                return MIND_STONE;
            case ID_REALITY_STONE:
                return REALITY_STONE;
            case ID_POWER_STONE:
                return POWER_STONE;
            case ID_SOUL_STONE:
                return SOUL_STONE;
            case ID_SPACE_STONE:
                return SPACE_STONE;
            case ID_TIME_STONE:
                return TIME_STONE;
            case ID_GAUNTLET:
                return GAUNTLET;
            case ID_BACKGROUND:
                return BACKGROUND;
            case ID_BACKGROUND2:
                return BACKGROUND2;
            default:
                return null;
        }
    }
}