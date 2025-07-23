package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, btnExit;
    String pin;

    // ✅ Constructor with PIN
    public Transactions(String pin) {
        this.pin = pin;

        setTitle("Transaction Page");
        setLayout(null);

        // ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblImage = new JLabel(i3);
        lblImage.setBounds(0, 0, 960, 1000);
        add(lblImage);

        // Title label
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(350, 250, 700, 35);
        lblImage.add(l1);

        // Buttons
        b1 = new JButton("Deposit");
        b2 = new JButton("WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("Mini Statement");
        b5 = new JButton("Pin Change");
        b6 = new JButton("Balance Check");
        btnExit = new JButton("Exit");

        b1.setBounds(250, 320, 150, 35);
        b2.setBounds(555, 320, 150, 35);
        b3.setBounds(250, 410, 150, 35);
        b4.setBounds(555, 410, 150, 35);
        b5.setBounds(250, 500, 150, 35);
        b6.setBounds(555, 500, 150, 35);
        btnExit.setBounds(400, 570, 150, 35);

        lblImage.add(b1);
        lblImage.add(b2);
        lblImage.add(b3);
        lblImage.add(b4);
        lblImage.add(b5);
        lblImage.add(b6);
        lblImage.add(btnExit);

        // Action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);  // ✅ Added listener for Pin Change
        b6.addActionListener(this);
        btnExit.addActionListener(this);

        setSize(960, 1000);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Transactions("1234");  // Test with dummy pin
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnExit) {
            System.exit(0);
        } else if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            // ✅ Pin Change Button Handler
            setVisible(false);
            new PinChange(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            setVisible(false);
            new BalanceCheck(pin).setVisible(true);
        }
    }
}
