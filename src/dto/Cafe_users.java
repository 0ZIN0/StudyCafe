package dto;

import java.util.Date;

public class Cafe_users {
	
	private Integer user_id;
	private String full_name;
	private Integer pass_word;
	private Date date_of_birth;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public Integer getPass_word() {
		return pass_word;
	}
	public void setPass_word(Integer pass_word) {
		this.pass_word = pass_word;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
}
