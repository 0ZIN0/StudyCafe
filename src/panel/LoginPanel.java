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

public class LoginPanel extends JPanel {
	
	//public JButton memberJoinBtn;
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user  = "teamproject";
	private static String password = "1234";
	
	
	
	GridLayout grid = new GridLayout(4,1);
	JTextField userPhonNumber = new JTextField();
	JPasswordField userPassField = new JPasswordField();
	JButton loginButton = new JButton("로그인");
	JButton memberJoinBtn=new JButton("회원가입");
	
	
	
	
	public LoginPanel() {
		
		//setBorder(new TitledBorder(new LineBorder(Color.red,5)));
		//setLayout(null);
		//setBounds(0,200,1920,880);
		
		//memberJoinBtn.setBounds(0,0,200,200);
		
		//JPanel loginP = new JPanel(grid);
		//loginP.setBounds(0,0,500,500);
		
		setLayout(grid);
		setBackground(new Color(73,67,68));
	
		add(userPhonNumber);
		add(userPassField);
		add(loginButton);
		add(memberJoinBtn);
		
		
		
		
		
		
		
		
		
		
		
		
//		userPhonNumber.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String command = e.getActionCommand();
//		        if (command.equals("지우기")) {  // Clear 버튼 클릭 시 텍스트필드 초기화
//		        	textField.setText("");
//		        } else {  // 숫자 버튼 클릭 시 해당 숫자를 텍스트 필드에 추가
//		            textField.setText(textField.getText() + command);
//		        }
//				
//			}
//		});
		
		
		
		
		
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
						JOptionPane.showMessageDialog(new LoginMainPanel().background, "@@로그인성공@@");
		               System.out.println("로그인성공");
		            } else {
		            	JOptionPane.showMessageDialog(new LoginMainPanel().background, "로그인실패!!!");
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
}
