package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//import panel.LoginMainPanel2.PasswordFieldFocusListener;
//import panel.LoginMainPanel2.PhoneNumberFieldFocusListener;

public class LoginPanel extends JPanel {
	
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user  = "teamproject";
	private static String password = "1234";
	
	
	
	//GridLayout grid = new GridLayout(4,1);
	JTextField userPhonNumber = new JTextField();
	JPasswordField userPassField = new JPasswordField();
	JButton loginButton = new JButton("로그인");
	JButton memberJoinBtn=new JButton("회원가입");
	
	
	ImageIcon im =new ImageIcon("ui/main/Main_Left_Frame.png");
	Image image=im.getImage();
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	
	
	
	public LoginPanel() {
		
		
		setLayout(null);
		
		// 핸드폰 번호 입력 TextField 
		userPhonNumber.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPhonNumber.setText("핸드폰 번호");
		userPhonNumber.setOpaque(false);
		userPhonNumber.setBounds(0, 0, 800, 100);
		userPhonNumber.setSelectionColor(new Color(0, 0, 0, 0));
		add(userPhonNumber);
		userPhonNumber.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		// 비밀 번호 입력 TextField 
		userPassField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		userPassField.setText("비밀번호");
		userPassField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPassField.setEchoChar((char) 0); // 텍스트가 가려지지 않도록 EchoChar를 0으로 설정
		userPassField.setOpaque(false);
		userPassField.setBounds(0, 100, 800, 100);
		userPassField.setSelectionColor(new Color(0, 0, 0, 0));
		add(userPassField);
		
		userPassField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent key) {
				JPasswordField src = (JPasswordField)key.getSource();
				if(src.getPassword().length >= 6) {
					key.consume();
				}
			}
		});
		
		
		/*
		  Bottom 회원가입 / 로그인 버튼
		 */
		
		memberJoinBtn.setContentAreaFilled(false);
		memberJoinBtn.setBorderPainted(false);
		memberJoinBtn.setFocusPainted(false);
		memberJoinBtn.setBounds(0,200,400,148);
		
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		loginButton.setBounds(0,348,400,148);
		
		
		
		
		
		
		
		//setLayout(grid);
		setBackground(new Color(73,67,68));
	
		add(userPhonNumber);
		add(userPassField);
		add(loginButton);
		add(memberJoinBtn);
		
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
