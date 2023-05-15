package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.PaymentButton;
import dao.StudyRoomDAO;
import dto.StudyRoom_Reservation;
import label.DateLabel;
import label.StartTimeLabel;

public class StudyRoomPanel extends JPanel {
	
	/* DTO */
	StudyRoom_Reservation myStudyRoom_Reservation = new StudyRoom_Reservation();
	
	/* 배경 */
	BackgroundPanel image = new BackgroundPanel(new ImageIcon("ui/study_room/Study_Room_Frame.png"), new Color(0x494344));
	
	/* 버튼 */
	JButton topLeftBtn = new JButton(new ImageIcon("ui/study_room/Main_Arrow_01.png"));
	JButton topRightBtn = new JButton(new ImageIcon("ui/study_room/Main_Arrow_03.png"));
	JButton bottomLeftBtn = new JButton(new ImageIcon("ui/study_room/Sub_Arrow_01.png"));
	JButton bottomRightBtn = new JButton(new ImageIcon("ui/study_room/Sub_Arrow_03.png"));
	JButton upBtn = new JButton(new ImageIcon("ui/study_room/TimeUp_Button_01.png"));
	JButton downBtn = new JButton(new ImageIcon("ui/study_room/TimeUp_Button_04.png"));
	JButton paymentBtn = new PaymentButton();

	/* 라벨 */
	JLabel roomNumLabel = new JLabel(new ImageIcon("ui/study_room/studyRoom_01.png"));
	JLabel isTodayLabel = new JLabel("TODAY");
	DateLabel dateLabel = new DateLabel();
	StartTimeLabel startTimeLabel = new StartTimeLabel(myStudyRoom_Reservation);
	JLabel whatTimeLabel = new JLabel("1"); // 1 or 2
	
	List<StudyRoom_Reservation> studyRoom_AllReservation = StudyRoomDAO.getAllReservations(dateLabel.getSelectDay(), "SI-1");
	
	
	/* 패널 */
	GridPanel gridPanel = new GridPanel(upBtn, downBtn, startTimeLabel, studyRoom_AllReservation, whatTimeLabel, myStudyRoom_Reservation);
	
