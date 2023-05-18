package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//import panel.LoginMainPanel2.PasswordFieldFocusListener;
//import panel.LoginMainPanel2.PhoneNumberFieldFocusListener;

public class LoginPanel extends JPanel {
	
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user  = "teamproject";
	private static String password = "1234";
	
	NumberKeypad numpad= new NumberKeypad();
	JTextField userPhonNumber = new JTextField();
	
	JPasswordField userPassField = new JPasswordField();
	
	JButton loginButton = new JButton(new ImageIcon("ui/main/button/main_Login_Button.png"));
	JButton memberJoinBtn=new JButton(new ImageIcon("ui/main/button/main_MemeberShip_Button.png"));
	
	
	ImageIcon im =new ImageIcon("ui/main/Main_Default_Ui_Frame");
	Image image=im.getImage();
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	
	public LoginPanel() {
		setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		
		add(numpad);
		numpad.setBounds(1080,50,550,690);
		add(loginPanel);
		loginPanel.setBounds(0,0,990,760);
		
		
		loginPanel.add(userPhonNumber);
		loginPanel.add(userPassField);
		loginPanel.add(loginButton);
		loginPanel.add(memberJoinBtn);
		
		setBackground(new Color(73,67,68));
		loginPanel.setBackground(new Color(73,67,68));
		
		
		
		// 핸드폰 번호 입력 TextField 
		userPhonNumber.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPhonNumber.setText(" 핸드폰 번호");
		userPhonNumber.setOpaque(false);
		userPhonNumber.setBounds(90, 318, 800, 110);
		userPhonNumber.setSelectionColor(new Color(0, 0, 0, 0));
		//add(userPhonNumber);
		
		userPhonNumber.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				numpad.setTextField(userPhonNumber);
				numpad.setMax(12);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				userPhonNumber.setText("");
				
			}
		});
		
		 
		// 비밀 번호 입력 TextField 
		
		userPassField.setText(" 비밀번호 (6자리)");
		userPassField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPassField.setEchoChar((char) 0); // 텍스트가 가려지지 않도록 EchoChar를 0으로 설정
		userPassField.setOpaque(false);
		userPassField.setBounds(90, 430, 800, 110);
		userPassField.setSelectionColor(new Color(0, 0, 0, 0));
		//add(userPassField);
		
		userPassField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				numpad.setTextField(userPassField);
				numpad.setMax(5);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				userPassField.setText("");
				
			}
		});
		
		
		
		/*
		  Bottom 회원가입 / 로그인 버튼
		 */
		
		memberJoinBtn.setContentAreaFilled(false);
		memberJoinBtn.setBorderPainted(false);
		memberJoinBtn.setFocusPainted(false);
		memberJoinBtn.setBounds(80,590,400,148);
		
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		loginButton.setBounds(510,590,400,148);
		
		
		
	
//		add(userPhonNumber);
//		add(userPassField);
//		add(loginButton);
//		add(memberJoinBtn);
		
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
