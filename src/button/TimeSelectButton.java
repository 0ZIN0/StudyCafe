package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;

import dto.StudyRoom_Reservation;
import label.StartTimeLabel;
import panel.StudyRoomPanel;

public class TimeSelectButton extends JButton {

	LocalTime time;
	StudyRoom_Reservation myStudyRoom_Reservation;
	
	public TimeSelectButton(JButton upBtn, JButton downBtn, StartTimeLabel startTimeLabel, JLabel whatTimeLabel) {
		
		setBorderPainted(false);

//		upBtn.setEnabled(false);
//		downBtn.setEnabled(false);
		
		setBackground(new Color(0xD9D9D9));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upBtn.setEnabled(true);
				downBtn.setEnabled(true);
				setBackground(new Color(0xFF5C01));
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				
				String startTime = time.format(formatter);
				StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_start_date(startTime);
				
				String endTime = StudyRoomPanel.myStudyRoom_Reservation.getStudyRoom_start_date();
				LocalTime endLocalTime = LocalTime.parse(endTime, formatter);

				startTimeLabel.setText(startTime);
				
				if (whatTimeLabel.getText().equals("1")) {
					endTime = endLocalTime.plusHours(1).format(formatter);
				} else {
					endTime = endLocalTime.plusHours(2).format(formatter);
				}
				StudyRoomPanel.myStudyRoom_Reservation.setStudyRoom_end_date(endTime);
			}
		});

	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public LocalTime getTime() {
		return time;
	}
}
