package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TimeSelectButton extends JButton {
	
	public TimeSelectButton(JButton upBtn, JButton downBtn) {
		
		setBackground(new Color(0xD9D9D9));
		setBorderPainted(false);
		
		upBtn.setEnabled(false);
		downBtn.setEnabled(false);
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upBtn.setEnabled(true);
				downBtn.setEnabled(true);
				setBackground(new Color(0xFF5C01));
			}
		});
	}
}
