package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physic.BoxCollider;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullets extends GameObject{

    final int SPEED = 3;
    public BoxCollider boxCollider;

    public EnemyBullets(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        boxCollider = new BoxCollider(16,16);
    }

    public void run(){
        position.addUp(0, SPEED);
        boxCollider.position.set(this.position);
        Player player = GameObject.collodeWith(boxCollider);

        if (player !=null){
            player.getHit();
            this.isActive = false;
        }

    }

}
