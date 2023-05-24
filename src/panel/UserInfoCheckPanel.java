package panel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import dao.LoginDAO;
import dialog.setPopup;
import dto.MemberJoin;

public class UserInfoCheckPanel extends JPanel {
	
	JButton beforeBtn = new JButton(new ImageIcon("ui/UserAgree/Before_Button.png"));
	JButton nextBtn = new JButton(new ImageIcon("ui/UserAgree/Next_Button.png"));
	JCheckBox infoChkBox1 = new JCheckBox();
	JCheckBox infoChkBox2 = new JCheckBox();
	JCheckBox infoChkBox3 = new JCheckBox();
	
	public UserInfoCheckPanel(MemberJoin memberjoin, CardLayout card){
	
		setLayout(null);
//		안쪽 프레임
		BackgroundPanel agreeChkFrame = new BackgroundPanel(new ImageIcon("ui/UserAgree/Main_UserInfoCheck_Frame.jpg"));
		add(agreeChkFrame);
		agreeChkFrame.setLocation(0, 0);
		
//		메인화면으로 이동 버튼
		JButton moveToMainBtn = new JButton(new ImageIcon("ui/UserAgree/MovetoMain_Button.png"));
		agreeChkFrame.add(moveToMainBtn);
		moveToMainBtn.setBounds(1672, 114, 120, 44);
		moveToMainBtn.setOpaque(false);
		moveToMainBtn.setContentAreaFilled(false);
		moveToMainBtn.setFocusPainted(false);
		moveToMainBtn.setBorderPainted(false);
		
//      체크박스의 이미지 아이콘 설정
		ImageIcon uncheckedIcon = new ImageIcon("ui/UserAgree/checkBox_off.png");
		ImageIcon checkedIcon = new ImageIcon("ui/UserAgree/checkBox_on.png");

//		체크박스 설정
        agreeChkFrame.add(infoChkBox1);
        infoChkBox1.setBounds(410, 138, 50, 50); // 위치 설정
        infoChkBox1.setIcon(uncheckedIcon); // 체크박스 선택 안됬을때(Default Image)
        infoChkBox1.setSelectedIcon(checkedIcon);// 체크박스 선택 됐을때
        infoChkBox1.setOpaque(false); // 체크박스 투명하게
          
        agreeChkFrame.add(infoChkBox2);
        infoChkBox2.setBounds(410, 222, 50, 50);
        infoChkBox2.setIcon(uncheckedIcon);
        infoChkBox2.setSelectedIcon(checkedIcon);	
        infoChkBox2.setOpaque(false);
        
        agreeChkFrame.add(infoChkBox3);
        infoChkBox3.setBounds(410, 306, 50, 50);
        infoChkBox3.setIcon(uncheckedIcon);
        infoChkBox3.setSelectedIcon(checkedIcon);
        infoChkBox3.setOpaque(false);
        
//      약관 내용 보는 버튼 설정 (클릭 기능만 있고 내용은 없는 버튼임)
        JButton viewCont1 = new JButton(new ImageIcon("ui/UserAgree/ViewContents_Button.png")); 
        agreeChkFrame.add(viewCont1);
        viewCont1.setBounds(1150, 232, 100, 38); // 내용보기 버튼 위치 설정
        viewCont1.setContentAreaFilled(false); // 내용보기 버튼 기본 배경 삭제
        viewCont1.setOpaque(false); // 내용보기 버튼 이미지 투명
        viewCont1.setBorderPainted(false); // 버튼 클릭시 테두리 안나오게 
        viewCont1.setFocusPainted(false);
        
        JButton viewCont2 = new JButton(new ImageIcon("ui/UserAgree/ViewContents_Button.png"));
        agreeChkFrame.add(viewCont2);
        viewCont2.setBounds(1150, 318, 100, 38);
        viewCont2.setContentAreaFilled(false);
        viewCont2.setOpaque(false);
        viewCont2.setBorderPainted(false);
        viewCont2.setFocusPainted(false);
        
//		Before 버튼
		agreeChkFrame.add(beforeBtn);
		beforeBtn.setBounds(410, 590, 400, 150);
		beforeBtn.setOpaque(false);
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.setFocusPainted(false);
		beforeBtn.setBorderPainted(false);
		
//		Next 버튼
		agreeChkFrame.add(nextBtn);
		nextBtn.setBounds(840, 590, 400, 150);
		nextBtn.setOpaque(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);
		nextBtn.setBorderPainted(false);
		
		
		// userInfoCheckPanel의 약관동의 이전버튼 이벤트
		beforeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "memberjoin");
			}
		});
	
		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String phoneNum = memberjoin.getPhone();
				String password = memberjoin.getPassword();
				
				if(infoChkBox1.isSelected() && infoChkBox2.isSelected() && infoChkBox3.isSelected()) {
					if(LoginDAO.register(phoneNum, password) > 0) {
						new setPopup(new ImageIcon("ui/UserAgree/useragrrPopup/sucessMemberjoin.png")).setVisible(true);
					}
					card.show(getParent(), "login");
				} else {
					new setPopup(new ImageIcon("ui/UserAgree/useragrrPopup/notAgree.png")).setVisible(true);
					return;
				} 
	
			}
		});
	}
} 