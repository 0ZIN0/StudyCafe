package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbConnection.OjdbcConnection;
import frame.MainFrame;

public class MypageDAO {
	
	/** 입실 시간  */
	public static String checkInTime() {
		String query = "select TO_CHAR(seat_reservation_start_time, 'YYYY\"년\"MM\"월\"DD\"일\" HH24:mi:ss')AS STARTTIME \r\n"
				+ "From seat_reservation\r\n"
				+ "Where member_id = ?\r\n"
				+ "And seat_reservation_end_time Is Null";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.setString(1, MainFrame.member.getMember_id());
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				if(rs.next()) {
					return rs.getString("STARTTIME");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 상품명 */
	public static String isUseTicket() {
		String query = "SELECT USE_TICKET_CATEGORY FROM SEAT_RESERVATION\r\n"
				+ "WHERE SEAT_RESERVATION_END_TIME IS NULL\r\n"
				+ "AND MEMBER_ID = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.setString(1, MainFrame.member.getMember_id());
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				if(rs.next()) {
					return rs.getString("USE_TICKET_CATEGORY");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 잔여기간  */
	
	public static String getRemainPeriod() {
		String query = "SELECT TO_DATE(REMAIN_DATE, 'YYYY-MM-DD') - TO_DATE(SYSDATE, 'YYYY-MM-DD') AS REMAIN_PERIOD FROM Member\r\n"
				+ "WHERE MEMBER_ID = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.setString(1, MainFrame.member.getMember_id());
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				if(rs.next()) {
					return rs.getString("REMAIN_PERIOD");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
