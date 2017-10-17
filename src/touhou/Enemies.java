package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemies {
    BufferedImage image;

    int x1 = 254;
    int x2 = 382;
    int x3 = 510;
    int y = -20;

    public Enemies() {
        image = Utils.loadImage("assets/images/enemies/level0/blue/1.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x1, y, null);
        graphics.drawImage(image, x2, y, null);
        graphics.drawImage(image, x3, y, null);
    }

    public void run() {
        y += 1;
        if (y >= 600) {
            y = -50;
        }
    }

    public void shoot(ArrayList<EnemiesBullets> bullets) {
        EnemiesBullets newBullet = new EnemiesBullets();
        newBullet.x = x1;
        newBullet.y = y;
        bullets.add(newBullet);
    }


}
