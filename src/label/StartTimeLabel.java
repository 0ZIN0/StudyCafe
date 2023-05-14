package label;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class StartTimeLabel extends JLabel {

	LocalTime now = LocalTime.now();
	
	public StartTimeLabel() {

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
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm");
		String time = now.format(formatter);
		
		setText(time);
		setForeground(Color.white);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		setBounds(330, 267, 100, 35);
	}
	
	public LocalTime getTime() {
		return now;
	}
}
