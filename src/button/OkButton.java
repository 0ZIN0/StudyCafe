package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class OkButton extends JButton {
	
	public OkButton(JDialog parent) {
		
		setIcon(new ImageIcon("ui/button/Check_Button.png"));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setBounds(402, 310, 154, 88);
	}
}
