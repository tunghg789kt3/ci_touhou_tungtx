package bases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public float x;
    public float y;

    public final int LEFT = 188;
    public final int RIGHT = 572;
    public final int TOP = -24;
    public final int BOTTOM = 550;

    public BufferedImage image;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObject = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            gameObject.run();
        }

        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(graphics);
        }
    }

    public static void add(GameObject gameObject){
            newGameObject.add(gameObject);
    }

    public GameObject() {

    }

    public void run() {

    }

    public void render(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, (int) x, (int) y, null);
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
}
