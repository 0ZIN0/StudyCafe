package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import dialog.ProgramOffDialog;
import frame.MasterMenuFrame;

public class MasterMenuPanel extends JPanel{
	
	
	MasterMenuFrame masterMenuFrame;
	
	
	JButton userDischargeBtn = new JButton(new ImageIcon("ui/master/masterMenu/UserDischarge_Button.png"));
	JButton userOutBtn= new JButton(new ImageIcon("ui/master/masterMenu/UserOut_Button.png"));
	JButton userSearchBtn= new JButton(new ImageIcon("ui/master/masterMenu/UserSearch_Button.png"));
	JButton exitBtn = new JButton(new ImageIcon("ui/master/KioskProgram_off_Button.png"));
	
	public MasterMenuPanel(CardLayout card) {
		
		setLayout(null);
		setBackground(new Color(73,67,69));
		
		add(userDischargeBtn);
		add(userOutBtn);
		add(userSearchBtn);
		add(exitBtn);
		
		// 매출버튼
		userDischargeBtn.setBounds(415,45,480,380);
		userDischargeBtn.setBorderPainted(false);
		userDischargeBtn.setContentAreaFilled(false);
		
		// 퇴실버튼
		userOutBtn.setBounds(415,395,480,380);
		userOutBtn.setBorderPainted(false);
		userOutBtn.setContentAreaFilled(false);
		
		// 회원조회버튼
		userSearchBtn.setBounds(865,45,480,380);
		userSearchBtn.setBorderPainted(false);
		userSearchBtn.setContentAreaFilled(false);
		
		//회원조회버튼 이벤트
		userSearchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(),"Usersearch");
				
			}
		});
		
		userOutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "kick");
			}
		});

		userDischargeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "sales");
			}
		});
		
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog programOff = new ProgramOffDialog();
			}
		});
		
		// 회원조회버튼
		exitBtn.setBounds(865,395,480,380);
		exitBtn.setBorderPainted(false);
		exitBtn.setContentAreaFilled(false);
		
	}

}
