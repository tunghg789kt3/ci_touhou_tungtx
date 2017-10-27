package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physic.BoxCollider;
import bases.physic.PhysicsBody;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject implements PhysicsBody{

    final int SPEED = 8;
    public BoxCollider boxCollider;
    PlayerShoot playerShoot;

    public PlayerSpell(){
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
        boxCollider = new BoxCollider(20,20);
        this.playerShoot = new PlayerShoot();
    }

    public void run(){
        position.subtractBy(0,SPEED);
        boxCollider.position.set(this.position);
        this.playerShoot.run(this);
    }

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
