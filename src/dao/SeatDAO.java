package dao;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.swing.JLabel;

import dto.Seat;

public class SeatDAO {

	/** 좌석 버튼 색 변경하는 메서드 */
	public static boolean isUse(int num) {

		String query = "SELECT * FROM seat WHERE SEAT_ID=?"; // 추후에 SEAT_ID로 변경할 거임
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setInt(1, num);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				rs.next();
				if (rs.getString("seat_state").equals("사용중")) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* 사용자가 사용하고 있는 좌석이 있는지 확인하는 메서드 */
	public static boolean isMySeat(String member_id) {
		
		
		return false;
	}
	
	public static List<Integer> getSeatId() {
		List<Integer> seatIds = new ArrayList<>();
		String query = "SELECT seat_id FROM seat";
		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				seatIds.add(rs.getInt(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/** 좌석 현황을 알려주는 메서드 */
	public static int[] isRemain() {
		int[] remain = new int[2];

		String query = "SELECT seat_state FROM seat"; // 추후에 SEAT_ID로 변경할 거임
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				) {

			while (rs.next()) {
				++remain[1];
				if (rs.getString("seat_state").equals("비어있음")) {
					++remain[0];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return remain;
	}
	
	public static List<int[]> leaveSeat() {
		LocalTime time = LocalTime.now();
		List<int[]> remaintime = new ArrayList<>();
		
		String query = "SELECT \r\n"
				+ "    res.seat_id, \r\n"
				+ "    (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) AS remain\r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, seat seat\r\n"
				+ "WHERE \r\n"
				+ "    seat.seat_id = res.seat_id \r\n"
				+ "    AND seat_state = '사용중' \r\n"
				+ "    AND (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) < 10";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				) {

			while (rs.next()) {
				remaintime.add(new int[]{rs.getInt("seat_id"),rs.getInt("remain")}); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return remaintime;
	}
}
