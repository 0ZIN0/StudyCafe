package thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class TimeRun implements Runnable {
	
	JLabel timeLabel;
	
	public TimeRun(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}
	@Override
	public void run() {
	    while(true) {
	    	LocalDateTime now = LocalDateTime.now();
	    	String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
	    	try {
	    		Thread.sleep(100);
	    		timeLabel.setText(formatedNow);
	    	} catch (Exception e) {
	    	}
	    }
	}
}
