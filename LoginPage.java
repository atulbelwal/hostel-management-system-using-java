import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//user login page


public class LoginPage implements ActionListener{
	
	String folderPath = "C:\\ProjectData\\";
	
	JFrame frame = new JFrame();
	String logo = "banner.jpg";
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("USER NAME:");
	JLabel userPasswordLabel = new JLabel("PASSWORD:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		frame.setTitle("Hostel Complaint Management Login");
		Image icon = Toolkit.getDefaultToolkit().getImage(folderPath + logo);  
		frame.setIconImage(icon); 
		frame.setLayout(new GridLayout(2, 1));
		//frame.getContentPane().setBackground( Color.red );
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new JLabel(new ImageIcon("C:\\ProjectData\\LOGO2.jpg")));
		frame.setLayout(new FlowLayout());
		
		
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,270,250,35);
		messageLabel.setFont(new Font(null,Font.BOLD,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,450);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
                    new mainscreen();

					frame.dispose();

				
				}
				else {
					messageLabel.setForeground(Color.WHITE);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.WHITE);
				messageLabel.setText("username not found");
			}
		}
	}	
}