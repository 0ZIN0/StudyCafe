package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginMainPanel2 extends JPanel{
	
	BackgroundPanel bg = new BackgroundPanel(new ImageIcon("ui/background/Main_Default_Ui_BG.png"));
	JButton memberShipBtn = new JButton(new ImageIcon("ui/main_MemeberShip_Button.png"));
	JButton loginBtn = new JButton(new ImageIcon("ui/main_Login_Button.png"));
	CardLayout card = new CardLayout();
	
	JTextField phoneNumTextbox = new JTextField() {
		@Override
		public void setBorder(Border border) {
		}
	};
	
	JPasswordField passwordTextbox = new JPasswordField() {
		@Override
		public void setBorder(Border border) {
		}
	};
	
	public LoginMainPanel2() {
	///////////////////////////////////////////////////
		
		/* Top 좌석, 스터디룸, 사물함 잔여 좌석 라벨*/
		JLabel seat = new JLabel();
		seat.setBounds(290,448,130,46);
		seat.setText("0 / 32");
		seat.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 46));
		seat.setForeground(Color.WHITE);
		
		JLabel studyRoom = new JLabel();
		studyRoom.setBounds(580,448,130,46);
		studyRoom.setText("0 / 2");
		studyRoom.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 46));
		studyRoom.setForeground(Color.WHITE);
		
		JLabel locker = new JLabel();
		locker.setBounds(853,448,130,46);
		locker.setText("0 / 20");
		locker.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 46));
		locker.setForeground(Color.WHITE);
		
	/////////////////////////////////////////////////	
		
		
		
		
		
		
		
		// 핸드폰 번호 입력 TextField 
		phoneNumTextbox.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		phoneNumTextbox.setText("핸드폰 번호");
		phoneNumTextbox.setOpaque(false);
		phoneNumTextbox.setBounds(215, 548, 800, 100);
		phoneNumTextbox.setSelectionColor(new Color(0, 0, 0, 0));
		add(phoneNumTextbox);
		phoneNumTextbox.addFocusListener(new PhoneNumberFieldFocusListener());
		 
		// 비밀 번호 입력 TextField 
		passwordTextbox.addFocusListener(new PasswordFieldFocusListener());
		passwordTextbox.setText("비밀번호");
		passwordTextbox.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		passwordTextbox.setEchoChar((char) 0); // 텍스트가 가려지지 않도록 EchoChar를 0으로 설정
		passwordTextbox.setOpaque(false);
		passwordTextbox.setBounds(215, 660, 800, 100);
		passwordTextbox.setSelectionColor(new Color(0, 0, 0, 0));
		add(passwordTextbox);
		
		passwordTextbox.addKeyListener(new KeyAdapter(){
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
		
		memberShipBtn.setContentAreaFilled(false);
		memberShipBtn.setBorderPainted(false);
		memberShipBtn.setFocusPainted(false);
		memberShipBtn.setBounds(220,800,400,148);
		
		loginBtn.setBorderPainted(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setFocusPainted(false);
		loginBtn.setBounds(640,800,400,148);
		
		
		
		
		
		
		
		
		// Bottom Button
		add(memberShipBtn);
		add(loginBtn);
		
		// Top Label 
		bg.add(seat);
		bg.add(studyRoom);
		bg.add(locker);
		
		add(bg);
		bg.setLocation(0, 0);
		bg.setBackground(new Color(0,0,0,0));
		

		setLayout(null);
		
		
		NumberKeypad numPad = new NumberKeypad();
		bg.add(numPad);
		numPad.setBounds(1180,266, 520, 680);
		
		
	} // end of constructor
	
	
	private class PhoneNumberFieldFocusListener implements FocusListener {
	    @Override
	    public void focusGained(FocusEvent e) {
	        // 포커스를 얻었을 때, 텍스트가 "핸드폰 번호"라면 텍스트를 지움
	        if (phoneNumTextbox.getText().equals("핸드폰 번호")) {
	            phoneNumTextbox.setText("");
	        }
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
	        // 포커스를 잃었을 때, 텍스트 필드가 비어있으면 "핸드폰 번호"를 다시 표시
	        if (phoneNumTextbox.getText().isEmpty()) {
	            phoneNumTextbox.setText("핸드폰 번호");
	        }
	    }
	}
	
	private class PasswordFieldFocusListener implements FocusListener {
	    @Override
	    public void focusGained(FocusEvent e) {
	        // 포커스를 얻었을 때, 텍스트가 "비밀번호"라면 텍스트를 지움
	        char[] password = passwordTextbox.getPassword();
	        String passwordString = new String(password);
	        if (passwordString.equals("비밀번호")) {
	            passwordTextbox.setText("");
	            passwordTextbox.setEchoChar('●'); // 입력한 텍스트를 *로 가려줌
	        }
	    }

	    @Override
	    public void focusLost(FocusEvent e) {
	        // 포커스를 잃었을 때, 텍스트 필드가 비어있으면 "비밀번호"를 다시 표시
	        char[] password = passwordTextbox.getPassword();
	        if (password.length == 0) {
	            passwordTextbox.setText("비밀번호");
	            passwordTextbox.setEchoChar((char) 0); // 텍스트가 가려지지 않도록 EchoChar를 0으로 설정
	        }
	    }
	}
 } // end of class

