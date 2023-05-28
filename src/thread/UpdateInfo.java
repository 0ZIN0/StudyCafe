package thread;

import java.util.List;

import javax.swing.JLabel;

import color.MyColor;
import dao.LockerDAO;
import dao.MemberDAO;
import dao.MypageDAO;
import dao.SeatDAO;
import dao.SeatReservationDAO;
import dto.Seat_reservation;
import frame.MainFrame;
import panel.LockerPanel;
import panel.SeatReportPanel;
import panel.UseTicketPanel;
import panel.UserInfoPanel;
import toggle.UserInfoToggle;

public class UpdateInfo implements Runnable {
	

	@Override
	public void run() {
		while(true) {
			try {
				//1초마다 갱신
				Thread.sleep(1000);
				if(MainFrame.member != null && SeatReportPanel.seatBtns.size() == 32) {
					
					// 좌석 현황 갱신
					setSeatReport();
					
					// 마이페이지 갱신
					setMyPage();
					
					// 사물함 갱신
					setLocker();
				}
			} catch (Exception e) {
			}
		}	
	}
	
	/** 마이페이지 갱신*/
	public static void setMyPage() {
		/** 멤버가 사용중인 이용권과 이용권에 따른 남은 시간 조회 및 마이 페이지 이용권에 잔여시간 잔여 기간 갱신*/
		MemberDAO.updateRemainTime(MainFrame.member.getMember_id());
		
		if(MainFrame.member.getRemain_date() == null) {
			UseTicketPanel.period.setText("");
		} else {	
			UseTicketPanel.period.setText(MainFrame.member.getRemain_date() + "까지");
		}
		if(MainFrame.member.getLocker_number() == null) {
			UserInfoPanel.locker.setText("이용중인 사물함이 없습니다");
		} else {
			UserInfoPanel.locker.setText(MainFrame.member.getLocker_number() + "번");
		}
    	if(MypageDAO.checkInTime() == null) {
    		UserInfoPanel.checkInTime.setText("");
    	} else {
    		UserInfoPanel.checkInTime.setText(MypageDAO.checkInTime());
    	}
    	if (MypageDAO.isUseTicket() == null) {
			UseTicketPanel.ticketName.setText("사용중인 상품이 없습니다.");
		} else {
			UseTicketPanel.ticketName.setText(MypageDAO.isUseTicket());
		}
	}
	
	/** 사물함 갱신*/
	public static void setLocker() {
		/*잔여 기간이 끝나면 멤버의 사물함을 null로 바꾸는 메서드*/
		LockerDAO.updateLockerInfo();
		
		/*잔여 사물함의 개수를 세는 메서드*/
		int remain = LockerDAO.remainLocker();
		
		LockerPanel.remainLockerLabel.setText(String.format("%02d / %02d", remain, 20));
		
		// 사물함 순서대로 사물함 번호와 사용중인 멤버를 리스트에 add
		List<String[]> isUse = LockerDAO.isUse();
		
		if(MainFrame.member.getLocker_number() == null) {
			LockerPanel.myLockerLabel.setText("이용하실 사물함을 선택해주세요");
		}
		
		for(int i = 0; i < LockerPanel.lockerBtns.size(); i++) {
			// 사물함을 사용하는 멤버가 있다면
			if(isUse.get(i)[1] != null) {
				// 멤버 아이디가 일치한다면
				if(isUse.get(i)[1].equals(MainFrame.member.getMember_id())) {
					LockerPanel.lockerBtns.get(i).setBackground(MyColor.ORANGE);
					LockerPanel.myLockerLabel.setText(isUse.get(i)[0] + "번 사물함을 사용중입니다");
					LockerPanel.myLockerLabel.setBounds(290, 13, 800, 72);
					LockerPanel.lockerBtns.get(i).setEnabled(false);
				} else {
					// 불일치 한다면
					LockerPanel.lockerBtns.get(i).setBackground(MyColor.GRAY);
					LockerPanel.lockerBtns.get(i).setEnabled(false);
				}
			} else {
				// 사용하는 멤버가 없다면
				LockerPanel.lockerBtns.get(i).setBackground(MyColor.LIGHTGRAY);
				if(MainFrame.member.getLocker_number() != null) {
					// 멤버가 사용중인 사물함이 있다면
					LockerPanel.lockerBtns.get(i).setEnabled(false);
				} else {
					// 멤버가 사용중인 사물함이 없다면
					LockerPanel.lockerBtns.get(i).setEnabled(true);
				}
			}			
		}
	}
	
	/** 좌석현황 갱신 및 나의 좌석 갱신*/
	public void setSeatReport() {
		/*자동 퇴실 메서드*/
		SeatReservationDAO.autoLeaveSystem();
		/*좌석 상태와 사용중인 멤버를 조회하여 좌석의 색깔과 남은 좌석의 정보를 바꿔주는 메서드*/
		SeatReservationDAO.UsingSeats();
		/*좌석 상태를 확인하여 좌석의 use(boolean형으로 클릭시 나오는 팝업이 바뀜)을 변경*/
		SeatDAO.checkUse();
		/*내가 사용중인 좌석이 있는지 확인하고 seatReportlabel를 변경*/
		SeatDAO.findMemberSeat();
	}
}
