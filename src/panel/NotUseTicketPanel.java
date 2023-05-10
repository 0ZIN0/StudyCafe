package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NotUseTicketPanel extends JPanel {
	
	ImageIcon icon = new ImageIcon("ui/SelectSeatPopup/Background.png");
	Image image = icon.getImage();
	
	/* 좌석 번호 알려주는 라벨 */
	JLabel seatlabel;
	
	public NotUseTicketPanel(String seatNum) {
		
		/* 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		seatlabel = new JLabel(seatName);
		
		seatlabel.setBounds(287, 55, 200, 50);
		seatlabel.setForeground(new Color(0x131313));
		seatlabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		
		add(seatlabel);
	}
	
	/** 백그라운드 이미지 페인팅 메서드 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
}
