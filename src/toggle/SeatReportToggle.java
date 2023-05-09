package toggle;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class SeatReportToggle extends JToggleButton {
	
	CardLayout card;
	JPanel seatReportPanel;
	JPanel subPanel;
	
	public SeatReportToggle(ImageIcon seatReportImage, CardLayout card, JPanel seatReportPanel, JPanel subPanel) {
		this.seatReportPanel = seatReportPanel;
		this.subPanel = subPanel;
		this.card = card;
		
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(seatReportImage);
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(subPanel, "seat");
			}
		});
		
	}
}
