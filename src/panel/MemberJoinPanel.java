package panel;
import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

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
    static String phonnumRegular = "^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})";
    
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
    	setBounds(0,0,990,760);
    	setOpaque(false);

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
        		numpad.setMax(10);
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
				
			}
		});
        
        // 비밀번호확인 포커스 이벤트
        confirmPasswordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		numpad.setTextField(confirmPasswordField);
        		numpad.setMax(6);
        		char[] confirmpassword = confirmPasswordField.getPassword();
    	        String confirmPasswordString = new String(confirmpassword);
    	        confirmPasswordField.setText("");
    	        confirmPasswordField.setEchoChar('●');  
        	}
        	@Override
			public void focusGained(FocusEvent e) {
        		confirmPasswordField.setText("");
				
			}
        	
		});
        
        add(phoneField);
        add(passwordField);
        add(confirmPasswordField);
        add(submitButton);
        add(beforeButton);
        
        beforeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "login");
			}
		});
        
        submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phone = phoneField.getText();
	            String password = new String(passwordField.getPassword());
	            String confirmPassword = new String(confirmPasswordField.getPassword());
	            
	            memberjoin.setPhone(phone);
	            memberjoin.setPassword(password);
	            System.out.println(memberjoin.getPhone());
	            
	            if(Pattern.matches(phonnumRegular, phone)) {
	                System.out.println("올바른 휴대전화 형식입니다. ");
	            } else {            
	            	new setPopup("올바른 휴대전화번호 양식이 아닙니다.","",1000,450).setVisible(true);
	                return;
	            }
	            
	            if(password.length() == 6) {
	            	System.out.println("비밀번호 6자리 확인.");
	            } else {
	            	new setPopup("비밀번호 6자리를 입력해주세요").setVisible(true);
	            	return;
				}
	            
	            if(password.equals(confirmPassword)) {
	            	System.out.println("비밀번호 일치 확인.");
	            } else {
	            	new setPopup("비밀번호 불일치").setVisible(true);
	            	return;
				}
	            
	            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
	            		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM member where phone_number = ?")) {
	                   	
	                   	stmt.setString(1, phone);
	                   	ResultSet rs = stmt.executeQuery();
	                   	if (rs.next()) {
	                	   new setPopup("이미 저장된 번호입니다.").setVisible(true);
	                       return;
	                   }
	            } catch (SQLException e1) {
	               e1.printStackTrace();
	            }

	            card.show(getParent(), "userInfoCheck");      
			}  
		});
  
        setLayout(null);
    } 
}