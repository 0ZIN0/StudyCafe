package dto;

import java.util.Date;

public class UsingSeat {
	
	int seat_id;
	int useTime;
	String seat_state;
	int remainTime;
	
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	
	public int getUseTime() {
		return useTime;
	}
	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}
	public String getSeat_state() {
		return seat_state;
	}
	public void setSeat_state(String seat_state) {
		this.seat_state = seat_state;
	}
	public int getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
}
