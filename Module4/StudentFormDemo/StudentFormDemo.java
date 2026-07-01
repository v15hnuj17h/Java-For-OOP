import javax.swing.*;
import java.awt.*;

public class StudentFormDemo {
    public static void main (String[] args){
        
        SwingUtilities.invokeLater(()->{

            JFrame f = new JFrame("Student Form");

            JLabel l0 = new JLabel("Add New Student");  
            JLabel l1 = new JLabel("Name: ");           JTextField t1 = new JTextField();
            JLabel l2 = new JLabel("Roll Number: ");    JTextField t2 = new JTextField();
            JLabel l3 = new JLabel("Average: ");        JTextField t3 = new JTextField();
            JButton b1 = new JButton("Add Student");
            JButton b2 = new JButton("Clear");

            JPanel p1 = new JPanel();  
            JPanel p2 = new JPanel();

            p1.setLayout(new GridLayout(3,2));
            p1.add(l1);p1.add(t1);
            p1.add(l2);p1.add(t2);
            p1.add(l3);p1.add(t3);

            p2.setLayout(new GridLayout(1,2));
            p2.add(b1);p2.add(b2);

            f.setSize(500,300);
            f.setLayout(new BorderLayout());
            f.add(l0,BorderLayout.NORTH);
            f.add(p1,BorderLayout.CENTER);
            f.add(p2,BorderLayout.SOUTH);

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}