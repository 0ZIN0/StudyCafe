package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import button.TimeSelectButton;
import color.MyColor;
import dao.MemberDAO;
import dao.SeatDAO;
import dao.StudyRoomDAO;
import dao.TicketOrderDAO;
import dto.StudyRoom_Reservation;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.GridPanel;
import panel.LockerPanel;
import panel.SeatReportPanel;
import panel.StudyRoomPanel;
import panel.UserInfoPanel;


public class CompletePaymentDialog extends JDialog {

	List<TimeSelectButton> btns = MainFrame.btns.getBtns();

	public CompletePaymentDialog() {
		
		int btnId = MainFrame.btn.getBtnId();
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_Compelete_4/Payment_Complete.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};

		ImageIcon buttonIcon2 = new ImageIcon("ui/결제 팝업/PayInfo_Compelete_4/MainButton.png");
		JButton mainButton = new JButton(buttonIcon2);

		mainButton.setBorderPainted(false);
		mainButton.setContentAreaFilled(false);
		
		mainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TimeOrPeriodChargeDialog.ticket_order.setMember_id(MainFrame.member.getMember_id());
				TicketOrderDAO.saveOrder(TimeOrPeriodChargeDialog.ticket_order);

				/* 건들지 마시오 (로아) */
				String ticket_id = TimeOrPeriodChargeDialog.ticket_order.getTicket_id();
				String[] num = ticket_id.split("-");

				if (Integer.parseInt(num[1]) >= 1 && Integer.parseInt(num[1]) <= 6) { // 일회이용권
					int ticket_value = 0;
					if (ticket_id.equals("T-01")) {
						ticket_value = 120;
					} else if (ticket_id.equals("T-02")) {
						ticket_value = 180;
					} else if (ticket_id.equals("T-03")) {
						ticket_value = 240;
					} else if (ticket_id.equals("T-04")) {
						ticket_value = 360;
					} else if (ticket_id.equals("T-05")) {
						ticket_value = 480;
					} else if (ticket_id.equals("T-06")) {
						ticket_value = 1440;
					}

					if (SeatReportPanel.mySeat == 0) {
						SeatDAO.setOneDayReservation(SeatReportPanel.seat_reservation, ticket_value);
						setSeatReportPanel();

					} else {
						int seat = SeatReportPanel.seat_reservation.getSeat_id();
						SeatDAO.plusOneDayTicket(seat, ticket_value);
					}
				} else if (Integer.parseInt(num[1]) >= 15 && Integer.parseInt(num[1]) <= 18) { // 스터디룸
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
					String date = formatter.format(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_reservation_date());
					String start = StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_time().replace(":", "").strip();
					String end = StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_end_time().replace(":", "").strip();

					StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_start_dateTime(date+start);
					if (end.equals("0000")) {
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");

						LocalDate endDate = LocalDate.parse(date, formatter2);
						date = endDate.plusDays(1).format(formatter2);

						StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_end_dateTime(date+end);
					} else {
						StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_end_dateTime(date+end);
					}
					StudyRoomDAO.setReservation(StudyRoomPanel.myStudyRoom_Reservation);

					if (StudyRoomPanel.whatTimeLabel.getText().equals("1")) {
						getReservationInfo(4);
					} else {
						getReservationInfo(8);
					}
					StudyRoomPanel.topLeftBtn.doClick();
					
				} else if (Integer.parseInt(num[1]) >= 7 && Integer.parseInt(num[1]) <= 10) { // 시간충전권
					MemberDAO.chargeTime(ticket_id);
					if (SeatReportPanel.mySeat == 0 && btnId == 0) {
						setSeatReportPanel();
					}
				} else if (Integer.parseInt(num[1]) >= 11 && Integer.parseInt(num[1]) <= 14) { // 기간이용권
					MemberDAO.chargeDate(ticket_id);
					if (SeatReportPanel.mySeat == 0 && btnId == 0) {
						setSeatReportPanel();
					}
				} else if (Integer.parseInt(num[1]) >= 19 && Integer.parseInt(num[1]) <= 22) { // 사물함
					TicketOrderDAO.setLockerinMember(TimeOrPeriodChargeDialog.ticket_order, LockerPanel.lockerNum);
				} 
				/* 여기까지 절대 건들지 마시오 (로아) */
				TimeOrPeriodChargeDialog.ticket_order.setMember_id(MainFrame.member.getMember_id());
				dispose();
			}
		});

		mainButton.setBounds(250, 320, 250, 80);

		add(mainButton);

		background.setBackground(new Color(0,0,0,0));
		add(background);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
	
	public void setSeatReportPanel() {
		
		SeatReportPanel.seat_reservation.setMember_id(MainFrame.member.getMember_id());
		SeatDAO.setUseTicketReservation(SeatReportPanel.seat_reservation);
		int seat = SeatReportPanel.seat_reservation.getSeat_id();

		UserInfoPanel.seat.setText(seat + "번");
		SeatReportPanel.seatInfoLabel.setText(seat + "번 좌석을 사용중입니다.");
		SeatReportPanel.seatInfoLabel.setBounds(507, 28, 550, 50);
		SeatReportPanel.seatBtns.get(seat - 1).setBackground(MyColor.ORANGE);
		SeatReportPanel.seatBtns.get(seat - 1).use = true;
		SeatReportPanel.mySeat = seat;

		RemainSeatLabel.remain = SeatDAO.isRemain();
		SeatReportPanel.remainSeatLabel.setText(
				String.format("%02d / %02d",
						RemainSeatLabel.remain[0],RemainSeatLabel.remain[1]));
	}
	
	public void getReservationInfo(int btnNum) {
		boolean[] reserved = new boolean[96];

		LocalDate labelDate = GridPanel.dateLabel.getSelectDay();
		String studyroom_id = StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_id(); 
		List<StudyRoom_Reservation> studyRoom_AllReservation = StudyRoomDAO.getAllReservations(labelDate, studyroom_id);

		for (StudyRoom_Reservation studyRoom_reserv : studyRoom_AllReservation) {
			for(TimeSelectButton timeSelectBtn : btns) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				
				LocalDateTime selectDateTime = LocalDateTime.of(labelDate, timeSelectBtn.getTime());
				LocalTime selectTime = timeSelectBtn.getTime();
				LocalDateTime start = LocalDateTime.parse(studyRoom_reserv.getStudyRoom_start_dateTime(), formatter);
				LocalDateTime end = LocalDateTime.parse(studyRoom_reserv.getStudyRoom_end_dateTime(), formatter);
				if (start.compareTo(selectDateTime) <= 0 && 
						end.compareTo(selectDateTime) > 0) {
					for(int i = btns.indexOf(timeSelectBtn) - (btnNum - 1); i < btns.indexOf(timeSelectBtn) && btns.indexOf(timeSelectBtn) - (btnNum - 1) >= 0; i++) {
						btns.get(i).setEnabled(false);
					}
					if (selectTime.compareTo(GridPanel.startTimeLabel.getTime()) <= 0 &&
							labelDate.equals(LocalDate.now())) {
						timeSelectBtn.setBackground(MyColor.GRAY);
					} else {
						if (StudyRoomPanel.myStudyRoom_Reservation.getMember_id().equals(studyRoom_reserv.getMember_id())) {
							timeSelectBtn.setBackground(MyColor.LEMON);
						} else {
							timeSelectBtn.setBackground(MyColor.GRAY);
						}
					}
					timeSelectBtn.setEnabled(false);
					reserved[btns.indexOf(timeSelectBtn)] = true;
				}            
			}
		}
	}
}