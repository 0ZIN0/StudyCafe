package label;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JLabel;

public class DateLabel extends JLabel {
	
	LocalDate selectDay = LocalDate.now();
	
	public DateLabel() {

		String date = selectDay.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
		setText(date);
		setForeground(Color.white);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
	}
	
	public LocalDate getSelectDay() {
		return selectDay;
	}
	
	public void setSelectDay(LocalDate selectDay) {
		this.selectDay = selectDay;
		setText(selectDay.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
	}
	
	@Override
	public String toString() {
		return selectDay.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
	}
}
