import java.awt.*;
public class Barrel {
    private int x, y, width = 30, height = 30;
    private int speed = 2;
    private Image barrelSprite;


    public Barrel(int x, int y) {
        this.x = x;
        this.y = y;


        try {
            barrelSprite = new ImageIcon(getClass().getResource("/assets/barrel.png")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
            barrelSprite = null;
        }
    }


    // Barrel Movement (apply gravity and slanted platform interaction)
    public void move(List<Platform> platforms) {
        x += speed;


        boolean onPlatform = false;
        for (Platform p : platforms) {
            if (p.getBounds().intersects(getBounds())) {
                if (p.isSlanted()) {
                    y += 3;  // Simulate rolling down slanted platform
                } else {
                    y = p.getY() - height;  // Stop on top of platform
                }
                onPlatform = true;
                break;
            }
        }


        if (!onPlatform) {
            if (y < 500) {  // Ensure barrel doesn't fall below the ground level
                y += 5;  // Apply gravity
            }
        }
    }


    public void draw(Graphics g) {
        if (barrelSprite != null) {
            g.drawImage(barrelSprite, x, y, width, height, null);
        } else {
            g.setColor(new Color(139, 69, 19));  // Fallback: brown color
            g.fillRect(x, y, width, height);
        }
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}




