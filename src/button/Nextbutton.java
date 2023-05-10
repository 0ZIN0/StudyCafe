package button;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Nextbutton extends JButton implements ActionListener{
	
	CardLayout card = new CardLayout();
	
	public Nextbutton() {
		setIcon(new ImageIcon("ui/Locker_PopUp/NextButton.png"));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setSize(150, 80);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
