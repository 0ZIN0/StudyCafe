package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dialog.TimeOrPeriodChargeDialog;
import dto.Seat;
import dialog.OnePassChargeDialog;
import dialog.SelectSeatDialog;
import dialog.TimeChargeDialog;

public class TimeTicketButton extends JButton {
	
	public TimeTicketButton(SelectSeatDialog dialog) {
		
		setBorderPainted(false);
		setIcon(new ImageIcon("ui/SelectSeatPopup/Button_시간충전.png"));
		
		addActionListener(new ActionListener() {
			
			// 클릭하면 실행되는 메서드
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				TimeChargeDialog timeCharge = new TimeChargeDialog();
			}
		});
	}
	
}
