package dto;

import java.util.Date;

public class Member {
	private String member_id;
	private String phone_number;
	private Integer member_password;
	private Date date_of_birth;
	private Integer remain_time;
	private Date remain_date;
	private String locker_number;
	private Integer locker_password;
	
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
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
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
}
