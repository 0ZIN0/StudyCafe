package panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.TimeSelectButton;
import dao.StudyRoomDAO;
import dto.Member;
import dto.StudyRoom_Reservation;
import label.DateLabel;
import label.StartTimeLabel;

public class GridPanel extends JPanel {

	final static Color ORANGE = new Color(0xFF5C01);
	final static Color GRAY = new Color(0x8D8787);
	final static Color LIGHTGRAY = new Color(0xD9D9D9);
	final static Color LEMON = new Color(0xffdc74);

	public static DateLabel dateLabel; // 라벨의 날짜

	/* dto */
	StudyRoom_Reservation myStudyRoom_Reservation = new StudyRoom_Reservation();
	Member member = new Member();

	/* 날짜, 시간 */
	public static StartTimeLabel startTimeLabel;
	LocalDate nowDate = LocalDate.now();
	LocalTime time = LocalTime.of(0, 0); // timeSelectBtn에 넣을 시간의 default값
	public static List<TimeSelectButton> btns = new ArrayList<>();
	int btnQty = 4; // 초기 버튼 선택 갯수

	boolean[] reserved = new boolean[96]; 
	boolean[] selected = new boolean[96]; 
	boolean disable = false;

	public GridPanel(JButton upBtn, JButton downBtn, 
			JButton topLeftBtn, JButton topRightBtn,
			JButton BottomLeftBtn, JButton BottomRightBtn,
			StartTimeLabel startTimeLabel, 
			JLabel whatTimeLabel,StudyRoom_Reservation myStudyRoom_Reservation, 
			JButton paymentBtn, DateLabel dateLabel, Member member) {

		this.myStudyRoom_Reservation = myStudyRoom_Reservation;
		this.dateLabel = dateLabel;
		this.startTimeLabel = startTimeLabel;
		this.member = member;
		GridLayout grid = new GridLayout(12, 8);

		myStudyRoom_Reservation.setStudyRoom_id("SI-1");

		grid.setHgap(3);
		grid.setVgap(3);
		paymentBtn.setEnabled(false);

		for (int i = 0; i < 96; ++i) {

			TimeSelectButton timeSelectBtn = 
					new TimeSelectButton(upBtn, downBtn, startTimeLabel, whatTimeLabel, myStudyRoom_Reservation);
			btns.add(timeSelectBtn);
			timeSelectBtn.setTime(time.plusMinutes(i * 15));
			add(timeSelectBtn);

			btnReset();

			// 타임테이블 버튼을 눌렀을 때
			timeSelectBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					paymentBtn.setEnabled(true);
					int btnNum = btns.indexOf(e.getSource());

					for (int i = 0; i < btns.size(); ++i) {

						TimeSelectButton selectBtn = btns.get(i);
						if (!reserved[i]) {
							if (selectBtn.getTime().compareTo(LocalTime.now()) <= 0 && dateLabel.getSelectDay().equals(nowDate) 
									|| selectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
								selectBtn.setBackground(GRAY);
								selectBtn.setEnabled(false);
							} else {
								selectBtn.setBackground(LIGHTGRAY);
							}

							if (i > btnNum && i <= btnNum + 3) {
								selectBtn.setBackground(ORANGE);
							} else if (whatTimeLabel.getText().equals("2") && 
									i > btnNum && i <= btnNum + 7) {
								selectBtn.setBackground(ORANGE);
							} else if (btnNum != i) {
								if (selectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
									selectBtn.setEnabled(false);
									selectBtn.setBackground(GRAY);
								}
							}
						}
					}
				}
			});
		}
		// 예약된 정보들 가져오기
		getReservationInfo(btnQty);

		// 스터디룸 넘기기(왼쪽)
		topLeftBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentBtn.setEnabled(false);
				btnReset();
				getReservationInfo(btnQty);

			}
		});
		// 스터디룸 넘기기(오른쪽)
		topRightBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentBtn.setEnabled(false);
				btnReset();
				getReservationInfo(btnQty);

			}
		});
		// 날짜 넘기기(왼쪽)
		BottomLeftBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentBtn.setEnabled(false);
				btnReset();
				getReservationInfo(btnQty);
			}
		});
		// 날짜 넘기기(오른쪽)
		BottomRightBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentBtn.setEnabled(false);
				btnReset();
				getReservationInfo(btnQty);

			}
		});

		// 시간 늘리기
		upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnQty = 8;
				btnReset();
				getReservationInfo(btnQty);
				paymentBtn.setEnabled(false);
			}
		});

		// 시간 줄이기
		downBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnQty = 4;
				btnReset();
				getReservationInfo(btnQty);
				paymentBtn.setEnabled(false);
			}
		});

		setBounds(681, 90, 473, 450);
		setBackground(new Color(0x494344));
		setLayout(grid);
	}

	// 예약된 정보들을 가져와 버튼에 색을 지정하는 메서드
	public void getReservationInfo(int btnNum) {
		LocalDate labelDate = dateLabel.getSelectDay();
		String studyroom_id = myStudyRoom_Reservation.getStudyRoom_id(); 
		List<StudyRoom_Reservation> studyRoom_AllReservation = StudyRoomDAO.getAllReservations(labelDate, studyroom_id);

		for (StudyRoom_Reservation studyRoom_reserv : studyRoom_AllReservation) {
			for(TimeSelectButton timeSelectBtn : btns) {
				LocalTime selectTime = timeSelectBtn.getTime();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime start = LocalTime.parse(studyRoom_reserv.getStudyRoom_start_time(), formatter);
				LocalTime end = LocalTime.parse(studyRoom_reserv.getStudyRoom_end_time(), formatter);

				if (start.compareTo(selectTime) <= 0 && 
						end.compareTo(selectTime) > 0) {
					for(int i = btns.indexOf(timeSelectBtn) - (btnNum - 1); i < btns.indexOf(timeSelectBtn) && btns.indexOf(timeSelectBtn) - (btnNum - 1) >= 0; i++) {
						btns.get(i).setEnabled(false);
					}
					if (selectTime.compareTo(startTimeLabel.getTime()) <= 0 &&
							labelDate.equals(nowDate)) {
						timeSelectBtn.setBackground(GRAY);
					} else {
						if (myStudyRoom_Reservation.getMember_id().equals(studyRoom_reserv.getMember_id())) {
							timeSelectBtn.setBackground(LEMON);
						} else {
							timeSelectBtn.setBackground(GRAY);
						}
					}
					timeSelectBtn.setEnabled(false);
					reserved[btns.indexOf(timeSelectBtn)] = true;
				}            
			}
		}
	}

	/** 비활성화 리셋 */
	public void btnReset() {
		for(TimeSelectButton btn : btns) {
			System.out.println(btns.indexOf(btn));
			reserved[btns.indexOf(btn)] = false;
			if(btn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
				btn.setBackground(GRAY);
				btn.setEnabled(false);
			} else {
				if (btn.getTime().compareTo(LocalTime.now()) <= 0 && dateLabel.getSelectDay().equals(nowDate) 
						|| btn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
					btn.setBackground(GRAY);
					btn.setEnabled(false);
				} else {
					btn.setBackground(LIGHTGRAY);
					btn.setEnabled(true);
				}
			}
		}
	}
}