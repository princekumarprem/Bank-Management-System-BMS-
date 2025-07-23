package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField tf1;
    JButton b1, b2;
    JLabel l1, l3;
    String pin;

    public Deposit(String pin) {
        this.pin = pin;

        setTitle("Deposit Page");
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);

        // Load and scale image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        l3.setLayout(null); // ✅ This is important
        add(l3);

        // Text label
        l1 = new JLabel("Enter amount you want to Deposit");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(320, 270, 400, 35);
        l3.add(l1);

        // Text field
        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway", Font.BOLD, 22));
        tf1.setBounds(295, 350, 320, 25);
        l3.add(tf1);

        // Deposit button
        b1 = new JButton("DEPOSIT");
        b1.setBounds(240, 460, 150, 35);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(505, 460, 150, 35);
        l3.add(b2);

        // Action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      try {
    	  String amount = tf1.getText();
    	  Date date = new Date();
    	  if(ae.getSource()==b1) {
    		  if(tf1.getText().equals("")) {
    			  JOptionPane.showConfirmDialog(null, "Please Enter Some Amount");
    		  }
    		  else {
    			  ConnectionFactory cf = new ConnectionFactory();
    			cf.stmt.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit','"+amount+"')");
    			JOptionPane.showMessageDialog(null, "Rs."+amount+" Deposited Successfully");
    			setVisible(false);
    			new Transactions(pin).setVisible(true);
    		  }
    	  }
    	  else if(ae.getSource()==b2) {
    		  setVisible(false);
    		  new Transactions(pin).setVisible(true);
    	  }
      }
      catch(Exception e){
    	  e.printStackTrace();
      }
    }
}

