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
import oracle.sql.DATE;

public class MyPagePanel extends JPanel {
	
	BackgroundPanel bg = new BackgroundPanel(new ImageIcon("ui/background/MyPage_BG.jpg"));

	JButton logoutBtn = new JButton("로그아웃");
	JButton mainBtn = new JButton("좌석보기");
	
	Member member = new Member();
	
	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	List<JLabel> labels = new ArrayList<>();
	
	String[] labelText = new String[] {
			"전화번호 : ",
			"잔여 시간 : ",
			"잔여 기간 : ",
			"사용중인 좌석 : ",
			"사용중인 사물함 : "
	};
	
	public MyPagePanel(CardLayout card, Member member) {
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
		
		JLabel phoneNum = new JLabel(member.getPhone_number());
		phoneNum.setBounds(1010, 320, 500, 100);
		phoneNum.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		phoneNum.setForeground(Color.WHITE);
		
		JLabel time = new JLabel(Integer.toString(member.getRemain_time()) + "분");
		time.setBounds(1010, 440, 500, 100);
		time.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		time.setForeground(Color.WHITE);
		
		JLabel period = new JLabel(sdFormat.format(member.getRemain_date()) + "까지");
		period.setBounds(1010, 560, 500, 100);
		period.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		period.setForeground(Color.WHITE);
		
		JLabel seat = new JLabel(Integer.toString(MemberDAO.usingSeat(member.getMember_id())) + "번");
		seat.setBounds(1010, 680, 500, 100);
		seat.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		seat.setForeground(Color.WHITE);
		
		JLabel locker = new JLabel(member.getLocker_number() + "번");
		locker.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		locker.setBounds(1010, 800, 500, 100);
		locker.setForeground(Color.WHITE);
		
		logoutBtn.setBounds(62, 114, 200, 40);
		logoutBtn.setForeground(new Color(0xFF5C00));
		logoutBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);
		
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
