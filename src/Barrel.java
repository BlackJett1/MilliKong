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



    public void move(List<Platform> platforms) {
        x += speed;


        boolean onPlatform = false;
        for (Platform p : platforms) {
            if (p.getBounds().intersects(getBounds())) {
                if (p.isSlanted()) {
                    y += 3;
                } else {
                    y = p.getY() - height;
                }
                onPlatform = true;
                break;
            }
        }


        if (!onPlatform) {
            if (y < 500) {
                y += 5;
            }
        }
    }


    public void draw(Graphics g) {
        if (barrelSprite != null) {
            g.drawImage(barrelSprite, x, y, width, height, null);
        } else {
            g.setColor(new Color(139, 69, 19));
            g.fillRect(x, y, width, height);
        }
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}




