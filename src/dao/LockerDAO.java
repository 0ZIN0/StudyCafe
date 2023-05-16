package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LockerDAO {
	
	public static boolean inUse(int num) {

		String query = "SELECT * FROM locker where locker_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				
				pstmt.setInt(1, num);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				rs.next();
				if (rs.getString("in_use").equals("사용중")) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int totalLocker() {
		
		int count = 0;
		String query = "SELECT useable FROM locker";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
		
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					if (rs.getString("useable").equals("사용가능")) {
						count++;
					}
				}
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int useable() {
		
		int count = 0;
		String query = "SELECT in_use FROM locker";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
		
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					if (rs.getString("in_use").equals("이용가능")) {
						count++;
					}
				}
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
