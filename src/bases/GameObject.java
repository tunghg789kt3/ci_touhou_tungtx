package bases;

import bases.physic.BoxCollider;
import bases.physic.PhysicsBody;
import touhou.enemies.Enemy;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {

    public final int LEFT = 0;
    public final int RIGHT = 384;
    public final int TOP = 0;
    public final int BOTTOM = 570;

    public BufferedImage image;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObject = new Vector<>();


    public Vector2D velocity = new Vector2D();
    public Vector2D position = new Vector2D();

    public boolean isActive;

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.run();
            }
        }

        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(graphics);
            }
        }
    }

    public static void add(GameObject gameObject) {
        newGameObject.add(gameObject);
    }

    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }

    public void run() {

    }

    public void render(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, (int) (position.x - image.getWidth() / 2), (int) (position.y - image.getHeight() / 2), null);
        }
    }

    public float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }

        return value;
    }

    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls) {

        for (GameObject gameObject : gameObjects) {
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if (!(gameObject.getClass().equals(cls)))continue;
            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
            if (otherBoxCollider.collideWith(boxCollider)){
                return (T) gameObject;
            }
        }
        return null;
    }
}
