package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import dao.MemberDAO;
import dto.Member;
//import oracle.sql.DATE;

public class MyPagePanel extends JPanel {
	
	JButton logoutBtn = new JButton("로그아웃");
	JButton mainBtn = new JButton("좌석보기");
	
	
	public MyPagePanel() {
		
		BackgroundPanel bg = new BackgroundPanel(new ImageIcon("ui/background/MyPage_BG.jpg"));
		setLayout(null);
		add(bg);
		
		BackgroundPanel mpMainCont = new BackgroundPanel(new ImageIcon("ui/MyPage/MyPage_Contents.jpg"));
		bg.add(mpMainCont);
		mpMainCont.setLocation(110, 230);
		mpMainCont.setBounds(110, 230, 1700, 760);
		
		
		
		
	} // end of constructor
	

} // end of class
