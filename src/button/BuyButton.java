package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dialog.TimeOrPeriodChargeDialog;
import dto.Button;
import dto.Member;
import frame.MainFrame;

public class BuyButton extends JButton implements ActionListener{
	
	Member member;
	private static int btnId = 1;
	public BuyButton(ImageIcon buyImageIcon) {

		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(buyImageIcon);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TimeOrPeriodChargeDialog chageDialog = new TimeOrPeriodChargeDialog(member);
		MainFrame.btn.setBtnId(btnId);
	}
}
