package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemies extends GameObject {

    int x = 382;
    int y = -20;

    int cooldownCount;
    boolean spellDisabled;
    final int COOLDOWN_TIME = 100;

    boolean goRight = true;

    public Enemies() {
        image = Utils.loadImage("assets/images/enemies/level0/blue/1.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        move();
        shoot();
    }

    public void move() {
        y += 1;
        if (y >= 600) {
            y = -50;
        }
    }

    public void shoot() {

        if (spellDisabled) {
            cooldownCount++;
            if (cooldownCount >= COOLDOWN_TIME) {
                spellDisabled = false;
                cooldownCount = 0;
            }
            return;

        }

        EnemiesBullets newBullet = new EnemiesBullets();
        newBullet.x = x;
        newBullet.y = y;
        GameObject.add(newBullet);

        spellDisabled = true;
    }


}
