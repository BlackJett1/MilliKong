import javax.swing.*;

public class MilliKongGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Donkey Kong - Java");
        GamePanel panel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);

        panel.startGame();
    }
}
