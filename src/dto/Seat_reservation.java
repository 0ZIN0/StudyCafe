package dto;

public class Seat_reservation {
	
	private String seat_reservation_id;
	private Integer seat_id;
	private String member_id;
	private String use_ticket_category;
	private String seat_reservation_start_time;
	private String seat_reservation_end_time;
	
	public String getSeat_reservation_id() {
		return seat_reservation_id;
	}
	public void setSeat_reservation_id(String seat_reservation_id) {
		this.seat_reservation_id = seat_reservation_id;
	}
	public Integer getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(Integer seat_id) {
		this.seat_id = seat_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getUse_ticket_category() {
		return use_ticket_category;
	}
	public void setUse_ticket_category(String use_ticket_category) {
		this.use_ticket_category = use_ticket_category;
	}
	public String getSeat_reservation_start_time() {
		return seat_reservation_start_time;
	}
	public void setSeat_reservation_start_time(String seat_reservation_start_time) {
		this.seat_reservation_start_time = seat_reservation_start_time;
	}
	public String getSeat_reservation_end_time() {
		return seat_reservation_end_time;
	}
	public void setSeat_reservation_end_time(String seat_reservation_end_time) {
		this.seat_reservation_end_time = seat_reservation_end_time;
	}
}
