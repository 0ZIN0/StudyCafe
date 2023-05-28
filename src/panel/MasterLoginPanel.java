package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dao.LoginDAO;
import frame.MainFrame;
import frame.MasterLoginFrame;
import frame.MasterMenuFrame;

public class MasterLoginPanel extends JPanel{
	
	MasterMenuFrame masterMenuFrame;
	//MasterLoginFrame masterLoginFrame = new MasterLoginFrame();
	
	NumberKeypad numpad= new NumberKeypad();
	
	JButton loginButton = new JButton(new ImageIcon("ui/master/masterLogin/Master_Login_Button.png"));
	
	// 필드 테두리 제거
	JTextField userPhonNumber = new JTextField() {
			@Override
			public void setBorder(Border border) {
			}
			
		};
		
	// 필드 테두리 제거
	JPasswordField userPassField = new JPasswordField(){
		@Override
		public void setBorder(Border border) {
		}
	};
	
	
	
	ImageIcon im =new ImageIcon("ui/master/masterLogin/Master_Login_Contents.jpg");
	Image image=im.getImage();

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	
	
	public MasterLoginPanel(MasterLoginFrame parent) {
		setLayout(null);
		
		
		add(numpad);
		add(userPhonNumber);
		add(userPassField);
		add(loginButton);
		
		// 넘패드 위치
		numpad.setBounds(1080,50,550,690);
		numpad.setTextField(userPhonNumber);
		
		
		// 핸드폰 번호 입력 TextField 
		
		userPhonNumber.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPhonNumber.setText(" 핸드폰번호");
		userPhonNumber.setOpaque(false);
		userPhonNumber.setBounds(90, 120, 800, 110);
		userPhonNumber.setForeground(new Color(217,217,217));
		
		userPhonNumber.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				numpad.phoneSelect = true;
				numpad.setTextField(userPhonNumber);
				numpad.setMax(12);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				userPhonNumber.setText("");
				numpad.phoneSelect = false;
			}
		});
		
		
		
		// 비밀 번호 입력 TextField 
		userPassField.setText(" 비밀번호 (6자리)");
		userPassField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPassField.setEchoChar((char) 0); // 텍스트가 가려지지 않도록 EchoChar를 0으로 설정
		userPassField.setOpaque(false);
		userPassField.setBounds(90, 221, 800, 110);
		userPassField.setForeground(new Color(217,217,217));
		
		userPassField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				numpad.setTextField(userPassField);
				numpad.setMax(5);
				numpad.phoneSelect = false;
				char[] password = userPassField.getPassword();
    	        String passwordString = new String(password);
    	        userPassField.setText("");
    	        userPassField.setEchoChar('●');  
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				userPassField.setText("");
				
			}
		});
		
		
		/*
		   로그인 버튼
		 */
		
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		loginButton.setBounds(80,590,838,148);
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				new MasterMenuFrame();
//				parent.dispose();
				
				String phoneNum = userPhonNumber.getText();
				String password = new String(userPassField.getPassword());
				
				if(LoginDAO.masterCheckPhoneNum(phoneNum, password)) {
					parent.dispose();
				}
		
				
			}
		});

		
		
		
	}

}
