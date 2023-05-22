package dto;

import java.util.Date;

public class CheckRemaintime {
	
	String seat_reservation_id;
	Integer seat_id;
	String member_id;
	String using_ticket;
	Integer remainTime;
	
	public String getSeat_reservation_id() {
		return seat_reservation_id;
	}
	
	public void setSeat_reservation_id(String seat_reservation_id) {
		this.seat_reservation_id = seat_reservation_id;
	}
	
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public String getusing_ticket() {
		return using_ticket;
	}
	public void setusing_ticket(String using_ticket) {
		this.using_ticket = using_ticket;
	}
	
	public int getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
}
