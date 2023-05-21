package thread;

import dao.MemberDAO;
import dao.SeatDAO;
import dao.SeatReservationDAO;
import dto.Member;
import dto.Seat_reservation;
import frame.CheckInFrame;
import label.RemainSeatLabel;
import panel.MyPagePanel;

public class UpdateInfo implements Runnable {
	
	Member member = CheckInFrame.member;
	SeatReservationDAO seat_res = new SeatReservationDAO();
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				seat_res.autoLeaveSystem();
				seat_res.UsingSeats();
				System.out.println("update");
			} catch (Exception e) {
			}
		}	
	}
}
