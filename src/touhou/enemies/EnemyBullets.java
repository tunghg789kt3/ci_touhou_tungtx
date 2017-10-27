package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physic.BoxCollider;
import bases.physic.PhysicsBody;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullets extends GameObject implements PhysicsBody{

    final int SPEED = 3;
    public BoxCollider boxCollider;
    PlayerDamage playerDamage;

    public EnemyBullets(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        boxCollider = new BoxCollider(16,16);
        this.playerDamage = new PlayerDamage();
    }

    public void run(){
        position.addUp(0, SPEED);
        boxCollider.position.set(this.position);

        if (position.y >= 600){
            isActive = false;
        }

        this.playerDamage.BulletDamage(this);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
