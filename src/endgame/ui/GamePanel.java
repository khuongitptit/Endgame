package endgame.ui;

import endgame.controller.Controller;
import endgame.controller.ItemsManager;
import endgame.model.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamePanel extends JPanel implements Runnable, KeyListener {
    private ItemsManager itemsManager;
    private Thread thread;
    private Controller controller;
    private boolean isRunning;
    private boolean isPause;

    public GamePanel() {
        init();
        initComponents();
    }

    private void init() {
        setSize(GUI.WIDTH, GUI.HEIGHT);
        setLocation(0, 0);
        setLayout(null);
    }

    private void initComponents() {
        isPause = false;
        isRunning = false;
        controller = new Controller(this);
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean isPause) {
        this.isPause = isPause;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public ItemsManager getItemsManager() {
        return itemsManager;
    }

    public void startGame() {
        itemsManager = new ItemsManager();
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        if(isRunning()) {
            g2d.drawImage(Images.getImage(Images.ID_BACKGROUND), 0, 0, GUI.WIDTH, GUI.HEIGHT, null);
            itemsManager.drawAll(g2d);
            g2d.setColor(Color.YELLOW);
            g2d.setFont(new Font("Courier New", Font.CENTER_BASELINE, 30));
            g2d.drawString("Your score: " + itemsManager.getScore(), 10, 30);
            
        } else {
            g2d.drawImage(Images.getImage(Images.ID_BACKGROUND2), 0, 0, GUI.WIDTH, GUI.HEIGHT, null);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Courier New", Font.CENTER_BASELINE, 30));
            g2d.drawString("Press SPACE to start", 50, 400);
        }
    }

    @Override
    public void run() {
        while (!itemsManager.isOver()) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(isRunning()) {
                itemsManager.count++;
                itemsManager.move(itemsManager.count);
            }
            repaint();
        }
        if (itemsManager.isOver()) {
            isRunning = false;
            int i = JOptionPane.showConfirmDialog(this, "Play again?", "Game over :((", JOptionPane.YES_NO_OPTION);
            if(i == JOptionPane.YES_OPTION) {
                startGame();
            } else {
                isRunning = false;
                return;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        controller.keyReleased(e.getKeyCode());
    }
}