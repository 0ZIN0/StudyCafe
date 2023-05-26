package frame;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import dto.MemberJoin;
import panel.BackgroundPanel;
import panel.LoginPanel;
import panel.MasterLoginPanel;
import panel.MasterMenuPanel;
import panel.MasterUsersearch;
import panel.MemberJoinPanel;
import panel.NumberKeypad;
import panel.TestPanel;
import panel.UserInfoCheckPanel;
import thread.TimeRun;
import thread.UpdateInfo;

public class MasterMenuFrame extends JFrame{
	
	
	//MemberJoin memberjoin = new MemberJoin();
	
	CardLayout card = new CardLayout();
	JPanel cardPanel = new JPanel();
	
	
	
	MasterMenuPanel masterMenuPanel = new MasterMenuPanel(card);
//	TestPanel TestPanel = new TestPanel(); 
	
	MasterUsersearch masterUsersearch = new MasterUsersearch();
	
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/master/masterMenu/Select_Seat_Main_Background.jpg"));
	JButton exitBtn = new JButton();
	JButton backBtn = new JButton(new ImageIcon("ui/master/masterMenu/Back.png"));
	JButton logoutBtn = new JButton(new ImageIcon("ui/master/masterMenu/Logout.png"));
	
	NumberKeypad numpad= new NumberKeypad();
	//JPanel MasterLoginpanel = new JPanel();
	//MasterLoginPanel masterloginpanel = new MasterLoginPanel();
	
	//MasterLoginPanel masterLoginPanel = new MasterLoginPanel();
	
	//LoginPanel loginpanel = new LoginPanel(card, this);
	//MemberJoinPanel memberJoinPanel = new MemberJoinPanel(memberjoin,card);
	//UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
	
	//관리자 버튼
	//JButton masterBtn = new JButton(new ImageIcon("ui/main/Master_Icon.png"));
	
	
	//JPanel cardPanel = new JPanel();
	// 쓰레드 클래스
//	static TimeRun timeRun = new TimeRun(MainFrame.timeLabel);
//	static UpdateInfo updateInfo = new UpdateInfo();
	
	
		
	public MasterMenuFrame() {
		
		
		background.setLayout(null);
		add(background);
		background.add(backBtn);
		background.add(logoutBtn);
		
		
		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(110,240,1700,760);
		cardPanel.setBorder(new LineBorder(Color.red,1));
		
		
		cardPanel.add(masterUsersearch,"Usersearch");
		cardPanel.add(masterMenuPanel,"menu");
		
		
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
			}
		});
		
		
		
		
		

		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
//		exitBtn.setBounds(1700,80,100,100);
//		background.add(exitBtn);
		
		// 로그아웃버튼 이벤트
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame();
				dispose();
				
			}
		});
		
		
		
		


		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}



