import javax.swing.*;


public class DonkeyKong {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Donkey Kong");
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
