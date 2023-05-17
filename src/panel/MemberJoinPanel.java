package panel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;

public class MemberJoinPanel extends JPanel implements ActionListener {

    public JLabel phoneLabel, passwordLabel, confirmPasswordLabel, birthdayLabel;
    public JTextField phoneField, birthdayField;
    public JPasswordField passwordField, confirmPasswordField;
    public JButton submitButton;
    
    
    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    //핸드폰 정규표현식
    static String phonnumRegular = "^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})";
    
    // 생년월일 정규표현식
    static String dayRegular = "(19|20)\\d{2}\\-((11|12)|(0?(\\d)))\\-(30|31|((0|1|2)?\\d))";
   
    

    public MemberJoinPanel() {

        phoneLabel = new JLabel("핸드폰번호:");
        passwordLabel = new JLabel("비밀번호:");
        confirmPasswordLabel = new JLabel("비밀번호 확인:");
        birthdayLabel = new JLabel("생일:");

        phoneField = new JFormattedTextField(createFormatter("###-####-####"));
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        birthdayField = new JFormattedTextField(createFormatter("####-##-##"));

        submitButton = new JButton("회원가입");
        submitButton.addActionListener(this);

        GridLayout grid = new GridLayout(2,10);
        setLayout(grid);
        
        LoginMainPanel a = new LoginMainPanel();
        
//        passwordField.addFocusListener(new FocusAdapter() {
//        	@Override
//        	public void focusLost(FocusEvent e) {
//        		//a.numpad.setTextField(passwordField);
//        	}
//		});
        
        
        //JPanel panel = new JPanel();
        //panel.setBorder(new TitledBorder(new LineBorder(Color.red,1)));
        //panel.setLayout(grid);
        //panel.setBounds(0,0,600,600);
        //add(panel);
        add(phoneLabel);
//        add(phoneField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(birthdayLabel);
//        add(birthdayField);
        add(submitButton);
        
        setBackground(new Color(73,67,68));
        
        //setBorder(new TitledBorder(new LineBorder(Color.green,1)));

        //setBounds(0,0,1920,880);
    }
    

	public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submitButton) {
            String phone = phoneField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String birthday = birthdayField.getText();
            
            if(Pattern.matches(phonnumRegular, phone)) {
                System.out.println("올바른 휴대전화 형식입니다. ");
            } else {            
            	JOptionPane.showMessageDialog(MemberJoinPanel.this, "올바른 휴대전화번호 형식이 아닙니다.");
                return;
            }
            
            if(password.equals(confirmPassword)) {
            	System.out.println("비밀번호 일치 확인.");
            } else {
            	JOptionPane.showMessageDialog(MemberJoinPanel.this, "비밀번호 불일치");
            	return;
			}
            
            if(password.length() == 6) {
            	System.out.println("비밀번호 6자리 확인.");
            } else {
            	JOptionPane.showMessageDialog(MemberJoinPanel.this, "비밀번호 6자리를 입력하시오");
            	return;
			}
            
            if(Pattern.matches(dayRegular, birthday)) {
        	   System.out.println("날짜 정상 입력");
            } else {
        	   JOptionPane.showMessageDialog(MemberJoinPanel.this, "양식에 맞는 날짜를 입력하시오");
        	   return;
            }
            
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
            		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM member where phone_number = ?")) {
                   	//String searchValue = "search_value";
                   	stmt.setString(1, phone);
                   	ResultSet rs = stmt.executeQuery();
                   	if (rs.next()) {
                	   JOptionPane.showMessageDialog(MemberJoinPanel.this, "이미 저장된 번호입니다");
                       return;
                   }
            } catch (SQLException e) {
               e.printStackTrace();
            }
            
            
            try (
            		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
                    Statement stmt = conn.createStatement();
            		
            ){
                String query = "INSERT INTO member (phone_number, member_password, date_of_birth) VALUES ('" + phone + "', '" + password + "', '" + birthday + "')";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(MemberJoinPanel.this, "회원가입이 완료되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(MemberJoinPanel.this, "오류");
            }
           
          
//            if (password.equals(confirmPassword)) {
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
//            }
        }
    }

  
}