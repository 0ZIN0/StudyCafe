package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class LoginMainPanel extends JPanel{
	
	CardLayout card = new CardLayout();

	public LoginMainPanel() {
		
		/* Top 좌석, 스터디룸, 사물함 잔여 좌석 라벨*/
		JLabel seat = new JLabel();
		seat.setBounds(158,229,130,56);
		seat.setText("0 / 32");
		seat.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 46));
		seat.setForeground(Color.WHITE);
		
		JLabel studyRoom = new JLabel();
		studyRoom.setBounds(450,229,130,56);
		studyRoom.setText("0 / 2");
		studyRoom.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 46));
		studyRoom.setForeground(Color.WHITE);
		
		JLabel locker = new JLabel();
		locker.setBounds(720,229,130,56);
		locker.setText("0 / 20");
		locker.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 46));
		locker.setForeground(Color.WHITE);
		
		/*
		  Bottom 회원가입 / 로그인 버튼
		 */
		
		ImageIcon memberBtnImg = new ImageIcon("ui/main_membership_Btn.png");
		ImageIcon loginBtnImg = new ImageIcon("ui/main_Login_Btn.png");
		
		JButton memberShipBtn = new JButton();
		memberShipBtn.setIcon(memberBtnImg);
		memberShipBtn.setBounds(80,600,400,148);
		memberShipBtn.setBackground(new Color(0, 0, 0, 0));
		memberShipBtn.setBorderPainted(false);
		memberShipBtn.setContentAreaFilled(false);
		
		JButton loginBtn = new JButton();
		loginBtn.setIcon(loginBtnImg);
		loginBtn.setBounds(510,600,400,148);
		loginBtn.setBackground(new Color(0,0,0,0));
		loginBtn.setBorderPainted(false);
		loginBtn.setContentAreaFilled(false);
		
		BackgroundPanel inFramebg = new BackgroundPanel(new ImageIcon("ui/background/Main_Default_Ui_Frame.png"));
		inFramebg.setLocation(135,230);
		inFramebg.setBackground(new Color(0,0,0,0));
		
		// Bottom Button
		inFramebg.add(memberShipBtn);
		inFramebg.add(loginBtn);
		
		// Top Label 
		inFramebg.add(seat);
		inFramebg.add(studyRoom);
		inFramebg.add(locker);
		
		BackgroundPanel bg = new BackgroundPanel(new ImageIcon("ui/background/background.png"));
		inFramebg.setLayout(null);
		
		bg.add(inFramebg);
		bg.setLocation(0, 0);
		bg.setLayout(null);
		bg.setBackground(new Color(0,0,0,0));
		
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		add(bg);
	}
 }

