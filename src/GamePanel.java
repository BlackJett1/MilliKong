import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Mario mario;
    private List<Platform> platforms;
    private List<Barrel> barrels;
    private Image donkeyKong, pauline;
    private int score = 0, lives = 3, time = 300;


    public GamePanel() {
        timer = new Timer(30, this);
        mario = new Mario(100, 500);
        barrels = new ArrayList<>();
        platforms = new ArrayList<>();


        // Initialize platforms
        platforms.add(new Platform(50, 400, 600, 20, false));  // Flat platform
        platforms.add(new Platform(100, 300, 600, 20, true));   // Slanted platform


        donkeyKong = new ImageIcon("donkeykong.png").getImage();
        pauline = new ImageIcon("pauline.png").getImage();


        addKeyListener(this);
        setFocusable(true);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight()); // Background


        // Draw Donkey Kong & Pauline
        g.drawImage(donkeyKong, 100, 50, 80, 80, null);
        g.drawImage(pauline, 600, 50, 60, 60, null);


        // Draw Platforms
        for (Platform p : platforms) {
            p.draw(g);
        }


        // Draw Barrels
        for (Barrel b : barrels) {
            b.draw(g);
        }


        // Draw Mario
        mario.draw(g);


        // UI
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);
        g.drawString("Lives: " + lives, 200, 30);
        g.drawString("Time: " + time, 400, 30);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Update Mario's and Barrel's positions
        mario.update();
        for (Barrel b : barrels) {
            b.move(platforms); // Update barrel position
        }


        repaint(); // Redraw the panel
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // Handle Mario movement based on key press
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mario.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mario.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mario.jump();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void keyTyped(KeyEvent e) {}
}

