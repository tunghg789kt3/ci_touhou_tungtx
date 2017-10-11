import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas canvas;

    long lastTimeUpdate;

    public GameWindow() {
        this.setSize(800, 600);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);
        this.setBackground(Color.black);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                canvas.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                canvas.keyReleased(e);
            }
        });

        this.canvas.setVisible(true);
        this.setVisible(true);
        lastTimeUpdate = System.nanoTime();

    }

    public void gameLoop(){
        while (true){

            long currentTime = System.nanoTime();

            if (currentTime - lastTimeUpdate >= 17000000){
                canvas.run();
                canvas.render();

                lastTimeUpdate = currentTime;
            }
        }
    }

}
