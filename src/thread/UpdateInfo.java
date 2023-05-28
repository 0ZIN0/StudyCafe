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
				Thread.sleep(1000);
				if(MainFrame.member != null && SeatReportPanel.seatBtns.size() == 32) {
					setSeatReport();
					LockerDAO.updateLockerInfo();
					setMyPage();
					setLocker();
				}
			} catch (Exception e) {
			}
		}	
	}
	
	public static void setMyPage() {
		
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
	
	public static void setLocker() {
		int remain = LockerDAO.remainLocker();
		LockerPanel.remainLockerLabel.setText(String.format("%02d / %02d", remain, 20));
		List<String[]> isUse = LockerDAO.isUse();
		
		if(MainFrame.member.getLocker_number() == null) {
			LockerPanel.myLockerLabel.setText("이용하실 사물함을 선택해주세요");
		}
		for(int i = 0; i < LockerPanel.lockerBtns.size(); i++) {
			if(isUse.get(i)[1] != null) {
				if(isUse.get(i)[1].equals(MainFrame.member.getMember_id())) {
					LockerPanel.lockerBtns.get(i).setBackground(MyColor.ORANGE);
					LockerPanel.myLockerLabel.setText(isUse.get(i)[0] + "번 사물함을 사용중입니다");
					LockerPanel.myLockerLabel.setBounds(290, 13, 800, 72);
					LockerPanel.lockerBtns.get(i).setEnabled(false);
				} else {
					LockerPanel.lockerBtns.get(i).setBackground(MyColor.GRAY);
					LockerPanel.lockerBtns.get(i).setEnabled(false);
				}
			} else {
				LockerPanel.lockerBtns.get(i).setBackground(MyColor.LIGHTGRAY);					
				if(MainFrame.member.getLocker_number() != null) {
					LockerPanel.lockerBtns.get(i).setEnabled(false);
				} else {
					LockerPanel.lockerBtns.get(i).setEnabled(true);
				}
			}			
		}
	}
	
	public void setSeatReport() {
		SeatReservationDAO.autoLeaveSystem();
		SeatReservationDAO.UsingSeats();
		SeatDAO.checkUse();
		SeatDAO.findMemberSeat();
	}
}
