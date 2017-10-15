package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    public int x;
    public int y;
    BufferedImage image;
    final int SPEED = 8;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image,x,y,null);
    }

    public void run(){
        y -= SPEED;
    }
}
