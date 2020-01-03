package endgame.model;

import endgame.controller.ItemsManager;
import endgame.ui.GUI;

import java.awt.*;
import java.util.ArrayList;

public class Thanos extends Item {
    
    private boolean isDead;
    private int speed;

    public Thanos(Image img, int x, int y, int size, int delay) {
        super(img, x, y, size, delay);
        this.img = Images.getImage(Images.ID_THANOS);
        isDead = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isDead() {
        return isDead;
    }

    public void move(int times, ItemsManager itemsManager) {
        this.img = Images.getImage(Images.ID_THANOS);
        if (times % delay == 0) {
            if (speed < 0) {
                x += speed;
                if (x <= -size) {
                    x = GUI.WIDTH - 1;
                }
            } else if(speed > 0) {
                x += speed;
                if (x >= GUI.WIDTH) {
                    x = 1 - size;
                }
            }
        }

        Rectangle rect = new Rectangle(x, y, size, size);
        ArrayList<Item> items = itemsManager.getListItem();
        for (int i = 0; i < items.size(); i++) {
            Rectangle r = new Rectangle(items.get(i).getX(), items.get(i).getY(), items.get(i).getSize(), items.get(i).getSize());
            if (rect.intersects(r)) {
                if (items.get(i) instanceof Avengers) {
                    isDead = true;
                    return;
                } else if (items.get(i) instanceof Gauntlet) {
                    itemsManager.setScore(itemsManager.getScore() + 5);
                    itemsManager.removeItem(i);
                } else {
                    itemsManager.setScore(itemsManager.getScore() + 3);
                    itemsManager.removeItem(i);
                }
            }
        }
    }
}