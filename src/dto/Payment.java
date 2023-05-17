package dto;

import java.util.Date;

public class Payment {

	private String pay_id;
	private String pay_type;
	private Date pay_date;
	private Integer pay_money;
	private String pay_state;
	
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public Integer getPay_money() {
		return pay_money;
	}
	public void setPay_money(Integer pay_money) {
		this.pay_money = pay_money;
	}
	public String getPay_state() {
		return pay_state;
	}
	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}
}
