package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class TicketDAO {
	
	public static boolean isUsingTicket(String member_id) {
		
		String query = "SELECT * FROM member WHERE member_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setString(1, member_id);
			try (
					ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				
				Date remain_date = rs.getDate("remain_date");
				rs.getInt("remain_time");
				
				if (rs.getInt("remain_time") == 0 && remain_date.equals(null)) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
