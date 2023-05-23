package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import color.MyColor;
import dao.SeatDAO;
import dao.StudyRoomDAO;
import dao.TicketOrderDAO;
import dto.StudyRoom_Reservation;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.MyPagePanel;
import panel.SeatReportPanel;
import panel.StudyRoomPanel;

public class CompletePaymentDialog extends JDialog {

	public CompletePaymentDialog() {
		System.out.println("결제완료금액:  " + InsertCardDialog.amountPaid); 

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

				//				temDTO dto = new temDTO("2시", description);
				//				temDAO dao = new temDAO();
				//				dao.addTem(dto);
				
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
					
					if (SeatReportPanel.mySeat == 0 ) {
						
						SeatReportPanel.seat_reservation.setMember_id(MainFrame.member.getMember_id());
						SeatDAO.setOneDayReservation(SeatReportPanel.seat_reservation, ticket_value);
						
						int seat = SeatReportPanel.seat_reservation.getSeat_id();
						
						MyPagePanel.seat.setText(seat + "번");
						SeatReportPanel.seatInfoLabel.setText(seat + "번 좌석을 사용중입니다.");
						SeatReportPanel.seatInfoLabel.setBounds(507, 28, 550, 50);
						SeatReportPanel.seatBtns.get(seat - 1).setBackground(MyColor.ORANGE);
						SeatReportPanel.seatBtns.get(seat - 1).use = true;
						SeatReportPanel.mySeat = seat;
						
						RemainSeatLabel.remain = SeatDAO.isRemain();
						SeatReportPanel.remainSeatLabel.setText(String.format("%02d / %02d",RemainSeatLabel.remain[0],RemainSeatLabel.remain[1]));
					} else {
						int seat = SeatReportPanel.seat_reservation.getSeat_id();
						SeatDAO.plusOneDayTicket(seat, ticket_value);
					}
				} else if (Integer.parseInt(num[1]) >= 15 && Integer.parseInt(num[1]) <= 18) { // 스터디룸
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
					String date = formatter.format(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_reservation_date());
					String start = StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_time().replace(":", "").strip();
					String end = StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_end_time().replace(":", "").strip();
					
					StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_start_time(date+start);
					StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_end_time(date+end);
					
					StudyRoomDAO.setReservation(StudyRoomPanel.myStudyRoom_Reservation);
					
				} else if (Integer.parseInt(num[1]) >= 19 && Integer.parseInt(num[1]) <= 22) { // 사물함
					
				}
				/* 여기까지 절대 건들지 마시오 (로아) */
//					
				TimeOrPeriodChargeDialog.ticket_order.setMember_id(MainFrame.member.getMember_id());
				TicketOrderDAO.saveOrder(TimeOrPeriodChargeDialog.ticket_order);

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
}