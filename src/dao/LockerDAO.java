package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LockerDAO {
	
	public static List<String[]> isUse() {
		List<String[]> lockerNums = new ArrayList<>();
		String query = "SELECT member_id, SUBSTR(locker_number,3) as lockerNum FROM member";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					if(rs.getString("lockerNum") != null) {
						lockerNums.add(new String[] {rs.getString("member_id") ,rs.getString("lockerNum")});
						
					}	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lockerNums;
	}
}
