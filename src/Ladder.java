import java.awt.*;


public class Ladder {
    private int x, y, width, height;


    public Ladder(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }
}

