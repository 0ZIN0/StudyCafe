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
import dto.StudyRoom_Reservation;
import label.StartTimeLabel;

public class GridPanel extends JPanel {

	LocalDate selectDate = LocalDate.now();
	LocalTime time = LocalTime.of(0, 0); // timeSelectBtn에 넣을 시간의 default값

	TimeSelectButton timeSelectBtn;
	List<TimeSelectButton> btns = new ArrayList<>();
	List<StudyRoom_Reservation> studyRoom_AllReservation = new ArrayList<>();
	boolean[] enabled = new boolean[96]; 

	public GridPanel(JButton upBtn, JButton downBtn, StartTimeLabel startTimeLabel, 
			List<StudyRoom_Reservation> studyRoom_AllReservation, JLabel whatTimeLabel) {
		this.studyRoom_AllReservation = studyRoom_AllReservation;

		System.out.println(studyRoom_AllReservation);

		GridLayout grid = new GridLayout(12, 8);

		grid.setHgap(3);
		grid.setVgap(3);
		
		
		for (int i = 0; i < 96; ++i) {
			
			timeSelectBtn = new TimeSelectButton(upBtn, downBtn, startTimeLabel, whatTimeLabel);
			btns.add(timeSelectBtn);
			add(timeSelectBtn);
			
			
			
			timeSelectBtn.setTime(time.plusMinutes(i * 15));
			

			// 예약된 정보들 가져오기
			for (StudyRoom_Reservation studyRoom_reserv : studyRoom_AllReservation) {
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime start = LocalTime.parse(studyRoom_reserv.getStudyRoom_start_time(), formatter);
				LocalTime end = LocalTime.parse(studyRoom_reserv.getStudyRoom_end_time(), formatter);
				
				
				if (start.compareTo(timeSelectBtn.getTime()) <= 0 && 
						end.compareTo(timeSelectBtn.getTime()) > 0) {
					timeSelectBtn.setBackground(new Color(0x8D8787));
					timeSelectBtn.setEnabled(false);
					
				}
				
			}
			
//			// 버튼을 눌렀을때 색 변경 빨갱이로
//			if (startTimeLabel.getTime().equals(timeSelectBtn.getTime())) { 
//				timeSelectBtn.setBackground(new Color(0xFF5C01));
//				
//			}

			// 22시 이후 버튼들 비활성화
			if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
				timeSelectBtn.setEnabled(false);
				enabled[i] = true;
				timeSelectBtn.setBackground(new Color(0x8D8787));
			}
			
			// start타임과 end타임을 가져와 칸에 맞게 색 변경
			if (startTimeLabel.getTime().compareTo(timeSelectBtn.getTime()) <= 0 && 
					startTimeLabel.getDefaultEndTime().compareTo(timeSelectBtn.getTime()) > 0) {
				timeSelectBtn.setBackground(new Color(0xFF5C01));
			}
			
			
			
			timeSelectBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {


					for (int i = 0; i < btns.size(); ++i) {
						if (!enabled[i]) {
							if (i > btns.indexOf(e.getSource()) && i <= btns.indexOf(e.getSource()) + 3) {
								btns.get(i).setBackground(new Color(0xFF5C01));
							} else if (whatTimeLabel.getText().equals("2") && 
									i > btns.indexOf(e.getSource()) && i <= btns.indexOf(e.getSource()) + 7) {
								btns.get(i).setBackground(new Color(0xFF5C01));
							} else if (btns.indexOf(e.getSource()) != i) {
								btns.get(i).setBackground(new Color(0xD9D9D9));
								if (btns.get(i).getTime().compareTo(LocalTime.of(22, 00)) > 0) {
									btns.get(i).setEnabled(false);
									btns.get(i).setBackground(new Color(0x8D8787));
								}
							}
						}
					}
				}
			});
		}
		
		// 다른 예약된 시간 앞이 선택되면 안되는 버튼을 막아둠
		for (int cnt = 0 ; cnt < 96; ++cnt) {
			
			int count = 0;
			
			for (int j = cnt; j < cnt + 4; ++j) {
				if (j == 96) {
					break;
				}
				if (!enabled[j]) {
					++count;
				}
			}
			if (count != 4 && !enabled[cnt]) {
				btns.get(cnt).setEnabled(false);
				btns.get(cnt).setBackground(new Color(0xD9D9D9));
			}
			
		}
		
		upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

				LocalTime start = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_time(), formatter);
				LocalTime end = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_end_time(), formatter);

				for (TimeSelectButton timeSelectBtn : btns) {
					if (!enabled[btns.indexOf(timeSelectBtn)]) {

						if (start.compareTo(timeSelectBtn.getTime()) <= 0 && 
								end.compareTo(timeSelectBtn.getTime()) > 0) {
							timeSelectBtn.setBackground(new Color(0xFF5C01));
						}
						
						if (start.equals(LocalTime.of(22, 00)) && start.compareTo(timeSelectBtn.getTime()) <= 0 && 
								LocalTime.of(23, 45).compareTo(timeSelectBtn.getTime()) >= 0) {
							timeSelectBtn.setBackground(new Color(0xFF5C01));
						}
					}
				}
			}
		});

		downBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

				LocalTime start = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_time(), formatter);
				LocalTime end = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_end_time(), formatter);

				for (TimeSelectButton timeSelectBtn : btns) {
					if (!enabled[btns.indexOf(timeSelectBtn)]) {

						if (start.compareTo(timeSelectBtn.getTime()) <= 0 && 
								end.compareTo(timeSelectBtn.getTime()) > 0) {
							timeSelectBtn.setBackground(new Color(0xFF5C01));
						} else if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
							timeSelectBtn.setEnabled(false);
							timeSelectBtn.setBackground(new Color(0x8D8787));
						} else {
							timeSelectBtn.setBackground(new Color(0xD9D9D9));
						}
					}
				}
			}
		});

		setBounds(681, 90, 473, 450);
		setBackground(new Color(0x494344));
		setLayout(grid);
	}
}
