import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    GameCanvas canvas;

    public GameWindow() {
        this.setSize(800,600);
        this.setVisible(true);
        this.setBackground(Color.gray);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);
    }
}
