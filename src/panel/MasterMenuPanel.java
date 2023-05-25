package panel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MasterMenuPanel extends JPanel{
	
	JButton UserDischargeBtn = new JButton(new ImageIcon("ui/master/masterMenu/UserDischarge_Button.png"));
	JButton UserOutBtn= new JButton(new ImageIcon("ui/master/masterMenu/UserOut_Button.png"));
	JButton UserSearchBtn= new JButton(new ImageIcon("ui/master/masterMenu/UserSearch_Button.png"));
	JButton creditsBtn= new JButton(new ImageIcon("ui/master/masterMenu/credits_Button.png"));
	
	public MasterMenuPanel() {
		
		setLayout(null);
		setBackground(new Color(73,67,69));
		
		add(UserDischargeBtn);
		add(UserOutBtn);
		add(UserSearchBtn);
		add(creditsBtn);
		
		// 매출버튼
		UserDischargeBtn.setBounds(415,45,480,380);
		UserDischargeBtn.setBorderPainted(false);
		UserDischargeBtn.setContentAreaFilled(false);
		
		// 퇴실버튼
		UserOutBtn.setBounds(415,395,480,380);
		UserOutBtn.setBorderPainted(false);
		UserOutBtn.setContentAreaFilled(false);
		
		// 회원조회버튼
		UserSearchBtn.setBounds(865,45,480,380);
		UserSearchBtn.setBorderPainted(false);
		UserSearchBtn.setContentAreaFilled(false);
		
		// 회원조회버튼
		creditsBtn.setBounds(865,395,480,380);
		creditsBtn.setBorderPainted(false);
		creditsBtn.setContentAreaFilled(false);
		
	}

}
