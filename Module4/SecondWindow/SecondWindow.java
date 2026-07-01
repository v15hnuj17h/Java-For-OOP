import javax.swing.*;
import java.awt.*;

public class SecondWindow {
    public static void main (String[] args) {
        JFrame frame = new JFrame("My Second Window");

        frame.setSize(400,300);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Hello Swing");
        JButton button = new JButton("Click Me");

        panel.setLayout(new GridLayout(5,3));
        panel.add(label);
        panel.add(button);

        for (int i =1; i<=10; i++){
            panel.add(new JButton("B"+1));
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
