package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceCheck extends JFrame implements ActionListener {
    JLabel heading, balanceLabel;
    JButton back;
    String pin;

    BalanceCheck(String pin) {
        this.pin = pin;

        // Set up frame
        setTitle("Balance Enquiry");
        setLayout(null);

        // ATM background image
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = atmIcon.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 960, 1000);
        add(background);

        // Heading
        heading = new JLabel("Your Current Balance");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 24));
        heading.setBounds(340, 250, 300, 30);
        background.add(heading);

        // Balance label
        balanceLabel = new JLabel("Rs 0");
        balanceLabel.setForeground(Color.YELLOW);
        balanceLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
        balanceLabel.setBounds(370, 300, 400, 30);
        background.add(balanceLabel);

        // Back button
        back = new JButton("Back");
        back.setBounds(400, 500, 150, 35);
        background.add(back);
        back.addActionListener(this);

        // Frame settings
        setSize(960, 1000);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);

        // Show balance
        showBalance();
    }

    public void showBalance() {
        int balance = 0;
        try {
            ConnectionFactory cf = new ConnectionFactory();
            String query = "SELECT type, amount FROM bank WHERE pin = '" + pin + "'";
            ResultSet rs = cf.stmt.executeQuery(query);

            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            balanceLabel.setText("Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceCheck("3680");
    }
}
