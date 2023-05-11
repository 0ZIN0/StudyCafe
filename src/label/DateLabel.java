package label;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JLabel;

public class DateLabel extends JLabel {
	
	Calendar selectDay = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
	
	public DateLabel() {
		setText(sdf.format(selectDay.getTime()));
		setForeground(Color.white);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
	}
	
	public Calendar getSelectDay() {
		return selectDay;
	}
	
	public void setSelectDay(Calendar selectDay) {
		this.selectDay = selectDay;
		setText(sdf.format(selectDay.getTime()));
	}
}
