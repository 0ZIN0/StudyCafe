package panel;

import java.awt.CardLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dao.LoginDAO;
import frame.MasterLoginFrame;
import label.RemainLockerLabel;
import label.RemainSeatLabel;
import label.RemainStudyRoomLabel;

public class LoginPanel extends JPanel {
	
	MasterLoginFrame masterFrame;
	
	NumberKeypad numpad= new NumberKeypad();
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
	
	JButton loginButton = new JButton(new ImageIcon("ui/main/button/main_Login_Button.png"));
	JButton memberJoinBtn=new JButton(new ImageIcon("ui/main/button/main_MemeberShip_Button.png"));
	
	ImageIcon im =new ImageIcon("ui/main/Login/Main_Left_Frame.jpg");
	Image image=im.getImage();

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	// 좌석 현황 라벨들
	JLabel remainSeatLabel = new RemainSeatLabel();
	JLabel remainStudyRoomLabel = new RemainStudyRoomLabel();
	JLabel remainLockerLabel = new RemainLockerLabel();
	
	public LoginPanel(CardLayout card, JFrame parent) {
	
		// 좌석 현황 라벨 설정
		remainSeatLabel.setBounds(149, 220, 200, 54);
		remainSeatLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		remainLockerLabel.setBounds(709, 220, 200, 54);
		remainLockerLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		
		add(remainSeatLabel);
		add(remainStudyRoomLabel);
		add(remainLockerLabel);
		
		setLayout(null);
		add(numpad);
		numpad.setBounds(1080,50,550,690);
		//setBounds(0,0,990,760);
		
		add(userPhonNumber);
		add(userPassField);
		add(loginButton);
		add(memberJoinBtn);
		
		// 핸드폰 번호 입력 TextField 
		userPhonNumber.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		userPhonNumber.setText(" 핸드폰번호");
		userPhonNumber.setOpaque(false);
		userPhonNumber.setBounds(90, 318, 800, 110);
		userPhonNumber.setForeground(new Color(141,135,135));
		
		
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
		userPassField.setBounds(90, 430, 800, 110);
		userPassField.setForeground(new Color(141,135,135));
		
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
		
		// 회원가입버튼 이벤트
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "memberjoin");
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
		
		
		
		
		// 로그인 버튼 이벤트
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNum = userPhonNumber.getText();
				String password = new String(userPassField.getPassword());
				
				if(LoginDAO.checkPhoneNum(phoneNum, password)) {
					parent.dispose();
				}
			}
		});
	}
}
