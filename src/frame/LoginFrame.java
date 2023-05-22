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

public class LoginFrame extends JFrame{
	
	CardLayout card = new CardLayout();
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	
	JButton exitBtn = new JButton();
	
	NumberKeypad numpad= new NumberKeypad();
	LoginPanel loginPanel = new LoginPanel(card, this);
	MemberJoin memberjoin = new MemberJoin();
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel(memberjoin,card);
	UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
	
	JPanel subPanel = new JPanel();
	
	public LoginFrame() {
		
		subPanel.setOpaque(true);
		subPanel.setBounds(100,200,1700,800);
		
		subPanel.add(loginPanel, "login");
		subPanel.add(memberJoinPanel, "memberjoin");
		subPanel.add(userInfoCheckPanel, "userInfoCheck");
		
		subPanel.setLayout(card);
		background.add(subPanel);
		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		exitBtn.setBounds(1700,80,100,100);
		background.add(exitBtn);
		add(background);
		background.setOpaque(false);

		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
}



