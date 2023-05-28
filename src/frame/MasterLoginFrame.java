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
import panel.MemberJoinPanel;
import panel.NumberKeypad;
import panel.UserInfoCheckPanel;
import thread.TimeRun;
import thread.UpdateInfo;

public class MasterLoginFrame extends JFrame{
	
	
	MemberJoin memberjoin = new MemberJoin();
	
	CardLayout card = new CardLayout();
	
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	JButton exitBtn = new JButton(new ImageIcon("ui/master/masterLogin/MainPage_move_btn.png"));
	NumberKeypad numpad= new NumberKeypad();
	
	MasterLoginPanel masterLoginPanel = new MasterLoginPanel(this);
	
	
	
	//관리자 버튼
	static JButton masterBtn = new JButton(new ImageIcon("ui/main/Master_Icon.png"));
	
	
		
	public MasterLoginFrame() {
		
		background.setLayout(null);
		add(background);
		background.add(masterLoginPanel);
		masterLoginPanel.setBounds(110,240,1700,760);
		
		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame();
			}
		});
		exitBtn.setBounds(1690,113,112,35);
		exitBtn.setBorderPainted(false);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setFocusPainted(false);
		
		
		background.add(exitBtn);

		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}



