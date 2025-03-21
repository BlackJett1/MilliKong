import  java.awt.*;
public class Mario {
    private int x, y, width = 40, height = 40;
    private int speed = 5;
    private int jumpSpeed = 15;
    private int yVelocity = 0;
    private boolean isJumping = false;
    private boolean isFalling = false;
    private Image marioSprite;
    private final int GROUND_LEVEL = 500;
    private final int GRAVITY = 1;


    public Mario(int x, int y) {
        this.x = x;
        this.y = y;



        try {
            marioSprite = new ImageIcon(getClass().getResource("/assets/mario.png")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
            marioSprite = null;
        }
    }



    public void update() {

        if (!isJumping && y < GROUND_LEVEL) {
            yVelocity += GRAVITY;
            isFalling = true;
        } else {
            isFalling = false;
            yVelocity = 0;
            y = GROUND_LEVEL;
        }


        if (isJumping) {
            yVelocity = -jumpSpeed;
            isJumping = false;
        }


        y += yVelocity;
    }



    public void moveLeft() {
        x -= speed;
    }


    public void moveRight() {
        x += speed;
    }



    public void jump() {
        if (!isFalling) {
            isJumping = true;
        }
    }


    public void draw(Graphics g) {
        if (marioSprite != null) {
            g.drawImage(marioSprite, x, y, width, height, null);
        } else {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}


