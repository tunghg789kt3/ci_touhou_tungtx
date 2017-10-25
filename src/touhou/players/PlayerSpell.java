package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physic.BoxCollider;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject{

    final int SPEED = 8;
    public BoxCollider boxCollider;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
        boxCollider = new BoxCollider(20,20);
    }

    public void run(){
        position.subtractBy(0,SPEED);
        boxCollider.position.set(this.position);
        Enemy enemy = GameObject.collideWith(this.boxCollider);

        if (enemy != null){
            enemy.getHit();
            this.isActive = false;
        }
    }
}
