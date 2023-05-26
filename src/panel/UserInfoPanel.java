package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.MypageDAO;
import dao.SeatDAO;
import dto.Member;
import frame.MainFrame;

public class UserInfoPanel extends JPanel{
	
	ImageIcon myPageUserInfoBg = new ImageIcon("ui/MyPage/UserInfo_Rigth_Frame.png");
	Image image = myPageUserInfoBg.getImage();
	
	Member member = MainFrame.member;
	
	public static JLabel phoneNum;
	public static JLabel checkInTime;
	public static JLabel seat;
	public static JLabel locker;
	 
	public UserInfoPanel() {
		
		setLayout(null);
		setBounds(0, 0, 1190, 740);
		setOpaque(false);
    	
    	phoneNum = new JLabel(member.getPhone_number());
    	phoneNum.setBounds(505,167,300,58);
    	phoneNum.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
    	phoneNum.setForeground(Color.WHITE);
    	
    	checkInTime = new JLabel(MypageDAO.checkInTime());
    	if(MypageDAO.checkInTime() == null) {
    		checkInTime.setText("");
    	} else {
    		checkInTime.setText(MypageDAO.checkInTime());
    	}
    	checkInTime.setBounds(505, 273, 500, 58);
    	checkInTime.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
    	checkInTime.setForeground(Color.WHITE);
        
        seat = new JLabel(SeatDAO.isUsingMySeat(MainFrame.member.getMember_id()) + "번");
        
        if(member.getMember_id() == null) {
        	seat.setText("사용중인 좌석이 없습니다.");
        } else {
        	seat.setText(SeatDAO.isUsingMySeat(MainFrame.member.getMember_id()) + "번");
        }
        seat.setBounds(505, 379, 430, 58);
        seat.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
        seat.setForeground(Color.WHITE);
        
        locker = new JLabel(member.getLocker_number() + "번");
        if(member.getLocker_number() == null) {
           locker.setText("사용중인 사물함이 없습니다.");
        } else {
           locker.setText(MainFrame.member.getLocker_number() + "번");
        }
        locker.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 40));
        locker.setBounds(505, 485, 465, 58);
        locker.setForeground(Color.WHITE);
                
        add(phoneNum);
        add(checkInTime);
        add(seat);
        add(locker);
    	
	}
		
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
}
