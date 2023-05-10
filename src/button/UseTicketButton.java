package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

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
				
				} else {
					JDialog UseTicketPopup = new UseTicketDialog(seatNum);
					System.out.println("뜸");
//					JDialog NotUseTicketPopup = new NotUseTicketDialog(seatNum);
				}
			}
		});
	}
}
