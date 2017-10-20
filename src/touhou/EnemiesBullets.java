package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemiesBullets extends GameObject{

    final int SPEED = 3;

    public EnemiesBullets(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void run(){
        y += SPEED;
    }

}
