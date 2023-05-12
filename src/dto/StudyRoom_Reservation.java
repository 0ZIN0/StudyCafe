package dto;

import java.util.Date;

public class StudyRoom_Reservation {
	
	private String studyRoom_reservation_id;
	private String studyRoom_id;
	private String member_id;
	private Date studyRoom_reservation_date;
	private String studyRoom_start_date;
	private String studyRoom_end_date;
	
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
	public String getStudyRoom_start_date() {
		return studyRoom_start_date;
	}
	public void setStudyRoom_start_date(String studyRoom_start_date) {
		this.studyRoom_start_date = studyRoom_start_date;
	}
	public String getStudyRoom_end_date() {
		return studyRoom_end_date;
	}
	public void setStudyRoom_end_date(String studyRoom_end_date) {
		this.studyRoom_end_date = studyRoom_end_date;
	}
}
