package panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class UserInfoCheckPanel extends JPanel {

	public UserInfoCheckPanel() {
	
//		배경
		BackgroundPanel agreeChkBg = new BackgroundPanel(new ImageIcon("ui/background/Main_Default_BG.jpg"));
		add(agreeChkBg);
		agreeChkBg.setLocation(0, 0);
		setLayout(null);
		
//		메인화면으로 이동 버튼
		JButton moveToMainBtn = new JButton(new ImageIcon("ui/UserAgree/MovetoMain_Button.png"));
		agreeChkBg.add(moveToMainBtn);
		moveToMainBtn.setBounds(1672, 114, 120, 44);
		moveToMainBtn.setOpaque(false);
		moveToMainBtn.setContentAreaFilled(false);
		moveToMainBtn.setFocusPainted(false);
		moveToMainBtn.setBorderPainted(false);
		
		
//		안쪽 프레임
		BackgroundPanel agreeChkFrame = new BackgroundPanel(new ImageIcon("ui/UserAgree/Main_UserAgree_Check_Frame.jpg"));
		agreeChkBg.add(agreeChkFrame);
		agreeChkFrame.setLocation(135, 230);
		
//      체크박스의 이미지 아이콘 설정
		ImageIcon uncheckedIcon = new ImageIcon("ui/UserAgree/checkBox_off.png");
		ImageIcon checkedIcon = new ImageIcon("ui/UserAgree/checkBox_on.png");

//		체크박스 설정
        JCheckBox infoChkBox1 = new JCheckBox();
        agreeChkFrame.add(infoChkBox1);
        infoChkBox1.setBounds(410, 138, 50, 50); // 위치 설정
        infoChkBox1.setIcon(uncheckedIcon); // 체크박스 선택 안됬을때(Default Image)
        infoChkBox1.setSelectedIcon(checkedIcon);// 체크박스 선택 됐을때
        infoChkBox1.setOpaque(false); // 체크박스 투명하게
        
        JCheckBox infoChkBox2 = new JCheckBox();
        agreeChkFrame.add(infoChkBox2);
        infoChkBox2.setBounds(410, 222, 50, 50);
        infoChkBox2.setIcon(uncheckedIcon);
        infoChkBox2.setSelectedIcon(checkedIcon);	
        infoChkBox2.setOpaque(false);
        
        JCheckBox infoChkBox3 = new JCheckBox();
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
		JButton beforeBtn = new JButton(new ImageIcon("ui/UserAgree/Before_Button.png"));
		agreeChkFrame.add(beforeBtn);
		beforeBtn.setBounds(410, 590, 400, 150);
		beforeBtn.setOpaque(false);
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.setFocusPainted(false);
		beforeBtn.setBorderPainted(false);
		
//		Next 버튼
		JButton nextBtn = new JButton(new ImageIcon("ui/UserAgree/Next_Button.png"));
		agreeChkFrame.add(nextBtn);
		nextBtn.setBounds(840, 590, 400, 150);
		nextBtn.setOpaque(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);
		nextBtn.setBorderPainted(false);
		
		
		
	} // end of constructor
	
	
} // end of class
