package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.DayTicketButton;
import button.TermTicketButton;
import button.TimeTicketButton;
import button.UseTicketButton;

public class SelectSeatPanel extends JPanel {
	
	ImageIcon icon = new ImageIcon("ui/SelectSeatPopup/Background.png");
	Image image = icon.getImage();
	
	/* 구매 버튼 */
	JButton dayTicketBtn = new DayTicketButton();
	JButton timeTicketBtn = new TimeTicketButton();
	JButton termTicketBtn = new TermTicketButton();
	JButton useTicketBtn = new UseTicketButton();
	
	/* 좌석 번호 알려주는 라벨 */
	JLabel label;
	
	public SelectSeatPanel(String seatNum) {
		add(dayTicketBtn);
		
		/* 이용권 버튼들 설정 */
		dayTicketBtn.setBounds(165, 165, 200, 200);
		timeTicketBtn.setBounds(385, 165, 200, 200);
		termTicketBtn.setBounds(165, 385, 200, 200);
		useTicketBtn.setBounds(385, 385, 200, 200);
		
		/* 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		
		label = new JLabel(seatName);
		
		label.setBounds(287, 55, 200, 50);
		label.setForeground(new Color(0x131313));
		label.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		add(label);
		
		/* 패널 */
		add(dayTicketBtn);
		add(timeTicketBtn);
		add(termTicketBtn);
		add(useTicketBtn);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
}
