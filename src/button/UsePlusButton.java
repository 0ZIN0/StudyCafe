package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import dao.SeatReservationDAO;
import dialog.MySeatDialog;
import dialog.SelectSeatDialog;
import dto.Seat;
import panel.SeatReportPanel;

public class UsePlusButton extends JButton {
	
	public UsePlusButton(MySeatDialog parent, String seatNum, Seat seat) {
		
		setIcon(new ImageIcon("ui/myseat/Button_plus.png"));
		setBounds(495, 162, 200, 200);
		setBackground(new Color(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				UseTicketButton.useSeat = true;
				
				if (SeatReservationDAO.getUseTicket().equals("일회이용권")) {
					UseTicketButton.oneday = true;
					UseTicketButton.time = false;
					UseTicketButton.period = false;
				} else if (SeatReservationDAO.getUseTicket().equals("기간이용권")) {
					UseTicketButton.oneday = false;
					UseTicketButton.time = false;
					UseTicketButton.period = true;
				} else if (SeatReservationDAO.getUseTicket().equals("시간충전권")) {
					UseTicketButton.oneday = false;
					UseTicketButton.time = true;
					UseTicketButton.period = false;
				}
				
				JDialog selectSeatPopup = new SelectSeatDialog(seatNum , seat);
			}
		});
		
	}
}
