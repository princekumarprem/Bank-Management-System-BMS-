package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JPasswordField currentPinField, newPinField, confirmPinField;
    JButton changeBtn, backBtn;
    String pin;

    public PinChange(String pin) {
        this.pin = pin;

        setTitle("Change PIN");
        setLayout(null);

        l1 = new JLabel("Current PIN:");
        l1.setBounds(100, 100, 150, 30);
        add(l1);

        currentPinField = new JPasswordField();
        currentPinField.setBounds(250, 100, 150, 30);
        add(currentPinField);

        l2 = new JLabel("New PIN:");
        l2.setBounds(100, 150, 150, 30);
        add(l2);

        newPinField = new JPasswordField();
        newPinField.setBounds(250, 150, 150, 30);
        add(newPinField);

        l3 = new JLabel("Confirm PIN:");
        l3.setBounds(100, 200, 150, 30);
        add(l3);

        confirmPinField = new JPasswordField();
        confirmPinField.setBounds(250, 200, 150, 30);
        add(confirmPinField);

        changeBtn = new JButton("Change PIN");
        changeBtn.setBounds(100, 260, 130, 30);
        changeBtn.addActionListener(this);
        add(changeBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(250, 260, 130, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(500, 400);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == changeBtn) {
            String currentPin = currentPinField.getText();
            String newPin = newPinField.getText();
            String confirmPin = confirmPinField.getText();

            if (!currentPin.equals(pin)) {
                JOptionPane.showMessageDialog(null, "Current PIN is incorrect!");
                return;
            }

            if (!newPin.equals(confirmPin)) {
                JOptionPane.showMessageDialog(null, "New PIN and Confirm PIN do not match!");
                return;
            }

            if (newPin.equals("") || confirmPin.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN fields cannot be empty!");
                return;
            }

            try {
                ConnectionFactory c = new ConnectionFactory(); // ✅ your existing connection class

                String[] tables = {"bank", "login", "signupthree"};
                for (String table : tables) {
                    String query = "UPDATE " + table + " SET pin = '" + newPin + "' WHERE pin = '" + pin + "'";
                    c.stmt.executeUpdate(query);  // ✅ using stmt
                }

                JOptionPane.showMessageDialog(null, "PIN changed successfully!");
                setVisible(false);
                new Login().setVisible(true); // ✅ redirect to login

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Transactions(pin).setVisible(true); // ✅ back to transaction screen
        }
    }

    public static void main(String[] args) {
        new PinChange("1234"); // For testing only
    }
}
