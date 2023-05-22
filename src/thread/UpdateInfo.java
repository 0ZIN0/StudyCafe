package thread;

import dao.MemberDAO;
import dao.SeatDAO;
import dao.SeatReservationDAO;
import dto.Member;
import dto.Seat_reservation;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.MyPagePanel;

public class UpdateInfo implements Runnable {
	
	
	SeatReservationDAO seat_res = new SeatReservationDAO();
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("update start");
//				seat_res.autoLeaveSystem();
				if(MainFrame.member != null) {
					seat_res.UsingSeats();
					setMyPage();
					System.out.println("member update");
				}
				System.out.println("update");
			} catch (Exception e) {
			}
		}	
	}
	
	public void setMyPage() {
		Member mem = MainFrame.member;
		MyPagePanel.phoneNum.setText(mem.getPhone_number());
		System.out.println(mem.getMember_id());
		MyPagePanel.time.setText(mem.getRemain_time() + "분");
		if(mem.getRemain_date() != null) {
			MyPagePanel.period.setText(mem.getRemain_date() + "까지");
		}
		if(mem.getLocker_number() != null) {
			MyPagePanel.locker.setText(mem.getLocker_number() + "번");
		}
	}
}
