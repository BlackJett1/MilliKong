import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Mario mario;
    private Characters donkeyKong, pauline;
    private List<Platform> platforms;
    private List<Barrel> barrels;

    public GamePanel() {
        setBackground(Color.BLACK);
        mario = new Mario("/mario.png", 150, 480);
        donkeyKong = new Characters("/donkeykong.png", 100, 100);
        pauline = new Characters("/pauline.png", 400, 50);
        platforms = new ArrayList<>();
        barrels = new ArrayList<>();


        platforms.add(new Platform(100, 500, 600, 20));
        platforms.add(new Platform(200, 400, 400, 20));
        platforms.add(new Platform(100, 300, 600, 20));
        platforms.add(new Platform(200, 200, 400, 20));

        addKeyListener(mario);
        setFocusable(true);

        timer = new Timer(16, this); // ~60 FPS
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mario.move();
        mario.checkCollisions(platforms);
        for (Barrel barrel : barrels) {
            barrel.move();
        }
        checkGameState();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        donkeyKong.draw(g);
        pauline.draw(g);
        mario.draw(g);
        for (Platform p : platforms) {
            p.draw(g);
        }
        for (Barrel b : barrels) {
            b.draw(g);
        }
    }

    public void checkGameState() {
        if (mario.getBounds().intersects(pauline.getBounds())) {
            System.out.println("You Win!");
            timer.stop();
        }
        for (Barrel barrel : barrels) {
            if (mario.getBounds().intersects(barrel.getBounds())) {
                System.out.println("Game Over!");
                timer.stop();
            }
        }
    }

    public void spawnBarrel() {
        barrels.add(new Barrel("/barrel.png", 120, 120));
    }
}

