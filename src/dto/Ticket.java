package dto;

public class Ticket {
	private String ticket_id;
	private String ticket_category;
	private String ticket_name;
	private Integer ticket_price;
	private Integer ticket_value;
	private Integer ticket_usable_time;
	
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getTicket_category() {
		return ticket_category;
	}
	public void setTicket_category(String ticket_category) {
		this.ticket_category = ticket_category;
	}
	public String getTicket_name() {
		return ticket_name;
	}
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}
	public Integer getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(Integer ticket_price) {
		this.ticket_price = ticket_price;
	}
	public Integer getTicket_value() {
		return ticket_value;
	}
	public void setTicket_value(Integer ticket_value) {
		this.ticket_value = ticket_value;
	}
	public Integer getTicket_usable_time() {
		return ticket_usable_time;
	}
	public void setTicket_usable_time(Integer ticket_usable_time) {
		this.ticket_usable_time = ticket_usable_time;
	}
}
