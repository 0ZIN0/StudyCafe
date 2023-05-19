package thread;

import dao.MemberDAO;
import dao.SeatReservationDAO;
import dto.Member;
import dto.Seat_reservation;
import frame.CheckInFrame;
import panel.MyPagePanel;

public class UpdateInfo implements Runnable {
	
	Member member = CheckInFrame.member;
	SeatReservationDAO seat_res = new SeatReservationDAO();
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(60000);
				System.out.println(seat_res.UsingSeats());
			} catch (Exception e) {
			}
		}	
	}
}
