import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;

    public GameCanvas() {
        // 1. Load
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        // 2. Draw


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 204, 0, null);
        g.drawImage(player, 384, 500, null);
    }
}
