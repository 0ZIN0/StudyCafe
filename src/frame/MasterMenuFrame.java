package frame;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.BackgroundPanel;
import panel.MasterMenuPanel;
import panel.MasterUsersearch;
import panel.Master_LockerKickPanel;
import panel.Master_SeatKickPanel;
import panel.Master_StudyRoomKickPanel;
import panel.Master_kickPanel;
import panel.Master_salesPanel;
import panel.NumberKeypad;

public class MasterMenuFrame extends JFrame{
	
	
	CardLayout card = new CardLayout();
	JPanel cardPanel = new JPanel();
	
	MasterMenuPanel masterMenuPanel = new MasterMenuPanel(card);
	MasterUsersearch masterUsersearch = new MasterUsersearch();
	Master_kickPanel kickPanel = new Master_kickPanel();
	Master_salesPanel salesPanel = new Master_salesPanel();
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/master/masterMenu/Select_Seat_Main_Background.jpg"));
	JButton exitBtn = new JButton();
	JButton backBtn = new JButton(new ImageIcon("ui/master/masterMenu/Back.png"));
	JButton logoutBtn = new JButton(new ImageIcon("ui/master/masterMenu/Logout.png"));
	
	NumberKeypad numpad = new NumberKeypad();
		
	public MasterMenuFrame() {
		
		
		background.setLayout(null);
		add(background);
		background.add(backBtn);
		background.add(logoutBtn);
		
		
		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(110,240,1700,760);
		
		cardPanel.add(masterMenuPanel,"menu");
		cardPanel.add(masterUsersearch,"Usersearch");
		cardPanel.add(kickPanel, "kick");
		cardPanel.add(salesPanel, "sales");
		
		backBtn.setBounds(113,113,112,40);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		
		
		logoutBtn.setBounds(1690,113,112,40);
		logoutBtn.setBorderPainted(false);
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setFocusPainted(false);
		
		
		// 백버튼 이벤트
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(cardPanel, "menu");
				
				// KICK
				Master_SeatKickPanel.table.clearSelection();
				Master_StudyRoomKickPanel.table.clearSelection();
				Master_LockerKickPanel.table.clearSelection();
				Master_kickPanel.seatBtn.doClick();
				
				// USERSEARCH
				MasterUsersearch.table.clearSelection();
			}
		});
		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 로그아웃버튼 이벤트
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame();
			}
		});
		
		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}



