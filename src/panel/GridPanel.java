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
import dto.StudyRoom_Reservation;
import label.StartTimeLabel;

public class GridPanel extends JPanel {

	LocalDate selectDate = LocalDate.now();
	LocalTime time = LocalTime.of(0, 0); // timeSelectBtn에 넣을 시간의 default값
	
	TimeSelectButton timeSelectBtn;
	List<TimeSelectButton> btns = new ArrayList<>();
	List<StudyRoom_Reservation> studyRoom_AllReservation = new ArrayList<>();

	public GridPanel(JButton upBtn, JButton downBtn, StartTimeLabel startTimeLabel, 
			List<StudyRoom_Reservation> studyRoom_AllReservation, JLabel whatTimeLabel) {
		this.studyRoom_AllReservation = studyRoom_AllReservation;

		GridLayout grid = new GridLayout(12, 8);

		grid.setHgap(3);
		grid.setVgap(3);

		for (int i = 0; i < 96; ++i) {
			timeSelectBtn = new TimeSelectButton(upBtn, downBtn, startTimeLabel, whatTimeLabel);
			btns.add(timeSelectBtn);
			timeSelectBtn.setTime(time.plusMinutes(i * 15));

			if (startTimeLabel.getTime().equals(timeSelectBtn.getTime())) {
				timeSelectBtn.setBackground(new Color(0xFF5C01));

			}

			if (startTimeLabel.getTime().compareTo(timeSelectBtn.getTime()) < 0 && 
					startTimeLabel.getDefaultEndTime().compareTo(timeSelectBtn.getTime()) > 0) {
				timeSelectBtn.setBackground(new Color(0xFF5C01));
			}

			if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
				timeSelectBtn.setEnabled(false);
				timeSelectBtn.setBackground(new Color(0x8D8787));
			}

			timeSelectBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < btns.size(); ++i) {

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
			});


			add(timeSelectBtn);
		}
		
		upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				
				LocalTime start = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_date(), formatter);
				LocalTime end = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_end_date(), formatter);
				
				for (TimeSelectButton timeSelectBtn : btns) {
					if (start.compareTo(timeSelectBtn.getTime()) < 0 && 
							end.compareTo(timeSelectBtn.getTime()) > 0) {
						timeSelectBtn.setBackground(new Color(0xFF5C01));
					}
				}
			}
		});
		
		downBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				
				LocalTime start = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_date(), formatter);
				LocalTime end = LocalTime.parse(StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_end_date(), formatter);
				
				for (TimeSelectButton timeSelectBtn : btns) {
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
		});

		setBounds(681, 90, 473, 450);
		setBackground(new Color(0x494344));
		setLayout(grid);
	}

	public List<StudyRoom_Reservation> getStudyRoom_Reservation() {
		return studyRoom_AllReservation;
	}
}
