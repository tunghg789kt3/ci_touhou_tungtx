package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject{

    final int SPEED = 9;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
    }

    public void run(){
        y -= SPEED;
    }
}
