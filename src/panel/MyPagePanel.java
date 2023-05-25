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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import dao.MemberDAO;
import dao.SeatDAO;
import dto.Member;
import frame.LoginFrame;
import frame.MainFrame;

public class MyPagePanel extends JPanel {
	
	BackgroundPanel bg = new BackgroundPanel(new ImageIcon("ui/background/MyPage_BG.jpg"));

	JButton logoutBtn = new JButton("로그아웃");
	JButton mainBtn = new JButton("좌석보기");
	
	Member member;
	
	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	List<JLabel> labels = new ArrayList<>();
	
	String[] labelText = new String[] {
			"전화번호 : ",
			"잔여 시간 : ",
			"잔여 기간 : ",
			"사용중인 좌석 : ",
			"사용중인 사물함 : "
	};
	public static JLabel phoneNum;
	public static JLabel time;
	public static JLabel period;
	public static JLabel seat;
	public static JLabel locker;
	
	public MyPagePanel(CardLayout card, Member member, JFrame parent) {
		this.member = member;
		
		for(int i = 0; i < labelText.length; i++) {
			JLabel label = new JLabel();
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
			label.setText(labelText[i]);
			label.setBounds(570, 320 + 120 * i, 500, 100);
			label.setForeground(new Color(0xD9D9D9));
			add(label);
		}
		
		phoneNum = new JLabel(member.getPhone_number());
		phoneNum.setBounds(1010, 320, 500, 100);
		phoneNum.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		phoneNum.setForeground(Color.WHITE);
		
		time = new JLabel();
		Integer remain_time = member.getRemain_time();
		if(remain_time == null) {
			time.setText("없음");
		} else {
			if(remain_time >= 60) {
				int hour = remain_time / 60;
				int minute = remain_time % 60;
				time.setText(hour + "시간 " + minute + "분");
			} else {
				time.setText(remain_time + "분");				
			}
		}
		time.setBounds(1010, 440, 500, 100);
		time.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		time.setForeground(Color.WHITE);
		
		period = new JLabel();
		if(member.getRemain_date() == null) {
			period.setText("");
		} else {
			period.setText(member.getRemain_date() + "까지");
		}
		period.setBounds(1010, 560, 500, 100);
		period.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		period.setForeground(Color.WHITE);
		
		seat = new JLabel(SeatDAO.isUsingMySeat(MainFrame.member.getMember_id()) + "번");
		seat.setBounds(1010, 680, 500, 100);
		seat.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		seat.setForeground(Color.WHITE);
		
		locker = new JLabel(member.getLocker_number() + "번");
		if(member.getLocker_number() == null) {
			locker.setText("사용중인 사물함이 없습니다");
		} else {
			locker.setText(MainFrame.member.getLocker_number() + "번");
		}
		locker.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		locker.setBounds(1010, 800, 500, 100);
		locker.setForeground(Color.WHITE);
		
		logoutBtn.setBounds(62, 114, 200, 40);
		logoutBtn.setForeground(new Color(0xFF5C00));
		logoutBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);
		
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				new LoginFrame();
			}
		});
		
		mainBtn.setBounds(1592, 114, 300, 40);
		mainBtn.setForeground(new Color(0xFF5C00));
		mainBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		mainBtn.setContentAreaFilled(false);
		mainBtn.setBorderPainted(false);
		mainBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getParent(), "main");
			}
		});
		
		add(phoneNum);
		add(time);
		add(period);
		add(seat);
		add(locker);
		add(logoutBtn);
		add(mainBtn);
		add(bg);
		setOpaque(false);
		setLayout(null);
		setVisible(true);
	 }
}
