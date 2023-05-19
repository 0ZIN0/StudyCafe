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

//implements ActionListener
public class MemberJoinPanel extends JPanel  {
	JLabel phoneLabel, passwordLabel, confirmPasswordLabel, birthdayLabel;
    JTextField phoneField;
    JPasswordField passwordField;
	JPasswordField confirmPasswordField;
    JButton submitButton;
    JButton phonduplicationBtn;
    
    GridLayout grid = new GridLayout(10,2);
    NumberKeypad numpad= new NumberKeypad();
    //UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(user);
    
    //UserInfoCheckPanel UserInfoCheckPanel = new UserInfoCheckPanel();
    
    
//    public String phone = phoneField.getText();
//    public String password = new String(passwordField.getPassword());
//    public String confirmPassword = new String(confirmPasswordField.getPassword());
    
    
    
	@Override
    public void setBorder(Border border) {
		
    }
    
    



//    private MaskFormatter createFormatter(String s) {
//    	
//        MaskFormatter formatter=null;
//		try {
//			
//			formatter = new MaskFormatter(s);
//		} catch (ParseException e) {
//			//formatter.setCommitsOnValidEdit(false);
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//		
//        
////        try {
////            formatter = new MaskFormatter(s);
////        } catch (java.text.ParseException exc) {
////            exc.printStackTrace();
////        }
//		
//        return formatter;
//    }
    
    

	//핸드폰 정규표현식
    static String phonnumRegular = "^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})";
    
    // 생년월일 정규표현식
    static String dayRegular = "(19|20)\\d{2}\\-((11|12)|(0?(\\d)))\\-(30|31|((0|1|2)?\\d))";
	
   
    
	ImageIcon im =new ImageIcon("ui/main/membeJoin/Main_membership_Left_Frame.jpg");
	Image image=im.getImage();
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	

    public MemberJoinPanel(MemberJoin memberjoin, CardLayout card) {
    	
    	UserInfoCheckPanel UserInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
    	
    	setLayout(null);
    	JPanel MemberJoinPanel = new JPanel();
    	
    	phoneField = new JTextField();
        
       	passwordField = new JPasswordField();
       	
       	confirmPasswordField = new JPasswordField();
       	
       	phoneField.setBorder(getBorder());
       	passwordField.setBorder(getBorder());
       	confirmPasswordField.setBorder(getBorder());
    	
    	submitButton = new JButton("회원가입");
    	phonduplicationBtn= new JButton("중복버튼");
    	
    	
    	add(MemberJoinPanel);
    	add(numpad);
    	
		numpad.setBounds(1080,50,550,690);
    	MemberJoinPanel.setBounds(0,0,990,760);
    	MemberJoinPanel.setOpaque(false);;
    	
    	
    	MemberJoinPanel.setLayout(null);
    	

		 
	    
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
	    
	    submitButton.setBounds(80, 650, 200, 50);
	    
	    
	    //submitButton.addActionListener(this);
	    
	    
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
        
        // 생년월일 포커스 이벤트
//        birthdayField.addFocusListener(new FocusAdapter() {
//        	@Override
//        	public void focusLost(FocusEvent e) {
//        		numpad.setTextField(birthdayField);
//        		numpad.setMax(8);
//        	}
//        	@Override
//			public void focusGained(FocusEvent e) {
//        		birthdayField.setText("");
//				
//			}
//		});
        
        
       
        MemberJoinPanel.add(phoneField);
        
        MemberJoinPanel.add(passwordField);
        
        MemberJoinPanel.add(confirmPasswordField);
        
        MemberJoinPanel.add(submitButton);
        
        MemberJoinPanel.add(phonduplicationBtn);
        
        //MemberJoinPanel.add(birthdayField);
        
        //setBackground(new Color(73,67,68));
        
        
        
        
        submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phone = phoneField.getText();
	            String password = new String(passwordField.getPassword());
	            String confirmPassword = new String(confirmPasswordField.getPassword());
	            
	            memberjoin.setPhone(phone);
	            memberjoin.setPassword(password);
	            System.out.println(memberjoin.getPhone());
	            
	            
	            
	            //String birthday = birthdayField.getText();
	            
	            
	            if(Pattern.matches(phonnumRegular, phone)) {
	                System.out.println("올바른 휴대전화 형식입니다. ");
	                
	            } else {            
	            	//JOptionPane.showMessageDialog(MemberJoinPanel.this, "올바른 휴대전화번호 형식이 아닙니다.");
	            	//phoneField.setForeground(Color.red);
	            	//phoneField.setText(" 올바른 휴대전화번호 양식이 아닙니다.");
	            	new setPopup("올바른 휴대전화번호 양식이 아닙니다.","",1000,450).setVisible(true);
	            	
	                return;
	            }
	            
	            if(password.length() == 6) {
	            	System.out.println("비밀번호 6자리 확인.");
	            } else {
	            	//JOptionPane.showMessageDialog(MemberJoinPanel.this, "비밀번호 6자리를 입력하시오");
	            	//passwordField.setForeground(Color.red);
	            	//passwordField.setText(" 비밀번호 6자리를 입력해주세요");
	            	new setPopup("비밀번호 6자리를 입력해주세요").setVisible(true);
	            	return;
				}
	            
	            if(password.equals(confirmPassword)) {
	            	System.out.println("비밀번호 일치 확인.");
	            } else {
	            	//JOptionPane.showMessageDialog(MemberJoinPanel.this, "비밀번호 불일치");
	            	//confirmPasswordField.setForeground(Color.red);
	            	//confirmPasswordField.setText(" 비밀번호 불일치");
	            	new setPopup("비밀번호 불일치").setVisible(true);
	            	return;
				}
	            
	            
	            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
	            		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM member where phone_number = ?")) {
	                   	
	                   	stmt.setString(1, phone);
	                   	ResultSet rs = stmt.executeQuery();
	                   	if (rs.next()) {
	                	   //JOptionPane.showMessageDialog(MemberJoinPanel.this, "이미 저장된 번호입니다");
	                	   new setPopup("이미 저장된 번호입니다.").setVisible(true);
	                       return;
	                   }
	            } catch (SQLException e1) {
	               e1.printStackTrace();
	            }
	            
	            
	            card.show(getParent(), "userInfoCheck");
	            
			}  
		});
        
        
        
