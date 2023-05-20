package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.StudyRoom_Reservation;

public class StudyRoomDAO {
	
	/* 스터디룸을 제한해뒀는지 아닌지에 대한 사용가능 유무 확인 메서드 */
	public static boolean isUseStudyRoom(String studyRoom_id) {
		String query = "SELECT studyroom_state FROM studyroom WHERE studyroom_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				
				pstmt.setString(1, studyRoom_id);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				rs.next();
				if (rs.getString("studyroom_state").equals("사용가능")) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/* 유저가 선택한 정보들로 예약하기 */
	public static boolean setReservation(StudyRoom_Reservation studyRoom_Reservation) {
		
		String query = "INSERT INTO STUDYROOM_RESERVATION VALUSE(('SR-'|| studyroom_reservation_id_seq.nextval), ?, ?, TO_DATE(?, 'yyyy.mm.dd'), ?, ?)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			pstmt.setString(1, studyRoom_Reservation.getStudyRoom_id());	
			pstmt.setString(2, studyRoom_Reservation.getMember_id());	
			pstmt.setString(3, studyRoom_Reservation.getStudyRoom_reservation_date().toString());	
			pstmt.setString(4, studyRoom_Reservation.getStudyRoom_start_time());	
			pstmt.setString(5, studyRoom_Reservation.getStudyRoom_end_time());	
				
			pstmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* 유저가 예약한 것들을 알려주는 메서드 */
	public static List<StudyRoom_Reservation> getMyReservation(String member_id) {
		
		StudyRoom_Reservation mr = new StudyRoom_Reservation();
		List<StudyRoom_Reservation> myReservations = new ArrayList<>();
		
		String query = "SELECT * FROM STUDYROOM_RESERVATION WHERE MEMBER_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			
			pstmt.setString(1, member_id);
			
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while (rs.next()) {
					
					Date date = rs.getDate("studyroom_reservation_date");
					mr.setStudyRoom_reservation_date(date);
					mr.setStudyRoom_reservation_id(rs.getString("studyroom_reservation_id"));
					mr.setStudyRoom_id(rs.getString("studyroom_id"));
					mr.setMember_id(rs.getString("member_id"));
					mr.setStudyRoom_start_time(rs.getString("study_room_start_time"));
					mr.setStudyRoom_end_time(rs.getString("study_room_end_time"));
					
					myReservations.add(mr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return myReservations;
	}
	
	/* 유저 제외 다른사람들이 예약한 것들을 알려주는 메서드 */
	public static List<StudyRoom_Reservation> getOtherReservation(String member_id) {
		
		StudyRoom_Reservation mr = new StudyRoom_Reservation();
		List<StudyRoom_Reservation> otherReservations = new ArrayList<>();
		
		String query = "SELECT * FROM STUDYROOM_RESERVATION WHERE MEMBER_ID!=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			
			pstmt.setString(1, member_id);
			
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while (rs.next()) {
					
					Date date = rs.getDate("studyroom_reservation_date");
					mr.setStudyRoom_reservation_date(date);
					mr.setStudyRoom_reservation_id(rs.getString("studyroom_reservation_id"));
					mr.setStudyRoom_id(rs.getString("studyroom_id"));
					mr.setMember_id(rs.getString("member_id"));
					mr.setStudyRoom_start_time(rs.getString("study_room_start_time"));
					mr.setStudyRoom_end_time(rs.getString("study_room_end_time"));
					
					otherReservations.add(mr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return otherReservations;
	}
	
	
	/* 유저가 날짜를 던져주면 예약한 시간대를 확인하는 메서드 */
	public static List<StudyRoom_Reservation> getAllReservations(LocalDate date, String studyroom_id) {
		
		List<StudyRoom_Reservation> reservations = new ArrayList<>();
		
		
		String query = "SELECT STUDYROOM_RESERVATION_ID, STUDYROOM_ID, MEMBER_ID, \r\n"
				+ "TRUNC(STUDYROOM_START_TIME) AS RESERVATION_DATE, TO_CHAR(STUDYROOM_START_TIME, 'HH24:MI') AS START_TIME, \r\n"
				+ "TO_CHAR(STUDYROOM_END_TIME, 'HH24:MI') AS END_TIME\r\n"
				+ "FROM STUDYROOM_RESERVATION\r\n"
				+ "WHERE TRUNC(STUDYROOM_START_TIME)=TO_DATE(?, 'YY/MM/DD') AND STUDYROOM_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.setString(1, date.toString());
				pstmt.setString(2, studyroom_id);
			
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				
				while (rs.next()) {
					
					StudyRoom_Reservation rv = new StudyRoom_Reservation();
					Date getDate = rs.getDate("RESERVATION_DATE");
					rv.setStudyRoom_reservation_date(getDate);
					rv.setStudyRoom_reservation_id(rs.getString("studyroom_reservation_id"));
					rv.setStudyRoom_id(rs.getString("studyroom_id"));
					rv.setMember_id(rs.getString("member_id"));
					rv.setStudyRoom_start_time(rs.getString("START_TIME"));
					rv.setStudyRoom_end_time(rs.getString("END_TIME"));
					
					reservations.add(rv);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}
}
