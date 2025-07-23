package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel heading;
    JTextArea statementArea;
    JButton back, exit;
    String pin;

    MiniStatement(String pin) {
        this.pin = pin;

        // ATM Background
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = atmIcon.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 960, 1000);
        add(background);

        setLayout(null);

        // Heading
        heading = new JLabel("MINI STATEMENT");
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 20));
        heading.setBounds(400, 245, 250, 30);
        background.add(heading);

        // Statement Area Setup
        statementArea = new JTextArea();
        statementArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        statementArea.setEditable(false);

        // ✅ Blue text with white background
        statementArea.setForeground(new Color(0, 0, 200));  // Blue text
        statementArea.setBackground(Color.WHITE);           // White background

        // ✅ Optional border
        statementArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(statementArea);
        scrollPane.setBounds(275, 310, 410, 220);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);

        // Back Button
        back = new JButton("Back");
        back.setBounds(250, 570, 150, 30);
        background.add(back);
        back.addActionListener(this);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBounds(555, 570, 150, 30);
        background.add(exit);
        exit.addActionListener(this);

        // Frame Setup
        setSize(900, 900);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);

        showStatement();
    }

    public void showStatement() {
        try {
            ConnectionFactory cf = new ConnectionFactory();
            ResultSet rs = cf.stmt.executeQuery(
                "SELECT * FROM bank WHERE pin = '" + pin + "' ORDER BY date DESC LIMIT 7");

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-25s%-12s%-10s\n", "Date & Time", "Type", "Amount"));
            sb.append("-------------------------------------------\n");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                sb.append(String.format("%-25s%-12s%-10s\n", date, type, amount));
            }

            if (!hasData) {
                sb.append("No transactions found.");
            }

            statementArea.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);  // Back to transaction screen
        } else if (ae.getSource() == exit) {
            setVisible(false);
            new Login().setVisible(true);  // Exit to login screen
        }
    }

    public static void main(String[] args) {
        new MiniStatement("1234");  // Test run
    }
}
