package toggle;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class LockerToggle extends JToggleButton {
	
	CardLayout card;
	JPanel lockerPanel;
	JPanel subPanel;
	
	public LockerToggle(ImageIcon lockerImage, CardLayout card, JPanel lockerPanel, JPanel subPanel) {
		this.lockerPanel = lockerPanel;
		this.subPanel = subPanel;
		this.card = card;
		
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(subPanel, "locker");
			}
		});
	}
}
