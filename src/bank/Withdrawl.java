package bank;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField tf1;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    public Withdrawl(String pin) {
        this.pin = pin;

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setResizable(false);
        setLayout(null);

        // Set ATM background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);              
        l3.setBounds(0, 0, 900, 900);
        setContentPane(l3);              
        l3.setLayout(null);              

        // Instruction label
        l1 = new JLabel("Maximum Withdrawal Is Rs. 10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(320, 285, 400, 20);
        l3.add(l1);

        // Amount input label
        l2 = new JLabel("Please Enter Your Amount");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(350, 340, 400, 20);
        l3.add(l2);

        // Text field for amount
        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway", Font.BOLD, 25));
        tf1.setBounds(300, 380, 330, 30);
        l3.add(tf1);

        // Withdraw button
        b1 = new JButton("WITHDRAW");
        b1.setBounds(250, 480, 150, 30);
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.addActionListener(this);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(500, 480, 150, 30);
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.addActionListener(this);
        l3.add(b2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = tf1.getText();
            Date date = new Date();

            if (ae.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    ConnectionFactory cf = new ConnectionFactory();
                    ResultSet rs = cf.stmt.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
                    int balance = 0;

                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    // Record the withdrawal
                    String query = "INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                    cf.stmt.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);  // Go back to transaction screen
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);  // Go back
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");  // Example call
    }
}


