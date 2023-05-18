package panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class MembershipMainPanel extends JPanel {
	
	public MembershipMainPanel() {
	
//		배경
		BackgroundPanel msBg = new BackgroundPanel(new ImageIcon("ui/background/Main_Default_BG.jpg"));
		add(msBg);
		msBg.setLocation(0, 0);
		setLayout(null);
		
//		왼쪽 프레임
		BackgroundPanel leftFrame = new BackgroundPanel(new ImageIcon("ui/Membership_ui/Main_membership_Left_Frame.jpg"));
		msBg.add(leftFrame);
		leftFrame.setLocation(135, 230);

//		전화번호 중복 체크 버튼
		JButton dupliChkBtn = new JButton(new ImageIcon("ui/Membership_ui/DuplicateCheck_Button.png"));
		leftFrame.add(dupliChkBtn);
		dupliChkBtn.setContentAreaFilled(false);
		dupliChkBtn.setBounds(665, 114, 254, 112);
		dupliChkBtn.setOpaque(false);
		dupliChkBtn.setBorderPainted(false);
		dupliChkBtn.setFocusPainted(false);
		
//		전화번호 입력
		JTextField phoneNumTextbox = new JTextField() {
			@Override
			public void setBorder(Border border) {
			}
		};
		
		/*
		 * TextField 클릭 전 컬러 : new Color(219, 217, 218)
		 * TextField 텍스트 입력 시 컬러 : #FFFFFF
		 */
		leftFrame.add(phoneNumTextbox);
		phoneNumTextbox.setText("전화번호 입력하세요.");
		phoneNumTextbox.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 24)); // 폰트설정
		phoneNumTextbox.setForeground(new Color(219, 217, 218)); // 폰트 컬러 설정
		phoneNumTextbox.setBounds(96, 117, 800, 100); // 폰트 위치 설정
		phoneNumTextbox.setOpaque(false); // TextField 투명도 설정
		phoneNumTextbox.setSelectionColor(new Color(0, 0, 0, 0)); // TextField 선택시 테두리 투명 설정
		
//		비밀번호 입력
		JTextField passwordTextbox = new JTextField() {
			@Override
			public void setBorder(Border border) {
			}
		};
		
		/*
		 * TextField 클릭 전 컬러 : new Color(219, 217, 218)
		 * TextField 텍스트 입력 시 컬러 : #FFFFFF
		 */
		leftFrame.add(passwordTextbox);
		passwordTextbox.setText("숫자 6자리 입력하세요.");
		passwordTextbox.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 24));
		passwordTextbox.setForeground(new Color(219, 217, 218));
		passwordTextbox.setOpaque(false);
		passwordTextbox.setBounds(96, 286, 800, 100);
		passwordTextbox.setSelectionColor(new Color(0, 0, 0, 0));
		
		
//		비밀번호 확인 입력
		JTextField passwordChkTextbox = new JTextField() {
			@Override
			public void setBorder(Border border) {
			}
		};
		
		/*
		 * TextField 클릭 전 컬러 : new Color(219, 217, 218)
		 * TextField 텍스트 입력 시 컬러 : #FFFFFF
		 */
		leftFrame.add(passwordChkTextbox);
		passwordChkTextbox.setText("확인을 위해 위와 동일하게 입력하세요.");
		passwordChkTextbox.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 24));
		passwordChkTextbox.setForeground(new Color(219, 217, 218));
		passwordChkTextbox.setOpaque(false);
		passwordChkTextbox.setBounds(96, 455, 800, 100);
		passwordChkTextbox.setSelectionColor(new Color(0, 0, 0, 0));
		
//		Before 버튼
		JButton beforeBtn = new JButton(new ImageIcon("ui/Membership_ui/Before_Button.png"));
		leftFrame.add(beforeBtn);
		beforeBtn.setBounds(80, 590, 400, 150);
		beforeBtn.setOpaque(false);
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.setFocusPainted(false);
		beforeBtn.setBorderPainted(false);
		
//		Next 버튼
		JButton nextBtn = new JButton(new ImageIcon("ui/Membership_ui/Next_Button.png"));
		leftFrame.add(nextBtn);
		nextBtn.setBounds(510, 590, 400, 150);
		nextBtn.setOpaque(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);
		nextBtn.setBorderPainted(false);
		
		
	} // end of constructor
	
	
	

} // end of class
