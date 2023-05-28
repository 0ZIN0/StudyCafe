package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import dao.TicketDAO;
import dialog.NotUseTicketDialog;
import dialog.SelectSeatDialog;
import dialog.UseTicketDialog;
import dto.Seat;
import frame.MainFrame;

public class UseTicketButton extends JButton {
	
	boolean remainTicket = TicketDAO.isUsingTicket(MainFrame.member.getMember_id());
	public static boolean useSeat;
	public static boolean oneday;
	public static boolean time;
	public static boolean period;
	
	public UseTicketButton(SelectSeatDialog selectSeatPopup, String seatNum, Seat seat) {
		
		setBorderPainted(false);
		setIcon(new ImageIcon("ui/SelectSeatPopup/Button_사용중.png"));
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectSeatPopup.dispose();
				
				if (remainTicket) {
					if (!useSeat) {
						JDialog UseTicketPopup = new UseTicketDialog(seatNum, seat);
					}
				} else {
					JDialog NotUseTicketPopup = new NotUseTicketDialog(seatNum, seat);
				}
			}
		});
	}
}
