package panel;

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

public class LoginMainPanel extends JFrame{
	
	MemberJoin memberjoin = new MemberJoin();
	
	CardLayout card = new CardLayout();
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	JButton exitBtn = new JButton();
	NumberKeypad numpad= new NumberKeypad();
	LoginPanel loginPanel = new LoginPanel(card, this);
	
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel(memberjoin,card);
	UserInfoCheckPanel userInfoCheckPanel = new UserInfoCheckPanel(memberjoin, card);
	
	JPanel cardPanel = new JPanel();
	
	public LoginMainPanel( ) {
		
		setLayout(null);
		background.setLayout(null);
		add(background);
		
		background.add(exitBtn);
		
		exitBtn.setBounds(1700,80,100,100);
	
		
		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(130,260,1650,760);
		
		cardPanel.add(loginPanel,"login");
		cardPanel.add(memberJoinPanel,"memberjoin");
		
		cardPanel.add(userInfoCheckPanel, "userInfoCheck");
		
		
		setBounds(0,0,1920,1080);
		
		
		
		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new LoginMainPanel();
	}
}



