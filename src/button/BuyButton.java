package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dialog.TimeOrPeriodChargeDialog;

public class BuyButton extends JButton implements ActionListener{
	
	public BuyButton(ImageIcon buyImageIcon) {

		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(buyImageIcon);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TimeOrPeriodChargeDialog chageDialog = new TimeOrPeriodChargeDialog();
	}
}
