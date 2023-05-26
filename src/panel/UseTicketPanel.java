package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class UseTicketPanel extends JPanel{
	
	ImageIcon myPageUseTicketBg = new ImageIcon("ui/MyPage/UseTicket_Rigth_Frame.png");
	Image image = myPageUseTicketBg.getImage();
	
	public UseTicketPanel() {

		setLayout(null);
		setBounds(0, 0, 1190, 740);
		setOpaque(false);
		
		
	
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
}