	public StudyRoomPanel() {
		
		/* 버튼 설정 */
		topLeftBtn.setBounds(122, 40, 40, 60);
		topLeftBtn.setBorderPainted(false);
		topLeftBtn.setContentAreaFilled(false);

		topRightBtn.setBounds(434, 40, 40, 60);
		topRightBtn.setBorderPainted(false);
		topRightBtn.setContentAreaFilled(false);
		
		myStudyRoom_Reservation.setStudyRoom_id("SI-1");
		
		// 스터디룸번호 버튼
		topLeftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String room1 = "ui/study_room/studyRoom_01.png";
				roomNumLabel.setIcon(new ImageIcon(room1));
				
				topLeftBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_01.png"));
				topRightBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_03.png"));
				
				myStudyRoom_Reservation.setStudyRoom_id("SI-1");
				
			}
		});
		topRightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String room2 = "ui/study_room/studyRoom_02.png";
				roomNumLabel.setIcon(new ImageIcon(room2));

				topLeftBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_04.png"));
				topRightBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_02.png"));
				
				myStudyRoom_Reservation.setStudyRoom_id("SI-2");
			}
		});

		// ======================================================================================

		bottomLeftBtn.setBounds(122, 162, 34, 52);
		bottomLeftBtn.setBorderPainted(false);
		bottomLeftBtn.setContentAreaFilled(false);
		
		isTodayLabel.setBounds(173, 173, 80, 28);
		isTodayLabel.setForeground(new Color(0xFF5C00));
		isTodayLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 24));
		
		Date date = java.sql.Date.valueOf(dateLabel.getSelectDay());
		myStudyRoom_Reservation.setStudyRoom_reservation_date(date);
		
		// 날짜 버튼
		bottomLeftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				LocalDate now = LocalDate.now();

				if (!now.equals(dateLabel.getSelectDay())) {
					isTodayLabel.setVisible(false);
					dateLabel.setSelectDay(dateLabel.getSelectDay().minusDays(1));
				}
				
				if (now.equals(dateLabel.getSelectDay())) {
					isTodayLabel.setVisible(true);
					bottomLeftBtn.setIcon(new ImageIcon("ui/study_room/Sub_Arrow_01.png"));
				}
				
				studyRoom_AllReservation = StudyRoomDAO.getAllReservations(dateLabel.getSelectDay(), myStudyRoom_Reservation.getStudyRoom_id());
				
				Date date = java.sql.Date.valueOf(dateLabel.getSelectDay());
				myStudyRoom_Reservation.setStudyRoom_reservation_date(date);
			}
		});

		bottomRightBtn.setBounds(440, 162, 34, 52);
		bottomRightBtn.setBorderPainted(false);
		bottomRightBtn.setContentAreaFilled(false);
		bottomRightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LocalDate now = LocalDate.now();
				
				dateLabel.setSelectDay(dateLabel.getSelectDay().plusDays(1));
				
				if (!now.equals(dateLabel.getSelectDay())) {
					isTodayLabel.setVisible(false);
					bottomLeftBtn.setIcon(new ImageIcon("ui/study_room/Sub_Arrow_04.png"));
				}
				
				studyRoom_AllReservation = StudyRoomDAO.getAllReservations(dateLabel.getSelectDay(), myStudyRoom_Reservation.getStudyRoom_id());
				
				Date date = java.sql.Date.valueOf(dateLabel.getSelectDay());
				myStudyRoom_Reservation.setStudyRoom_reservation_date(date);
			}
		});
		
		// ======================================================================================
		upBtn.setBounds(330, 328, 34, 20);
		upBtn.setBorderPainted(false);
		upBtn.setContentAreaFilled(false);
		
		// 사용시간 버튼
		upBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				upBtn.setIcon(new ImageIcon("ui/study_room/TimeUp_Button_03.png"));
				downBtn.setIcon(new ImageIcon("ui/study_room/TimeUp_Button_02.png"));
				whatTimeLabel.setText("2");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				
				String endTime = myStudyRoom_Reservation.getStudyRoom_start_time();
				LocalTime end = LocalTime.parse(endTime, formatter);
				endTime = end.plusHours(2).format(formatter);
					
				myStudyRoom_Reservation.setStudyRoom_end_time(endTime);
			}
		});
		
		downBtn.setBounds(330, 389, 34, 20);
		downBtn.setBorderPainted(false);
		downBtn.setContentAreaFilled(false);
		downBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				upBtn.setIcon(new ImageIcon("ui/study_room/TimeUp_Button_01.png"));
				downBtn.setIcon(new ImageIcon("ui/study_room/TimeUp_Button_04.png"));
				whatTimeLabel.setText("1");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				
				String endTime = myStudyRoom_Reservation.getStudyRoom_start_time();
				LocalTime end = LocalTime.parse(endTime, formatter);
				endTime = end.plusHours(1).format(formatter);

				myStudyRoom_Reservation.setStudyRoom_end_time(endTime);
			}
		});
		
		// ======================================================================================
		
		/* 라벨 설정 */
		roomNumLabel.setBounds(175, 48, 237, 38);
		dateLabel.setBounds(262, 169, 250, 34);
		whatTimeLabel.setBounds(336, 345, 40, 40);
		whatTimeLabel.setForeground(Color.white);
		whatTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		
		/* 패널, 버튼, 라벨 붙이기 */
		image.add(gridPanel);
		
		image.add(topLeftBtn);
		image.add(topRightBtn);
		image.add(bottomLeftBtn);
		image.add(bottomRightBtn);
		image.add(upBtn);
		image.add(downBtn);
		image.add(paymentBtn);
		
		image.add(isTodayLabel);
		image.add(roomNumLabel);
		image.add(dateLabel);
		image.add(whatTimeLabel);
		image.add(startTimeLabel);

		/* 패널 설정 */
		image.setLayout(null);
		add(image);
	}
	
	public List<StudyRoom_Reservation> getStudyRoom_AllReservation() {
		return studyRoom_AllReservation;
	}
}
