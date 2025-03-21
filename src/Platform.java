import java.awt.*;
public class Platform {
    private int x, y, width, height;
    private boolean slanted;


    public Platform(int x, int y, int width, int height, boolean slanted) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.slanted = slanted;
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        if (slanted) {
            g.drawLine(x, y, x + width, y - height);
        } else {
            g.fillRect(x, y, width, height);
        }
    }


    public int getY() {
        return y;
    }


    public boolean isSlanted() {
        return slanted;
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
