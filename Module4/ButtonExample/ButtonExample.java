import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ButtonExample {
    public static void main (String[] args) {

        JFrame f = new JFrame("Button");
        JButton b = new JButton("Click-Me");
        
        b.addActionListener(e -> System.out.println("Button Clicked"));

        f.add(b);
        f.setSize(200,150);
        f.setLocationRelativeTo(null);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}