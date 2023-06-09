package panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.TimeSelectButton;
import dao.StudyRoomDAO;
import dto.StudyRoom;
import dto.StudyRoom_Reservation;
import label.DateLabel;
import label.StartTimeLabel;

public class GridPanel_Fix extends JPanel {

	final static Color ORANGE = new Color(0xFF5C01);
	final static Color GRAY = new Color(0x8D8787);
	final static Color LIGHTGRAY = new Color(0xD9D9D9);
	DateLabel dateLabel;
	 // 라벨의 날짜
	StudyRoom_Reservation myStudyRoom_Reservation = new StudyRoom_Reservation();
	
	
	LocalDate selectDate = LocalDate.now();
	LocalTime time = LocalTime.of(0, 0); // timeSelectBtn에 넣을 시간의 default값

	TimeSelectButton timeSelectBtn;
	List<TimeSelectButton> btns = new ArrayList<>();
	int btnQty = 4;
	
	boolean[] reserved = new boolean[96]; 
	boolean[] selected = new boolean[96]; 
	boolean disable = false;

	public GridPanel_Fix(JButton upBtn, JButton downBtn, 
			JButton topLeftBtn, JButton topRightBtn,
			JButton BottomLeftBtn, JButton BottomRightBtn,
			StartTimeLabel startTimeLabel, 
			JLabel whatTimeLabel,StudyRoom_Reservation myStudyRoom_Reservation, 
			JButton paymentBtn, DateLabel dateLabel) {
		this.myStudyRoom_Reservation = myStudyRoom_Reservation;
		this.dateLabel = dateLabel;
		GridLayout grid = new GridLayout(12, 8);
		
		myStudyRoom_Reservation.setStudyRoom_id("SI-1");
		
		grid.setHgap(3);
		grid.setVgap(3);
		paymentBtn.setEnabled(false);
		
		for (int i = 0; i < 96; ++i) {
			
			timeSelectBtn = new TimeSelectButton(upBtn, downBtn, startTimeLabel, whatTimeLabel, myStudyRoom_Reservation);
			btns.add(timeSelectBtn);
			timeSelectBtn.setTime(time.plusMinutes(i * 15));
			add(timeSelectBtn);

			// 22시 이후 버튼들 비활성화
			if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
				timeSelectBtn.setEnabled(false);
				timeSelectBtn.setBackground(GRAY);
				
			}

			// 현재 시간 이전에는 다 비활성화 시키기
			if (LocalTime.now().compareTo(timeSelectBtn.getTime()) >= 0) {
				timeSelectBtn.setBackground(GRAY);
				timeSelectBtn.setEnabled(false);
				reserved[i] = true;
			}

			// 타임테이블 버튼을 눌렀을 때
			timeSelectBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					paymentBtn.setEnabled(true);
					int btnNum = btns.indexOf(e.getSource());

					for (int i = 0; i < btns.size(); ++i) {
						
						TimeSelectButton selectBtn = btns.get(i);
						if (!reserved[i]) {
							if ( i > btnNum && i <= btnNum + 3) {
								selectBtn.setBackground(ORANGE);
							} else if (whatTimeLabel.getText().equals("2") && 
									i > btnNum && i <= btnNum + 7) {
								selectBtn.setBackground(ORANGE);
							} else if (btnNum != i) {
								selectBtn.setBackground(LIGHTGRAY);
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
		
		topLeftBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnReset();
				getReservationInfo(btnQty);
				
			}
		});
		
		topRightBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnReset();
				getReservationInfo(btnQty);
				
			}
		});
		 BottomLeftBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnReset();
				getReservationInfo(btnQty);

			}
		});
		 BottomRightBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnReset();
				getReservationInfo(btnQty);

			}
		});

		upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnQty = 8;
				for(TimeSelectButton timeSelectBtn : btns) {
					if (!reserved[btns.indexOf(timeSelectBtn)] && timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) <= 0) {
						timeSelectBtn.setBackground(LIGHTGRAY);
						paymentBtn.setEnabled(false);
					} else if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
						timeSelectBtn.setBackground(GRAY);
						paymentBtn.setEnabled(false);
					}
				}
				getReservationInfo(btnQty);
			}
		});

		downBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnQty = 4;
				btnReset();

				for(TimeSelectButton timeSelectBtn : btns) {
					if (!reserved[btns.indexOf(timeSelectBtn)] && timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) <= 0) {
						timeSelectBtn.setBackground(LIGHTGRAY);
						paymentBtn.setEnabled(false);
					} else if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
						timeSelectBtn.setBackground(GRAY);
						paymentBtn.setEnabled(false);
					}
				}
				getReservationInfo(btnQty);
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
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime start = LocalTime.parse(studyRoom_reserv.getStudyRoom_start_time(), formatter);
				LocalTime end = LocalTime.parse(studyRoom_reserv.getStudyRoom_end_time(), formatter);

				if (start.compareTo(timeSelectBtn.getTime()) <= 0 && 
						end.compareTo(timeSelectBtn.getTime()) > 0) {

					for(int i = btns.indexOf(timeSelectBtn) - (btnNum - 1); i < btns.indexOf(timeSelectBtn); i++) {
						btns.get(i).setEnabled(false);
					}
					timeSelectBtn.setEnabled(false);
					timeSelectBtn.setBackground(GRAY);
					reserved[btns.indexOf(timeSelectBtn)] = true;
				}				
			}
		}
	}

	/** 비활성화 리셋 */
	public void btnReset() {
		for(TimeSelectButton btn : btns) {
			if(!(btn.getTime().compareTo(LocalTime.now()) <= 0) &&
					btn.getTime().compareTo(LocalTime.of(22, 00)) < 0) {
				reserved[btns.indexOf(btn)] = false;
				btn.setBackground(LIGHTGRAY);
				btn.setEnabled(true);
			}
		}
	}
	
	/* 선택된 버튼 리셋 */
	public void selectReset() {
		
	}
}
