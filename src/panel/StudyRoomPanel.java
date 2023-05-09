package panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class StudyRoomPanel extends JPanel {
	
	Image studyRoomImage;
	
	public StudyRoomPanel() {
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(studyRoomImage, 0, 0, getWidth(), getHeight(), this);
	}
}
