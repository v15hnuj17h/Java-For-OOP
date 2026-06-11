import javax.swing.*;

public class FirstWindow {
    public static void main(String[] args) {

        JFrame frame = new JFrame("First Window");

        JLabel label = new JLabel("Hello, World!", JLabel.CENTER);

        frame.add(label);

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}