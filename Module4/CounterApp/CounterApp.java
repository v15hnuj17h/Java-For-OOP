import javax.swing.*;
import java.awt.*;

public class CounterApp {

    private JFrame frame;
    private JLabel label;
    private JButton incBtn;
    private JButton decBtn;
    private JButton clrBtn;
    private JPanel main;
    private JPanel ctrl;
    private int value = 0;

    private CounterApp(){
        buildUI();
        attachListeners();
    }
    private void buildUI(){
        frame = new JFrame("Counter");
        frame.setSize(450,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        main = new JPanel(new BorderLayout(10,10));
        main.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        label = new JLabel("Count: 0",JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        main.add(label,BorderLayout.CENTER);

        ctrl = new JPanel(new FlowLayout());

        incBtn = new JButton("+1");
        decBtn = new JButton("-1");
        clrBtn = new JButton("Reset");
        ctrl.add(incBtn);
        ctrl.add(decBtn);
        ctrl.add(clrBtn);

        main.add(ctrl,BorderLayout.SOUTH);

        frame.add(main);
        frame.setVisible(true);
    }
    private void attachListeners() {
        incBtn.addActionListener(e -> increment());
        decBtn.addActionListener(e -> decrement());
        clrBtn.addActionListener(e -> clear());
    }

    private void increment() {
        value++;
        updateLabel();
    }
    private void decrement() {
        if(value>0){
            value--;
            updateLabel();
        }else{
            JOptionPane.showMessageDialog(frame,"Count cannot go below 0!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void clear() {
        value = 0;
        updateLabel();
    }
    private void updateLabel(){
        label.setText("Count: "+ value);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(CounterApp::new);
    }
}