//        userInfoCheck.UserInfoCheckPanel.nextBtn.addActionListener(new ActionListener() {
//        	String phone = phoneField.getText();
//        	String password = new String(passwordField.getPassword());
//        	String confirmPassword = new String(confirmPasswordField.getPassword());
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(infoChkBox1.isSelected() && infoChkBox2.isSelected() && infoChkBox3.isSelected()) {
//					 try (
//			            		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
//			            ){
//			            	   String query = "INSERT INTO member (phone_number, member_password) VALUES (?, ?)";
//			            	   PreparedStatement stmt = conn.prepareStatement(query);
//			            	   stmt.setString(1, phone);
//			            	   stmt.setString(2, password);
//			            	   stmt.executeUpdate();
//			                
//			                JOptionPane.showMessageDialog(UserInfoCheckPanel.this, "회원가입이 완료되었습니다.");
//			            } catch (SQLException e2) {
//			                e2.printStackTrace();
//			                JOptionPane.showMessageDialog(UserInfoCheckPanel.this, "오류");
//			            }
//				}
//				
//				
//				
//				
//			}
//		});
        
        
        
        
    }
    

//	public void actionPerformed(ActionEvent event) {
//        if (event.getSource() == submitButton) {
//            String phone = phoneField.getText();
//            String password = new String(passwordField.getPassword());
//            String confirmPassword = new String(confirmPasswordField.getPassword());
//            //String birthday = birthdayField.getText();
//            
//            
//            if(Pattern.matches(phonnumRegular, phone)) {
//                System.out.println("올바른 휴대전화 형식입니다. ");
//                
//            } else {            
//            	//JOptionPane.showMessageDialog(MemberJoinPanel.this, "올바른 휴대전화번호 형식이 아닙니다.");
//            	phoneField.setForeground(Color.red);
//            	phoneField.setText(" 올바른 휴대전화번호 양식이 아닙니다.");
//            	
//                return;
//            }
//            
//            if(password.length() == 6) {
//            	System.out.println("비밀번호 6자리 확인.");
//            } else {
//            	//JOptionPane.showMessageDialog(MemberJoinPanel.this, "비밀번호 6자리를 입력하시오");
//            	passwordField.setForeground(Color.red);
//            	passwordField.setText(" 비밀번호 6자리를 입력해주세요");
//            	return;
//			}
//            
//            if(password.equals(confirmPassword)) {
//            	System.out.println("비밀번호 일치 확인.");
//            } else {
//            	//JOptionPane.showMessageDialog(MemberJoinPanel.this, "비밀번호 불일치");
//            	confirmPasswordField.setForeground(Color.red);
//            	confirmPasswordField.setText(" 비밀번호 불일치");
//            	return;
//			}
//            
//            
//            card.show(getParent(), "userInfoCheck");
            
            
            
            
            
            
//            try (
//            		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
//            ){
//            	   String query = "INSERT INTO member (phone_number, member_password) VALUES (?, ?)";
//            	   PreparedStatement stmt = conn.prepareStatement(query);
//            	   stmt.setString(1, phone);
//            	   stmt.setString(2, password);
//            	   stmt.executeUpdate();
//                
//                JOptionPane.showMessageDialog(MemberJoinPanel.this, "회원가입이 완료되었습니다.");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(MemberJoinPanel.this, "오류");
//            }
           

//        }
//    }

  
}