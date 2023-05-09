package toggle;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class StudyRoomToggle extends JToggleButton {
	
	CardLayout card;
	JPanel studyRoomPanel;
	JPanel subPanel;
	
	public StudyRoomToggle(ImageIcon studyRoomdImage, CardLayout card, JPanel studyRoomPanel, JPanel subPanel) {
		this.studyRoomPanel = studyRoomPanel;
		this.subPanel = subPanel;
		this.card = card;
		
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(subPanel, "study");
			}
		});
	}
}
