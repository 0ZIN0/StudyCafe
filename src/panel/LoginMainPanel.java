package panel;

import java.awt.CardLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import dto.MemberJoin;

public class LoginMainPanel extends JPanel{
	
	MemberJoin memberjoin = new MemberJoin();
	
	CardLayout card = new CardLayout();
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	JButton exitBtn = new JButton("종료");
	NumberKeypad numpad= new NumberKeypad();
	LoginPanel loginpanel = new LoginPanel();
	//TermsofUsePanel termsofUsePanel = new TermsofUsePanel();
	
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel(memberjoin,card);
	UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
	
	JPanel cardPanel = new JPanel();
	
	
	
	public LoginMainPanel( ) {
		
		setLayout(null);
		
		background.setLayout(null);
		add(background);
		
		
		background.add(exitBtn);
		
		exitBtn.setBounds(1700,80,100,100);
	
		
		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(130,260,1650,760);
		//cardPanel.setBorder(new TitledBorder(new LineBorder(Color.red,1)));
		
		cardPanel.add(loginpanel,"login");
		cardPanel.add(memberJoinPanel,"memberjoin");
		//cardPanel.add(termsofUsePanel,"termsofUse");
		
		cardPanel.add(userInfoCheckPanel, "userInfoCheck");
		
		
		setBounds(0,0,1920,1080);
		
		// loginpanel의 회원가입버튼 이벤트
		loginpanel.memberJoinBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        card.show(cardPanel, "memberjoin");
		    }
		});
		
		
//		// userInfoCheckPanel의 약관동의 이전버튼 이벤트
//		userInfoCheckPanel.beforeBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				card.show(cardPanel, "memberjoin");
//			}
//		});
		
		
		
//		userInfoCheckPanel.nextBtn.addActionListener(new ActionListener() {
//			String phone = memberJoinPanel.phoneField.getText();
//            String password = new String(memberJoinPanel.passwordField.getPassword());
//            String confirmPassword = new String(memberJoinPanel.confirmPasswordField.getPassword());
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(userInfoCheckPanel.infoChkBox1.isSelected() && userInfoCheckPanel.infoChkBox2.isSelected() && userInfoCheckPanel.infoChkBox3.isSelected()) {
//					 try (
//			            		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teamproject", "1234");
//			            ){
//			            	   String query = "INSERT INTO member (phone_number, member_password) VALUES (?, ?)";
//			            	   PreparedStatement stmt = conn.prepareStatement(query);
//			            	   stmt.setString(1, phone);
//			            	   stmt.setString(2, password);
//			            	   stmt.executeUpdate();
//			                
//			                JOptionPane.showMessageDialog(userInfoCheckPanel, "회원가입이 완료되었습니다.");
//			            } catch (SQLException e2) {
//			                e2.printStackTrace();
//			                JOptionPane.showMessageDialog(userInfoCheckPanel, "오류");
//			            }
//				}
//				
//				
//				
//				
//			}
//		});
		
		
		
		
		
		
		
		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		

	}
}



