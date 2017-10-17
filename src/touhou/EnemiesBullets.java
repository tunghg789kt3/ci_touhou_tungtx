package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemiesBullets {
    public int x;
    public int y;
    BufferedImage image;
    final int SPEED = 3;

    public EnemiesBullets(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image, x, y, null);
    }

    public void run(){
        y += SPEED;
    }

}
