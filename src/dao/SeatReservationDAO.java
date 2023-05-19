package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dto.Seat_reservation;
import dto.UsingSeat;

public class SeatReservationDAO {
	
	
	public static List<UsingSeat> UsingSeats() {
		List<UsingSeat> usingSeats = new ArrayList<>();
		String query = "SELECT \r\n"
				+ "    res.seat_id,(remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) \r\n"
				+ "AS usetime, seat_state, remain_time \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, seat \r\n"
				+ "WHERE res.seat_id = seat.seat_id \r\n"
				+ "    AND seat_reservation_end_time IS NULL \r\n"
				+ "    AND seat_state = '사용중'";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					UsingSeat usingSeat = new UsingSeat();
					usingSeat.setSeat_id(rs.getInt("seat_id"));
					usingSeat.setUseTime(rs.getInt("usetime"));
					usingSeat.setSeat_state(rs.getString("seat_state"));
					usingSeat.setRemainTime(rs.getInt("remain_time"));
					usingSeats.add(usingSeat);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usingSeats;
	}
}
