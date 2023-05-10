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
	
	public SelectSeatPanel() {
		setLayout(null);
		setBounds(0, 0, 750, 750);
		setBackground(new Color(0, 0, 0, 0));
	}
	
	/** 백그라운드 이미지 페인팅 메서드 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
}
