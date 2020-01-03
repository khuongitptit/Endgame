package endgame.controller;

import endgame.ui.GamePanel;
import java.awt.event.KeyEvent;

public class Controller {
    private GamePanel gamePanel;

    public Controller(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_SPACE:
                if(!gamePanel.isRunning()) {
                    gamePanel.startGame();
                }
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.getItemsManager().getThanos().setSpeed(-1);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getItemsManager().getThanos().setSpeed(1);
                break;
            case KeyEvent.VK_P:
                if(!gamePanel.isPause()) {
                    gamePanel.getThread().suspend();
                    gamePanel.setPause(true);
                } else {
                    gamePanel.getThread().resume();
                    gamePanel.setPause(false);
                }
                break;
        }
    }

    public void keyReleased(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                gamePanel.getItemsManager().getThanos().setSpeed(0);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getItemsManager().getThanos().setSpeed(0);
                break;
        }
    }
}