package dto;

import java.util.Date;

public class Member {
	private String member_id;
	private String phone_number;
	private Integer member_password;
	private Integer remain_time;
	private Date remain_date;
	private String locker_number;
	private Integer locker_password;
	private Date locker_remain;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Integer getMember_password() {
		return member_password;
	}
	public void setMember_password(Integer member_password) {
		this.member_password = member_password;
	}
	public Integer getRemain_time() {
		return remain_time;
	}
	public void setRemain_time(Integer remain_time) {
		this.remain_time = remain_time;
	}
	public Date getRemain_date() {
		return remain_date;
	}
	public void setRemain_date(Date remain_date) {
		this.remain_date = remain_date;
	}
	public String getLocker_number() {
		return locker_number;
	}
	public void setLocker_number(String locker_number) {
		this.locker_number = locker_number;
	}
	public Integer getLocker_password() {
		return locker_password;
	}
	public void setLocker_password(Integer locker_password) {
		this.locker_password = locker_password;
	}
	public Date getLocker_remain() {
		return locker_remain;
	}
	public void setLocker_remain(Date locker_remain) {
		this.locker_remain = locker_remain;
	}
	
	
}
