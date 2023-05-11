package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TimeSelectButton extends JButton {
	
	public TimeSelectButton() {
		
		setBackground(Color.white);
		setBorderPainted(false);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
