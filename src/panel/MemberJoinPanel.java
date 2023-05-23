package panel;
import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import dao.LoginDAO;
import dialog.setPopup;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.util.regex.Pattern;
import dto.MemberJoin;

public class MemberJoinPanel extends JPanel  {
	
	JLabel phoneLabel, passwordLabel, confirmPasswordLabel, birthdayLabel;
    JTextField phoneField;
    JPasswordField passwordField;
	JPasswordField confirmPasswordField;
    JButton submitButton,beforeButton;
    JButton phonduplicationBtn;
    
    GridLayout grid = new GridLayout(10,2);
    NumberKeypad numpad= new NumberKeypad();

	@Override
    public void setBorder(Border border) {
		
    }
    
	//핸드폰 정규표현식
    static String phonnumRegular = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
    
    // 생년월일 정규표현식
    static String dayRegular = "(19|20)\\d{2}\\-((11|12)|(0?(\\d)))\\-(30|31|((0|1|2)?\\d))";
	
	ImageIcon im =new ImageIcon("ui/main/Memberjoin/Main_membership_Left_Frame.jpg");
	Image image=im.getImage();
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
    public MemberJoinPanel(MemberJoin memberjoin, CardLayout card) {
    	
    	UserInfoCheckPanel UserInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
    	
    	
    	phoneField = new JTextField();
       	passwordField = new JPasswordField();
       	confirmPasswordField = new JPasswordField();
       	
       	phoneField.setBorder(getBorder());
       	passwordField.setBorder(getBorder());
       	confirmPasswordField.setBorder(getBorder());
    	
    	submitButton = new JButton(new ImageIcon("ui/main/Memberjoin/Next_Button.png"));
    	beforeButton = new JButton(new ImageIcon("ui/main/Memberjoin/Before_Button.png"));
    	phonduplicationBtn= new JButton(new ImageIcon("ui/main/Memberjoin/DuplicateCheck_Button.png"));
    	
    	add(numpad);
    	
		numpad.setBounds(1080,50,550,690);
    	
	    phoneField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
	    phoneField.setText("핸드폰 번호");
	    phoneField.setOpaque(false);
	    phoneField.setBounds(80, 117, 900, 110);
	    phoneField.setOpaque(false);
	    
	    passwordField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
	    passwordField.setText("비밀번호 (6자리)");
	    passwordField.setEchoChar((char) 0);
	    passwordField.setOpaque(false);
	    passwordField.setBounds(80, 288, 900, 110);
	    passwordField.setOpaque(false);
	    
	    confirmPasswordField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
	    confirmPasswordField.setText("비밀번호 확인 (6자리)");
	    confirmPasswordField.setOpaque(false);
	    confirmPasswordField.setBounds(80, 456, 900, 110);
	    confirmPasswordField.setOpaque(false);
	    confirmPasswordField.setEchoChar((char) 0);
	    
	    beforeButton.setBounds(80, 590, 400, 148);
	    beforeButton.setFocusPainted(false);
	    beforeButton.setBorderPainted(false);
	    beforeButton.setContentAreaFilled(false);
	    
	    submitButton.setBounds(510, 590, 400, 148);
	    submitButton.setFocusPainted(false);
	    submitButton.setBorderPainted(false);
	    submitButton.setContentAreaFilled(false);
	    
	    phonduplicationBtn.setBounds(600, 0, 250, 110);
	    phonduplicationBtn.setFocusPainted(false);
	    phonduplicationBtn.setBorderPainted(false);
	    phonduplicationBtn.setContentAreaFilled(false);
	    
	    // 폰번호 포커스 이벤트
	    phoneField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(phoneField);
        		numpad.setMax(12);
        		numpad.phoneSelect = true;
        	}
        	
        	@Override
			public void focusGained(FocusEvent e) {
        		phoneField.setText("");
				
			}
		});

	    // 비밀번호 포커스 이벤트
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(passwordField);
        		numpad.setMax(5);
        		char[] password = passwordField.getPassword();
    	        String passwordString = new String(password);
    	        passwordField.setText("");
    	        passwordField.setEchoChar('●');        		
        	}
        	
        	@Override
			public void focusGained(FocusEvent e) {
        		passwordField.setText("");
        		numpad.phoneSelect = false;
				
			}
		});
        
        // 비밀번호확인 포커스 이벤트
        confirmPasswordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(confirmPasswordField);
        		numpad.setMax(5);
        		char[] confirmpassword = confirmPasswordField.getPassword();
    	        String confirmPasswordString = new String(confirmpassword);
    	        confirmPasswordField.setText("");
    	        confirmPasswordField.setEchoChar('●');  
        	}
        	@Override
			public void focusGained(FocusEvent e) {
        		confirmPasswordField.setText("");
        		numpad.phoneSelect = false;
        	}
		});
        
        add(phoneField);
        add(passwordField);
        add(confirmPasswordField);
        add(submitButton);
        add(beforeButton);
        
        // 이전버튼
        beforeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "login");
			}
		});
        
        // 회원가입 버튼
        submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNum = phoneField.getText();
	            String password = new String(passwordField.getPassword());
	            String confirmPassword = new String(confirmPasswordField.getPassword());
	            
	            memberjoin.setPhone(phoneNum);
	            memberjoin.setPassword(password);
	            
	            //휴대번호 양식 확인
	            if(!Pattern.matches(phonnumRegular, phoneNum)) {           
	            	
	            	new setPopup(new ImageIcon("ui/main/memberjoinPopup/errorphoneformat.png")).setVisible(true);
	            	return;
	            }
	            // 비밀번호 6자리 확인
	            if(password.length() != 6) {
	            	
	            	new setPopup(new ImageIcon("ui/main/memberjoinPopup/Password_6.png")).setVisible(true);
	            	return;
				}
	            // 비밀번호 불일치
	            if(!password.equals(confirmPassword)) {
	            	
	            	new setPopup(new ImageIcon("ui/main/memberjoinPopup/errorpass.png")).setVisible(true);
	            	return;
				}
	            if(LoginDAO.checkDup(phoneNum)) {	            	
	            	card.show(getParent(), "userInfoCheck");      
	            	
	            }
			}  
		});
        
        // 패널 설정
        setBounds(0,0,990,760);
    	setOpaque(false);
        setLayout(null);
    } 
}