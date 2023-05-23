package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChargeTimeButton extends JButton{
	
	
	public ChargeTimeButton(ImageIcon image) {
		
		setIcon(image);
		setBackground(new Color(0,0,0,0));
		setSize(image.getIconWidth(), image.getIconHeight());
		setBorderPainted(false);
		setContentAreaFilled(false);	
	}
	
	
}
