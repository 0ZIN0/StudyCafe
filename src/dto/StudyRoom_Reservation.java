package dto;

import java.util.Date;

public class StudyRoom_Reservation {
	
	private String studyRoom_reservation_id;
	private String studyRoom_id;
	private String member_id;
	private Date studyRoom_reservation_date;
	private String studyRoom_start_time;
	private String studyRoom_end_time;
	private String studyRoom_start_dateTime;
	private String studyRoom_end_dateTime;
	
	public String getStudyRoom_reservation_id() {
		return studyRoom_reservation_id;
	}
	public void setStudyRoom_reservation_id(String studyRoom_reservation_id) {
		this.studyRoom_reservation_id = studyRoom_reservation_id;
	}
	public String getStudyRoom_id() {
		return studyRoom_id;
	}
	public void setStudyRoom_id(String studyRoom_id) {
		this.studyRoom_id = studyRoom_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getStudyRoom_reservation_date() {
		return studyRoom_reservation_date;
	}
	public void setStudyRoom_reservation_date(Date studyRoom_reservation_date) {
		this.studyRoom_reservation_date = studyRoom_reservation_date;
	}
	public String getStudyRoom_start_time() {
		return studyRoom_start_time;
	}
	public void setStudyRoom_start_time(String studyRoom_start_time) {
		this.studyRoom_start_time = studyRoom_start_time;
	}
	public String getStudyRoom_end_time() {
		return studyRoom_end_time;
	}
	public void setStudyRoom_end_time(String studyRoom_end_time) {
		this.studyRoom_end_time = studyRoom_end_time;
	}
	public String getStudyRoom_start_dateTime() {
		return studyRoom_start_dateTime;
	}
	public void setStudyRoom_start_dateTime(String studyRoom_start_dateTime) {
		this.studyRoom_start_dateTime = studyRoom_start_dateTime;
	}
	public String getStudyRoom_end_dateTime() {
		return studyRoom_end_dateTime;
	}
	public void setStudyRoom_end_dateTime(String studyRoom_end_dateTime) {
		this.studyRoom_end_dateTime = studyRoom_end_dateTime;
	}
	
}
