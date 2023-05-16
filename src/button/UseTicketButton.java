package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import dialog.NotUseTicketDialog;
import dialog.SelectSeatDialog;
import dialog.UseTicketDialog;

public class UseTicketButton extends JButton {
	
	boolean remainTicket;
	
	public UseTicketButton(SelectSeatDialog selectSeatPopup, String seatNum) {
		
		setBorderPainted(false);
		setIcon(new ImageIcon("ui/SelectSeatPopup/Button_사용중.png"));
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectSeatPopup.dispose();
				
				if (remainTicket) {
					JDialog UseTicketPopup = new UseTicketDialog(seatNum);
				} else {
					JDialog NotUseTicketPopup = new NotUseTicketDialog(seatNum);
				}
			}
		});
	}
}
