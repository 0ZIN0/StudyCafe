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
import frame.LoginFrame;

public class MemberJoinPanel extends JPanel  {
	
	JLabel phoneLabel, passwordLabel, confirmPasswordLabel, birthdayLabel;
    JTextField joinphoneField;
    JPasswordField joinpasswordField;
	JPasswordField joinconfirmPasswordField;
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
	
	
	
    public MemberJoinPanel(MemberJoin memberJoin) {
    	
    	joinphoneField = new JTextField();
    	joinpasswordField = new JPasswordField();
    	joinconfirmPasswordField = new JPasswordField();
       	
    	joinphoneField.setBorder(getBorder());
    	joinpasswordField.setBorder(getBorder());
    	joinconfirmPasswordField.setBorder(getBorder());
    	
    	submitButton = new JButton(new ImageIcon("ui/main/Memberjoin/Next_Button.png"));
    	beforeButton = new JButton(new ImageIcon("ui/main/Memberjoin/Before_Button.png"));
    	phonduplicationBtn= new JButton(new ImageIcon("ui/main/Memberjoin/DuplicateCheck_Button.png"));
    	
    	joinphoneField.add(phonduplicationBtn);
    	
    	add(numpad);
    	
		numpad.setBounds(1080,50,550,690);
		numpad.setTextField(joinphoneField);
    	
		joinphoneField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		joinphoneField.setText("핸드폰번호");
		joinphoneField.setOpaque(false);
		joinphoneField.setBounds(90, 117, 900, 110);
		joinphoneField.setOpaque(false);
		joinphoneField.setForeground(new Color(217,217,217));
	    
		joinpasswordField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		joinpasswordField.setText("비밀번호 (6자리)");
		joinpasswordField.setEchoChar((char) 0);
		joinpasswordField.setOpaque(false);
		joinpasswordField.setBounds(90, 288, 900, 110);
		joinpasswordField.setOpaque(false);
		joinpasswordField.setForeground(new Color(217,217,217));
	    
		joinconfirmPasswordField.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		joinconfirmPasswordField.setText("비밀번호 확인 (6자리)");
		joinconfirmPasswordField.setOpaque(false);
		joinconfirmPasswordField.setBounds(90, 456, 900, 110);
		joinconfirmPasswordField.setEchoChar((char) 0);
		joinconfirmPasswordField.setForeground(new Color(217,217,217));
	    
	    beforeButton.setBounds(80, 590, 400, 148);
	    beforeButton.setFocusPainted(false);
	    beforeButton.setBorderPainted(false);
	    beforeButton.setContentAreaFilled(false);
	    
	    submitButton.setBounds(510, 590, 400, 148);
	    submitButton.setFocusPainted(false);
	    submitButton.setBorderPainted(false);
	    submitButton.setContentAreaFilled(false);
	    
	    
	    add(phonduplicationBtn);
	    phonduplicationBtn.setBounds(663, 115, 250, 110);
	    phonduplicationBtn.setFocusPainted(false);
	    phonduplicationBtn.setBorderPainted(false);
	    phonduplicationBtn.setContentAreaFilled(false);
	    
	    
	    // 중복체크버튼 이벤트
	    phonduplicationBtn.addActionListener(new ActionListener() {
	    	
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNum = joinphoneField.getText();
	            String password = new String(joinpasswordField.getPassword());
	            String confirmPassword = new String(joinconfirmPasswordField.getPassword());
//	            userPhoneNumber.setPhone(phoneNum);
//	            userPhoneNumber.setPassword(password);
	            
	            // 휴대번호 양식 확인
	            if(!Pattern.matches(phonnumRegular, phoneNum)) {  
	            	new setPopup(new ImageIcon("ui/main/memberjoinPopup/errorphoneformat.png")).setVisible(true);
	            	return;
	            }
	            
	            // 이미 저장된 휴대번호인지 확인
				if((LoginDAO.checkDup(phoneNum))) {	   
					new setPopup(new ImageIcon("ui/main/memberjoinPopup/possiblePhon.png"),230).setVisible(true);
	            } 
			}
		});
	    
	    
	    // 폰번호 포커스 이벤트
	    joinphoneField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(joinphoneField);
        		numpad.setMax(12);
        		numpad.phoneSelect = true;
        	}
        	
        	@Override
			public void focusGained(FocusEvent e) {
        		joinphoneField.setText("");
				
			}
		});

	    // 비밀번호 포커스 이벤트
	    joinpasswordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(joinpasswordField);
        		numpad.setMax(5);
        		char[] password = joinpasswordField.getPassword();
    	        String passwordString = new String(password);
    	        joinpasswordField.setText("");
    	        joinpasswordField.setEchoChar('●');        		
        	}
        	
        	@Override
			public void focusGained(FocusEvent e) {
        		joinpasswordField.setText("");
        		numpad.phoneSelect = false;
				
			}
		});
        
        // 비밀번호확인 포커스 이벤트
	    joinconfirmPasswordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(joinconfirmPasswordField);
        		numpad.setMax(5);
        		char[] confirmpassword = joinconfirmPasswordField.getPassword();
    	        String confirmPasswordString = new String(confirmpassword);
    	        joinconfirmPasswordField.setText("");
    	        joinconfirmPasswordField.setEchoChar('●');  
        	}
        	@Override
			public void focusGained(FocusEvent e) {
        		joinconfirmPasswordField.setText("");
        		numpad.phoneSelect = false;
        	}
		});
        
        add(joinphoneField);
        add(joinpasswordField);
        add(joinconfirmPasswordField);
        add(submitButton);
        add(beforeButton);
        
        // 이전버튼
        beforeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LoginFrame.masterBtn.setVisible(true);
				joinphoneField.setText(" 핸드폰번호");
				joinpasswordField.setText(" 비밀번호 (6자리)");
				joinpasswordField.setEchoChar((char) 0);
				joinconfirmPasswordField.setText("비밀번호 확인 (6자리)");
				joinconfirmPasswordField.setEchoChar((char) 0);
				LoginFrame.card.show(getParent(), "login");
				
				
			}
		});
        
        // 회원가입 버튼
        submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNum =joinphoneField.getText();
	            String password = new String(joinpasswordField.getPassword());
	            String confirmPassword = new String(joinconfirmPasswordField.getPassword());
	            
//	            joinuserPhonNumber.setPhone(phoneNum);
//	            joinuserPhonNumber.setPassword(password);
	            
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
	            	memberJoin.setPhone(phoneNum);
	            	memberJoin.setPassword(password);
	            	
	            	
	            	joinphoneField.setText(" 핸드폰번호");
					
	            	joinpasswordField.setText(" 비밀번호 (6자리)");
	            	joinpasswordField.setEchoChar((char) 0);
					
	            	joinconfirmPasswordField.setText(" 비밀번호 (6자리)");
	            	joinconfirmPasswordField.setEchoChar((char) 0);
	            	
	            	
	            	LoginFrame.card.show(getParent(), "userInfoCheck");  
	            	
	            	
	            	
	            }
			}  
		});
        
        // 패널 설정
        setBounds(0,0,990,760);
    	setOpaque(false);
        setLayout(null);
    } 
}