package panel;

import java.awt.Color;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class LoginPanel extends JPanel{
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "teamproject";
	private static String password = "1234";
	
	public LoginPanel() {
		GridLayout grid = new GridLayout(3,1);
		JTextField userPhonNumber = new JTextField();
		JPasswordField userPassField = new JPasswordField();
		JButton loginButton = new JButton("Login");
		JPanel loginP = new JPanel(grid);
		
		add(loginP);
		loginP.add(userPhonNumber);
		loginP.add(userPassField);
		loginP.add(loginButton);
		
		loginP.setBounds(0,0,300,300);
		setBorder(new TitledBorder(new LineBorder(Color.red,5)));
		setLayout(null);
		setBounds(0,200,1920,880);
		
		
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phon = userPhonNumber.getText();
				String pass = new String(userPassField.getPassword());
				
				try {
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement stmt = conn.prepareStatement("SELECT * FROM member WHERE phone_number=? AND member_password=?");
		            stmt.setString(1, phon);
		            stmt.setString(2, pass);
		            ResultSet rs = stmt.executeQuery();	
		            
					if (rs.next()) {
						JOptionPane.showMessageDialog(loginP, "@@로그인성공@@");
		               System.out.println("로그인성공");
		            } else {
		            	JOptionPane.showMessageDialog(loginP, "로그인실패!!!");
		                System.out.println("로그인 실패");
		            }

		            rs.close();
		            stmt.close();
					
				} catch (SQLException  e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		LoginPanel a = new LoginPanel();
		
		f.add(a);
		
		
		f.setLayout(null);
		f.setVisible(true);
		f.setBounds(0,0,1920,1080);
	}

}
