package endgame.controller;

import endgame.model.Images;
import endgame.model.Item;
import endgame.model.Gauntlet;
import endgame.model.Stones;
import endgame.model.*;
import endgame.ui.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ItemsManager {
    public static int count;

    private ArrayList<Item> listItem;
    private int itemNumber;
    private Thanos thanos;
    private int delayGauntlet;
    private int delayStones;
    private int delayAvengers;
    private int score;

    public ItemsManager() {
        thanos = new Thanos(Images.getImage(Images.ID_THANOS), 300, GUI.HEIGHT - 50, 50, 2);
        delayAvengers = 5;
        delayGauntlet = 4;
        delayStones = 4;
        count = 0;
        itemNumber = 15;
        initItem();
    }

    public Thanos getThanos() {
        return thanos;
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private void initItem() {
        listItem = new ArrayList<>();
        Random rd = new Random();
        int sizeItem = 40;
        for (int i = 0; i < 15; i++) {
            Item item = null;
            int x = rd.nextInt(GUI.WIDTH - sizeItem);
            int a = rd.nextInt(3);
            switch (a) {
                case 0:
                {
                    int rdweapon= 10+rd.nextInt(3);
                    if(rdweapon==10)
                    {
                        item = new Avengers(Images.getImage(Images.ID_MJONIR), x, -(i * sizeItem), sizeItem, delayAvengers);
                        
                    }
                    else if(rdweapon==11)
                    {
                        item = new Avengers(Images.getImage(Images.ID_CAP_SHIELD), x, -(i * sizeItem), sizeItem, delayAvengers);
                        
                    }
                    else if(rdweapon==12)
                    {
                        item = new Avengers(Images.getImage(Images.ID_STORMBREAKER), x, -(i * sizeItem), sizeItem, delayAvengers);
                    }
                    listItem.add(item);
                    break;
                    }
                case 1:
            {
                int rdstone= 20+rd.nextInt(6);
                if(rdstone==20)
                    item = new Stones(Images.getImage(Images.ID_MIND_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==21)
                    item = new Stones(Images.getImage(Images.ID_REALITY_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==22)
                    item = new Stones(Images.getImage(Images.ID_POWER_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==23)
                    item = new Stones(Images.getImage(Images.ID_SOUL_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==24)
                    item = new Stones(Images.getImage(Images.ID_SPACE_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==25)
                    item = new Stones(Images.getImage(Images.ID_TIME_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                
                listItem.add(item);
                break;
            }    
                case 2:
                    item = new Gauntlet(Images.getImage(Images.ID_GAUNTLET), x, -(i * sizeItem), sizeItem, delayGauntlet);
                    listItem.add(item);
                    break;
            }
        }
    }

    public void drawAll(Graphics2D g2d) {
        thanos.draw(g2d);

        for (int i = 0; i < listItem.size(); i++) {
            listItem.get(i).draw(g2d);
        }
    }

    public void move(int count) {
        if (count >= Integer.MAX_VALUE) {
            count = 0;
        }

        thanos.move(count, this);

        for (int i = 0; i < listItem.size(); i++) {
            listItem.get(i).move(count);
            if (listItem.get(i).getY() >= GUI.HEIGHT) {
                removeItem(i);
            }
        }

        if(score > 150) {
            delayGauntlet = 1;
            delayStones = 1;
            delayAvengers = 1;
            for(int i = 0; i < listItem.size(); i++) {
                if(listItem.get(i) instanceof Avengers) {
                    listItem.get(i).setDelay(delayAvengers);
                } else if(listItem.get(i) instanceof Gauntlet) {
                    listItem.get(i).setDelay(delayGauntlet);
                } else {
                    listItem.get(i).setDelay(delayStones);
                }
            }
        } else if(score > 100) {
            delayGauntlet = 3;
            delayStones = 2;
            delayAvengers = 2;
            for(int i = 0; i < listItem.size(); i++) {
                if(listItem.get(i) instanceof Avengers) {
                    listItem.get(i).setDelay(delayAvengers);
                } else if(listItem.get(i) instanceof Gauntlet) {
                    listItem.get(i).setDelay(delayGauntlet);
                } else {
                    listItem.get(i).setDelay(delayStones);
                }
            }
        } else if(score > 50) {
            delayGauntlet = 4;
            delayStones = 3;
            delayAvengers = 3;
            for(int i = 0; i < listItem.size(); i++) {
                if(listItem.get(i) instanceof Avengers) {
                    listItem.get(i).setDelay(delayAvengers);
                } else if(listItem.get(i) instanceof Gauntlet) {
                    listItem.get(i).setDelay(delayGauntlet);
                } else {
                    listItem.get(i).setDelay(delayStones);
                }
            }
        }
    }

    public void removeItem(int i) {
        listItem.remove(i);
        Random rd = new Random();
        Item item = null;
        int sizeItem = 40;
        int x = rd.nextInt(GUI.WIDTH - sizeItem);
        int a = rd.nextInt(3);
        switch (a) {
            case 0:
                {
                    int rdweapon= 10+rd.nextInt(3);
                    if(rdweapon==10)
                    {
                        item = new Avengers(Images.getImage(Images.ID_MJONIR), x, -(i * sizeItem), sizeItem, delayAvengers);
                        
                    }
                    else if(rdweapon==11)
                    {
                        item = new Avengers(Images.getImage(Images.ID_CAP_SHIELD), x, -(i * sizeItem), sizeItem, delayAvengers);
                        
                    }
                    else if(rdweapon==12)
                    {
                        item = new Avengers(Images.getImage(Images.ID_STORMBREAKER), x, -(i * sizeItem), sizeItem, delayAvengers);
                    }
                listItem.add(item);
                break;
                }
                
            case 1:
            {
                int rdstone= 20+rd.nextInt(6);
                if(rdstone==20)
                    item = new Stones(Images.getImage(Images.ID_MIND_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==21)
                    item = new Stones(Images.getImage(Images.ID_REALITY_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==22)
                    item = new Stones(Images.getImage(Images.ID_POWER_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==23)
                    item = new Stones(Images.getImage(Images.ID_SOUL_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==24)
                    item = new Stones(Images.getImage(Images.ID_SPACE_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                if(rdstone==25)
                    item = new Stones(Images.getImage(Images.ID_TIME_STONE), x, -(i * sizeItem), sizeItem, delayStones);
                
                listItem.add(item);
                break;
            }    
            
                
            case 2:
                item = new Gauntlet(Images.getImage(Images.ID_GAUNTLET), x, -(i * sizeItem), sizeItem, delayGauntlet);
                listItem.add(item);
                break;
        }
    }

    public boolean isOver() {
        return thanos.isDead();
    }
}