package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dialog.TimeOrPeriodChargeDialog;
import dto.Member;

public class BuyButton extends JButton implements ActionListener{
	
	Member member;

	public BuyButton(ImageIcon buyImageIcon) {

		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(buyImageIcon);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TimeOrPeriodChargeDialog chageDialog = new TimeOrPeriodChargeDialog(member);
	}
}
