package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.Member;

public class UserInfoPanel extends JPanel{
	
	ImageIcon myPageUserInfoBg = new ImageIcon("ui/MyPage/UserInfo_Rigth_Frame.png");
	Image image = myPageUserInfoBg.getImage();
	
	Member member = ;
	
	public static JLabel phoneNum;
	public static JLabel time;
	public static JLabel period;
	public static JLabel seat;
	public static JLabel locker;
	 
	public UserInfoPanel() {
		
		setLayout(null);
		setBounds(0, 0, 1190, 740);
		setOpaque(false);
		
//		this.member = member;
//    	
//    	phoneNum = new JLabel(member.getPhone_number());
//    	phoneNum.setBounds(getVisibleRect());
    	
    	
	}
		
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
}
