package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.MypageDAO;
import dto.Member;
import frame.MainFrame;

public class UseTicketPanel extends JPanel{
	
	ImageIcon myPageUseTicketBg = new ImageIcon("ui/MyPage/UseTicket_Rigth_Frame.png");
	Image image = myPageUseTicketBg.getImage();
	
	Member member = MainFrame.member;
	
	public static JLabel ticketName;
	public static JLabel remainTime;
	public static JLabel remainPeriod;
	public static JLabel period;
	
	
	public UseTicketPanel() {

		setLayout(null);
		setBounds(0, 0, 1190, 740);
		setOpaque(false);
		
		ticketName = new JLabel();
		if (MypageDAO.isUseTicket() == null) {
			ticketName.setText("사용중인 상품이 없습니다.");
		} else {
			ticketName.setText(MypageDAO.isUseTicket());
		}
		ticketName.setBounds(505, 167, 490, 58);
		ticketName.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
		ticketName.setForeground(Color.WHITE);
		
		remainTime = new JLabel();
        Integer remain_time = member.getRemain_time();
        if(remain_time == null) {
        	remainTime.setText("없음");
        } else {
           if(remain_time >= 60) {
              int hour = remain_time / 60;
              int minute = remain_time % 60;
              remainTime.setText(hour + "시간 " + minute + "분");
           } else {
        	   remainTime.setText(remain_time + "분");            
           }
        }
        remainTime.setBounds(505, 274, 465, 58);
        remainTime.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
        remainTime.setForeground(Color.WHITE);
        
        remainPeriod = new JLabel();
        if(MypageDAO.getRemainPeriod() != null) {
        	remainPeriod.setText(MypageDAO.getRemainPeriod() + "일");
        }
        remainPeriod .setBounds(505, 379, 470, 58);
        remainPeriod.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
        remainPeriod.setForeground(Color.WHITE);
		
        
        period = new JLabel();
        if(member.getRemain_date() == null) {
           period.setText("");
        } else {
           period.setText(member.getRemain_date() + "까지");
        }
        period.setBounds(505, 485, 470, 58);
        period.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
        period.setForeground(Color.WHITE);
		
        add(ticketName);
        add(remainTime);
        add(remainPeriod);
        add(period);
        
        
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
}
