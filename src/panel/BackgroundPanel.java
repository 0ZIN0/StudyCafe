package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
	
	Image image;
	
	public BackgroundPanel(ImageIcon icon) {
		this.image = icon.getImage();
		setSize(image.getWidth(null),image.getHeight(null));
		setOpaque(false);
		setVisible(true);
		setLayout(null);
	}
	
	public BackgroundPanel(ImageIcon icon, Color color) {
	    this.image = icon.getImage();
	    setSize(image.getWidth(null),image.getHeight(null));
	    setBackground(color);
	    setVisible(true);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
}
