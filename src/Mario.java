import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.List;

    public class Mario extends Characters implements KeyListener {
        private int dx, dy;
        private boolean onGround = false;

        public Mario(String imagePath, int x, int y) {
            super(imagePath, x, y);
        }

        public void move() {
            x += dx;
            y += dy;

            if (!onGround) {
                dy += 1;
            }
        }

        public void checkCollisions(List<Platform> platforms) {
            for (Platform p : platforms) {
                if (getBounds().intersects(p.getBounds())) {
                    onGround = true;
                    dy = 0;
                    y = p.getBounds().y - getBounds().height;
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) dx = -5;
            if (key == KeyEvent.VK_RIGHT) dx = 5;
            if (key == KeyEvent.VK_UP && onGround) {
                dy = -15;
                onGround = false;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) dx = 0;
        }

        @Override
        public void keyTyped(KeyEvent e) {}
    }



