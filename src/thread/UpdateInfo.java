package thread;

import dao.MemberDAO;
import dao.SeatDAO;
import dao.SeatReservationDAO;
import dto.Member;
import dto.Seat_reservation;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.MyPagePanel;
import panel.SeatReportPanel;

public class UpdateInfo implements Runnable {
	
	
	SeatReservationDAO seat_res = new SeatReservationDAO();
	SeatDAO seat = new SeatDAO();
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("update start");
				if(MainFrame.member != null && SeatReportPanel.seatBtns.size() == 32) {
					seat_res.autoLeaveSystem();
					seat.checkUse();
					seat_res.UsingSeats();
					System.out.println("update seat");
					setMyPage();
					System.out.println("update MyInfo");
				}
				System.out.println("update complete");
			} catch (Exception e) {
			}
		}	
	}
	
	public void setMyPage() {
		Member mem = MainFrame.member;
		MyPagePanel.phoneNum.setText(mem.getPhone_number());
		MemberDAO.updateRemainTime(mem.getMember_id());
		if(mem.getRemain_date() != null) {
			MyPagePanel.period.setText(mem.getRemain_date() + "까지");
		}
		if(mem.getLocker_number() != null) {
			MyPagePanel.locker.setText(mem.getLocker_number() + "번");
		}
	}
}
