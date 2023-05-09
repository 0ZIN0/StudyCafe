package panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class LockerPanel extends JPanel {

	Image lockerImage;

	public LockerPanel() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(lockerImage, 0, 0, getWidth(), getHeight(), this);
	}
}
