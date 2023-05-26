package dto;

import java.util.Timer;
import java.util.TimerTask;

import panel.VacatedMiniPanel;

public class Seat {
	
	String seat_id = "0번";
	String seat_category;
	String seat_state;
	String seat_usable;
	Integer remain_time = 0;
	
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	public String getSeat_category() {
		return seat_category;
	}
	public void setSeat_category(String seat_category) {
		this.seat_category = seat_category;
	}
	public String getSeat_state() {
		return seat_state;
	}
	public void setSeat_state(String seat_state) {
		this.seat_state = seat_state;
	}
	public String getSeat_usable() {
		return seat_usable;
	}
	public void setSeat_usable(String seat_usable) {
		this.seat_usable = seat_usable;
	}
	public Integer getRemain_time() {
		return remain_time;
	}
	public void setRemain_time(Integer remain_time) {
		this.remain_time = remain_time;
	}
	
	public void checkIn(int remain_time) {
		setRemain_time(remain_time);
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println(getRemain_time());
				if(getRemain_time() > 0) {
					setRemain_time(getRemain_time() - 1);
				}
				else if(getRemain_time() == 0) {
					timer.cancel();
				}
			}
		};
		timer.schedule(timerTask, 5000, 6000);
	}
}
