import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public static void main (String[] args){

        SwingUtilities.invokeLater(()->{

            JFrame f = new JFrame("Student Login");

            JLabel l0 = new JLabel("Student Login");  
            JLabel l1 = new JLabel("Username: ");           JTextField t1 = new JTextField();
            JLabel l2 = new JLabel("Password: ");    JTextField t2 = new JPasswordField();
            JButton b1 = new JButton("Login");
            JButton b2 = new JButton("Cancel");

            JPanel p1 = new JPanel();  
            JPanel p2 = new JPanel();

            p1.setLayout(new GridLayout(2,2));
            p1.add(l1);p1.add(t1);
            p1.add(l2);p1.add(t2);

            p2.setLayout(new GridLayout(1,2));
            p2.add(b1);p2.add(b2);

            f.setSize(500,300);
            f.setLayout(new BorderLayout());
            f.add(l0,BorderLayout.NORTH);
            f.add(p1,BorderLayout.CENTER);
            f.add(p2,BorderLayout.SOUTH);

            p1.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}