package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class Signup extends JFrame implements ActionListener{
	// Instance variable..............
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
	JTextField tfName, tfFatherName, tfEmail, tfAddress, tfCity, tfPin, tfState;
	JRadioButton rbnMale, rbnFemale, rbnMarried, rbnUnmarried, r5;
	JButton btnNext;
	
	JDateChooser dateChooser;
	
	Random r = new Random();
	long randNum = r.nextLong()%9000+1000;
	String number = ""+Math.abs(randNum);
	
	// Non param constructor..........
	public Signup() {
		setTitle("New Account Application Form");
		setLayout(null);
		 
		l1 = new JLabel("Application Form:"+ number);
		l1.setFont(new Font("Raleway", Font.BOLD,40));
		l1.setBounds(150,20,600,40);
		add(l1);
		
		l2 = new JLabel("Personal Details Of Customer");
		l2.setFont(new Font("Arial", Font.BOLD,25));
		l2.setBounds(200,80,600,30);
		add(l2);
		
		l3 = new JLabel("Your Name:");
		l3.setFont(new Font("Arial", Font.BOLD,20));
		l3.setBounds(100,130,200,30);
		add(l3);
		tfName = new JTextField(15);
		tfName.setFont(new Font("Arial", Font.BOLD, 20));
		tfName.setBounds(310,130,200,30);
		add(tfName);
		
		l4 = new JLabel("Father Name:");
		l4.setFont(new Font("Arial", Font.BOLD,20));
		l4.setBounds(100,180,200,30);
		add(l4);
		tfFatherName = new JTextField(15);
		tfFatherName.setFont(new Font("Arial", Font.BOLD, 20));
		tfFatherName.setBounds(310,180,200,30);
		add(tfFatherName);
		
		
		l5 = new JLabel("Date Of Birth:");
		l5.setFont(new Font("Arial", Font.BOLD,20));
		l5.setBounds(100,230,200,30);
		add(l5);
		dateChooser = new JDateChooser();
		//dateChooser.setForeground(new Color(200, 0, 0));
		dateChooser.setBounds(310,230,200,30);
		add(dateChooser);
		
		l6 = new JLabel("Gender :");
		l6.setFont(new Font("Arial", Font.BOLD,20));
		l6.setBounds(100,280,200,30);
		add(l6);
		rbnMale = new JRadioButton("Male");
		rbnMale.setFont(new Font("Tahoma", Font.BOLD,14));
		rbnMale.setBackground(Color.white);
		rbnMale.setBounds(310,280,100,30);
		add(rbnMale);
		rbnFemale = new JRadioButton("Female");
		rbnFemale.setFont(new Font("Tahoma", Font.BOLD,14));
		rbnFemale.setBackground(Color.white);
		rbnFemale.setBounds(410,280,100,30);
		add(rbnFemale);
		
		ButtonGroup bgGender = new ButtonGroup();
		bgGender.add(rbnMale);
		bgGender.add(rbnFemale);
		
		l7 = new JLabel("Email Address:");
		l7.setFont(new Font("Arial", Font.BOLD,20));
		l7.setBounds(100,330,200,30);
		add(l7);
		tfEmail = new JTextField(15);
		tfEmail.setFont(new Font("Arial", Font.BOLD, 20));
		tfEmail.setBounds(310,330,200,30);
		add(tfEmail);
		
		l8 = new JLabel("Marital Status:");
		l8.setFont(new Font("Arial", Font.BOLD,20));
		l8.setBounds(100,370,200,30);
		add(l8);
		rbnMarried = new JRadioButton("Married");
		Font f = new Font("Tahoma", Font.BOLD,14);
		rbnMarried.setFont(f);
		rbnMarried.setBackground(Color.white);
		rbnMarried.setBounds(305, 370, 100, 30);
		add(rbnMarried);
		rbnUnmarried = new JRadioButton("Un Married");
		//Font f = new Font("Tahoma", Font.BOLD,14);
		rbnUnmarried.setFont(f);
		rbnUnmarried.setBackground(Color.white);
		rbnUnmarried.setBounds(410, 370, 100, 30);
		add(rbnUnmarried);
		ButtonGroup bgStatus = new ButtonGroup();
		bgStatus.add(rbnMarried);
		bgStatus.add(rbnUnmarried);
		
		l9 = new JLabel("Address:");
		l9.setFont(new Font("Arial", Font.BOLD,20));
		l9.setBounds(100,410,200,30);
		add(l9);
		tfAddress = new JTextField(15);
		tfAddress.setFont(new Font("Arial", Font.BOLD, 20));
		tfAddress.setBounds(310,410,300,30);
		add(tfAddress);
		
		l10 = new JLabel("City:");
		l10.setFont(new Font("Arial", Font.BOLD,20));
		l10.setBounds(100,460,300,30);
		add(l10);
		tfCity = new JTextField(15);
		tfCity.setFont(new Font("Arial", Font.BOLD, 20));
		tfCity.setBounds(305,460,200,30);
		add(tfCity);
		
		l11 = new JLabel("Pin Code:");
		l11.setFont(new Font("Arial", Font.BOLD,20));
		l11.setBounds(100,510,200,30);
		add(l11);
		tfPin = new JTextField(15);
		tfPin.setFont(new Font("Arial", Font.BOLD, 20));
		tfPin.setBounds(310,510,200,30);
		add(tfPin);
		
		l12 = new JLabel("State:");
		l12.setFont(new Font("Arial", Font.BOLD,20));
		l12.setBounds(100,560,200,30);
		add(l12);
		tfState = new JTextField(15);
		tfState.setFont(new Font("Arial", Font.BOLD, 20));
		tfState.setBounds(310,560,200,30);
		add(tfState);
		
		btnNext = new JButton("Next");
		btnNext.setFont(f);
		btnNext.setBackground(Color.black);
		btnNext.setForeground(Color.white);
		btnNext.setBounds(600,600,80,30);
		add(btnNext);
		btnNext.addActionListener(this);
		
		l13 = new JLabel("Date:");
		l13.setFont(new Font("Arial", Font.BOLD,20));
		l13.setBounds(100,610,200,30);
		add(l13);
		
		l14 = new JLabel("Month:");
		l14.setFont(new Font("Arial", Font.BOLD,20));
		l14.setBounds(100,660,200,30);
		add(l14);
		
		l15 = new JLabel("Year:");
		l15.setFont(new Font("Arial", Font.BOLD,20));
		l15.setBounds(100,720 ,200,30);
		add(l15);
		
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setSize(800, 700);
		setLocation(400, 100);
	}

	public static void main(String[] args) {
    Signup obj = new Signup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formNum = number;
		String name = tfName.getText() ;
		String fname = tfFatherName.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(rbnMale.isSelected()) {
			gender="Male";
		}else if(rbnFemale.isSelected()) {
			gender ="Female";
		}
		String email = tfEmail.getText();
		String maritalStatus = null;
		if(rbnMarried.isSelected()) {
			maritalStatus ="Married";
		}
		else if(rbnUnmarried.isSelected()) {
			maritalStatus ="UnMarried";
		}
		String address =tfAddress.getText();
		String city = tfCity.getText();
		String Pincode = tfPin.getText();
		String state = tfState.getText();
		
		try {
		if(tfName.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Pleasse enter your name");
		}else {
			ConnectionFactory cf = new ConnectionFactory();
			String query = "insert into signup values('"+formNum+"','"+name+"','"+fname+"', '"+dob+"','"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+Pincode+"', '"+state+"')";
			cf.stmt.executeUpdate(query);
			//JOptionPane.showMessageDialog(null, "Congrates");  
			setVisible(false);
			new SignupTwo(formNum).setVisible(true);
		}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		}

}
