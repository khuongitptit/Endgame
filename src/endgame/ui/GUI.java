package endgame.ui;

import endgame.model.Images;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private GamePanel gamePanel;

    public GUI() {
        init();
        initComponents();
    }

    private void init() {
        setTitle("Avengers: Endgame");
        setSize(WIDTH + 6, HEIGHT + 29);
        setResizable(false);
        setIconImage(Images.getImage(Images.ID_FRAME_ICON));
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        gamePanel = new GamePanel();
        add(gamePanel);
        addKeyListener(gamePanel);
    }
}