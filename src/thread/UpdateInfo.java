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
//				System.out.println("update complete");
			} catch (Exception e) {
			}
		}	
	}
	
	public void setMyPage() {
		System.out.println("마이페이지 업데이트 시작");
		MemberDAO.updateRemainTime(MainFrame.member.getMember_id());
		System.out.println("시간 업데이트");
		if(MainFrame.member.getRemain_date() != null) {
			MyPagePanel.period.setText(MainFrame.member.getRemain_date() + "까지");
			System.out.println("기간 업데이트");
		}
		if(MainFrame.member.getLocker_number() != null) {
			System.out.println("사물함 번호 : " + MainFrame.member.getLocker_number());
			MyPagePanel.locker.setText("L-" + MainFrame.member.getLocker_number() + "번");
			System.out.println("사물함 업데이트");
		}
	}
}
