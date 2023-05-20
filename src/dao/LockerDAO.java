package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LockerDAO {
	
	public static List<Integer> isUse() {
		List<Integer> lockerNums = new ArrayList<>();
		String query = "SELECT SUBSTR(locker_number,3) as lockerNum FROM member";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					lockerNums.add(Integer.parseInt(rs.getString("lockerNum")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lockerNums;
	}
}
