package dto;

import java.util.Date;

public class Ticket_order {
	
	
	
	private String order_id;
	private String member_id;
	private String ticket_id;
	private String pay_id;
	private Integer order_total_price;
	private Date order_date;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
//	public Integer getOrder_total_price() {
//		return order_total_price;
//	}
	
//	public Integer getOrder_total_price() {
//	    if (order_total_price == null) {
//	        return 0; // 기본 값으로 0을 반환하거나 원하는 값을 반환합니다.
//	    }
//	    return order_total_price;
//	}
//	public void setOrder_total_price(Integer order_total_price) {
//		this.order_total_price = order_total_price;
//	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
	

}
