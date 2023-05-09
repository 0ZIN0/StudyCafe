package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import dialog.LeaveDialog;

public class LeaveButton extends JButton {
	
	JDialog leavePopup;
	
	public LeaveButton(ImageIcon leaveImageIcon, JFrame parent) {
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(leaveImageIcon);
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leavePopup = new LeaveDialog(parent);
			}
		});
	}
}
