import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;

    public GamePanel() {
        setBackground(Color.BLACK);
        timer = new Timer(16, this);
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLevel(g);
    }

    private void drawLevel(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(100, 500, 600, 20);
    }
}
