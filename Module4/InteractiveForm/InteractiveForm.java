import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InteractiveForm {
    
    private JFrame     frame;
    private JTextField nameField;
    private JTextField rollField;
    private JLabel     statusLabel;
    private JButton    addBtn;
    private JButton    clearBtn;
    private JButton    greetBtn;

    public InteractiveForm () {
        buildUI();
        attachListeners();
    }

    private void buildUI(){

        frame = new JFrame("Interactive Student Form");
        frame.setSize(450,280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(10,10));
        main.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel title = new JLabel("Student Registration",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,16));
        main.add(title,BorderLayout.NORTH);

        JPanel form = new JPanel (new GridLayout(2,2,10,8));
        form.add(new JLabel("Name: "));
        nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Roll No:"));
        rollField = new JTextField();
        form.add(rollField);

        main.add(form, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(5,5));

        JPanel btnPanel = new JPanel(new FlowLayout());

        addBtn   = new JButton("Add");
        clearBtn = new JButton("Clear");
        greetBtn = new JButton("Greet");

        btnPanel.add(addBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(greetBtn);

        statusLabel = new JLabel("Ready.", JLabel.CENTER);
        statusLabel.setForeground(Color.GRAY);

        bottom.add(btnPanel, BorderLayout.CENTER);
        bottom.add(statusLabel, BorderLayout.SOUTH);
        main.add(bottom, BorderLayout.SOUTH);

        frame.add(main);
        frame.setVisible(true);
    }

    private void attachListeners() {

        addBtn.addActionListener(e -> handleAdd());
        clearBtn.addActionListener(e -> handleClear());
        greetBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a name first!", "Missing Info", JOptionPane.WARNING_MESSAGE); // position, contents, title, iconType
            } else {
                JOptionPane.showMessageDialog(frame, "Hello, " + name + "! ", "Greeting", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Enter key in rollField → same as clicking Add
        rollField.addActionListener(e -> handleAdd());
        nameField.addActionListener(e -> rollField.requestFocus());
    }

    private void handleAdd() {

        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();

        if (name.isEmpty()) {
            statusLabel.setText("Name cannot be empty!");
            statusLabel.setForeground(Color.RED);
            nameField.requestFocus();
            return;
        }
        if (roll.isEmpty()) {
            statusLabel.setText("Roll number cannot be empty!");
            statusLabel.setForeground(Color.RED);
            rollField.requestFocus();
            return;
        }

        try {
            int rollNo = Integer.parseInt(roll);
            statusLabel.setText("Added: " + name + " (Roll: " + rollNo + ")");
            statusLabel.setForeground(new Color(0, 128, 0)); // dark green
            handleClear();
        } catch (NumberFormatException ex) {
            statusLabel.setText("Roll number must be a number!");
            statusLabel.setForeground(Color.RED);
            rollField.selectAll();
            rollField.requestFocus();
        }
    }

    private void handleClear () {
        nameField.setText("");
        rollField.setText("");
        nameField.requestFocus();
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(InteractiveForm::new);
    }
}