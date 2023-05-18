package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class CloseButton extends JButton implements ActionListener {
	
	JDialog dialog;
	
	public CloseButton(JDialog dialog) {
		this.dialog = dialog;
		setIcon(new ImageIcon("ui/SelectSeatPopup/CloseButton.png"));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setSize(150, 80);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.dispose();
	}
}
