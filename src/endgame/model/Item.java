package endgame.model;

import java.awt.*;

public abstract class Item {
    protected Image img;
    protected int x, y;
    protected int size;
    protected int delay;

    public Item(Image img, int x, int y, int size, int delay) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.size = size;
        this.delay = delay;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, size, size, null);
    }

    public void move(int times) {
        if (times % delay == 0) {
            y++;
        }
    }
}