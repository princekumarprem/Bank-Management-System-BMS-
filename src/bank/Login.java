package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    // Instance variables
    JLabel lblWelcome, lblCardNumber, lblPinNumber;
    JTextField tfCardNumber;
    JPasswordField pfPinNumber;
    JButton btnLogin, btnClear, btnSignUp;

    // Constructor
    public Login() {
        setTitle("Bank Management System");
        setLayout(null);

        lblWelcome = new JLabel("Welcome To Our Bank");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 35));
        lblWelcome.setBounds(200, 40, 530, 40);
        add(lblWelcome);

        lblCardNumber = new JLabel("Enter Card No:");
        lblCardNumber.setBounds(120, 150, 400, 25);
        lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblCardNumber);

        tfCardNumber = new JTextField(20);
        tfCardNumber.setBounds(350, 150, 230, 25);
        tfCardNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(tfCardNumber);

        lblPinNumber = new JLabel("Enter PIN No:");
        lblPinNumber.setBounds(120, 250, 400, 25);
        lblPinNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblPinNumber);

        pfPinNumber = new JPasswordField(20);
        pfPinNumber.setBounds(350, 250, 230, 25);
        pfPinNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(pfPinNumber);

        // Buttons
        btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);

        btnClear = new JButton("Clear");
        btnClear.setBackground(Color.black);
        btnClear.setForeground(Color.white);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(Color.black);
        btnSignUp.setForeground(Color.white);

        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogin.setBounds(300, 300, 100, 40);
        add(btnLogin);

        btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnClear.setBounds(400, 300, 100, 40);
        add(btnClear);

        btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSignUp.setBounds(500, 300, 100, 40);
        add(btnSignUp);

        // Listeners
        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        btnSignUp.addActionListener(this);

        // Frame properties
        setVisible(true);
        setSize(800, 500);
        setLocation(400, 200);
        getContentPane().setBackground(Color.decode("#41a7f5"));
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == btnLogin) {
                ConnectionFactory cf = new ConnectionFactory();
                String cardNum = tfCardNumber.getText();
                String pin = pfPinNumber.getText();

                // ✅ Fixed column name from 'card' to 'cardnumber'
                String query = "SELECT * FROM Login WHERE cardnumber='" + cardNum + "' AND pin='" + pin + "'";
                ResultSet rs = cf.stmt.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Either Card Number or PIN is incorrect");
                }

            } else if (ae.getSource() == btnClear) {
                tfCardNumber.setText("");
                pfPinNumber.setText("");
            } else if (ae.getSource() == btnSignUp) {
                this.setVisible(false);
                new Signup();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
