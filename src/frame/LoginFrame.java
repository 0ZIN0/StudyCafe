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
import panel.MemberJoinPanel;
import panel.NumberKeypad;
import panel.UserInfoCheckPanel;
import thread.TimeRun;
import thread.UpdateInfo;

public class LoginFrame extends JFrame{
	
	
	MemberJoin memberjoin = new MemberJoin();
	
	CardLayout card = new CardLayout();
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	JButton exitBtn = new JButton();
	NumberKeypad numpad= new NumberKeypad();
	LoginPanel loginpanel = new LoginPanel(card, this);
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel(memberjoin,card);
	UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
	
	//관리자 버튼
	JButton masterBtn = new JButton(new ImageIcon("ui/main/Master_Icon.png"));
	
	
	
	
	JPanel cardPanel = new JPanel();
	// 쓰레드 클래스
	static TimeRun timeRun = new TimeRun(MainFrame.timeLabel);
	static UpdateInfo updateInfo = new UpdateInfo();
	
	
		
	public LoginFrame() {
		
		background.setLayout(null);
		add(background);
		
		background.add(masterBtn);
		masterBtn.setBounds(1811,978,60,48);
		masterBtn.setBackground(new Color(73,67,68));
		masterBtn.setBorderPainted(false);

		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(130,260,1650,760);

		cardPanel.add(loginpanel,"login");
		cardPanel.add(memberJoinPanel,"memberjoin");
		cardPanel.add(userInfoCheckPanel, "userInfoCheck");

		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.setBounds(1700,80,100,100);
		background.add(exitBtn);

		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Thread time = new Thread(timeRun);
		Thread update = new Thread(updateInfo);
		new LoginFrame();
		update.start();
		time.start();
	}
}



