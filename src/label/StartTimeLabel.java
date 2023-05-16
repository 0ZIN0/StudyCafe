package label;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

import dto.StudyRoom_Reservation;
import panel.StudyRoomPanel;

public class StartTimeLabel extends JLabel {

	LocalTime now = LocalTime.now();
	LocalTime end;
	public StartTimeLabel(StudyRoom_Reservation myStudyRoom_Reservation) {

		int minute = now.getMinute();

		if (minute > 0 && minute <= 15) {
			now = LocalTime.of(now.getHour(), 15);
		} else if (minute > 15 && minute <= 30) {
			now = LocalTime.of(now.getHour(), 30);
		} else if (minute > 30 && minute <= 45) {
			now = LocalTime.of(now.getHour(), 45);
		} else if (minute > 45 && minute <= 59) {
			if (now.getHour() != 23) {
				now = LocalTime.of(now.getHour() + 1, 0);
			} else {
				now = LocalTime.of(0, 0);
			}
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String startTime = now.format(formatter);
		
		setText(startTime);
		myStudyRoom_Reservation.setStudyRoom_start_time(startTime);
		
		
		String endTime = myStudyRoom_Reservation.getStudyRoom_start_time();
		end = LocalTime.parse(endTime, formatter);
		endTime = end.plusHours(1).format(formatter);
		
		
		myStudyRoom_Reservation.setStudyRoom_end_time(endTime);
		
		end = end.plusHours(1);
		
		setForeground(Color.white);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		setBounds(330, 267, 100, 35);
	}
	
	public LocalTime getDefaultEndTime() {
		return end; 
	}
	
	public LocalTime getTime() {
		return now;
	}
}
