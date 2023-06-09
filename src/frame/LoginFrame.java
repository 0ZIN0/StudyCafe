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
	
	//MasterLoginFrame masterFrame;
	
	MemberJoin memberjoin = new MemberJoin();
	
	
	public static CardLayout card = new CardLayout();
	
	
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	JButton exitBtn = new JButton();
	NumberKeypad numpad= new NumberKeypad();
	JPanel cardPanel = new JPanel();
	
	
	//관리자 버튼
	public static JButton masterBtn = new JButton(new ImageIcon("ui/main/Master_Icon.png"));
	
	
	LoginPanel loginpanel = new LoginPanel(this);
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel(memberjoin);
	UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(memberjoin);

	// 쓰레드 클래스
	static TimeRun timeRun = new TimeRun(MainFrame.timeLabel);
	static UpdateInfo updateInfo = new UpdateInfo();
	
	
		
	public LoginFrame() {
		
		background.setLayout(null);
		add(background);
		
		background.add(masterBtn);
		masterBtn.setBounds(1811,978,60,48);
		masterBtn.setOpaque(false);
		masterBtn.setBorderPainted(false);
		//masterBtn.setFocusPainted(true);
		masterBtn.setContentAreaFilled(false);
		

		
		
		// 마스터버튼 이벤트
		masterBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MasterLoginFrame();
				dispose();
			}
		});
		

		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(130,260,1650,760);

		cardPanel.add(loginpanel,"login");
		cardPanel.add(memberJoinPanel,"memberjoin");
		cardPanel.add(userInfoCheckPanel, "userInfoCheck");

		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ((Throwable) e).printStackTrace();
        }
		
		Thread time = new Thread(timeRun);
		Thread update = new Thread(updateInfo);
		new LoginFrame();
		update.start();
		time.start();
	}
}



