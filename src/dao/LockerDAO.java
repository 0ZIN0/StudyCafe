package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbConnection.OjdbcConnection;
import frame.MainFrame;

public class LockerDAO {
	
	/*사물함 순번으로 사용중인 멤버가 있는지 확인하는 메서드*/
	public static List<String[]> isUse() {
		List<String[]> lockerNums = new ArrayList<>();
		String query = "SELECT numbers.num AS lockerNum, member.member_id\r\n"
				+ "FROM (\r\n"
				+ "  SELECT LEVEL AS num\r\n"
				+ "  FROM dual\r\n"
				+ "  CONNECT BY LEVEL <= 20\r\n"
				+ ") numbers\r\n"
				+ "LEFT JOIN member ON SUBSTR(locker_number,3) = numbers.num\r\n"
				+ "ORDER BY numbers.num";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					lockerNums.add(new String[] {rs.getString("lockerNum"), rs.getString("member_id")});		
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lockerNums;
	}
	
	/*사물함의 남은기한과 현재시간을 비교하여 기한이 끝나면 사용자db의 사물함과 남은기한을 null로 바꾸는 메서드*/
	public static void updateLockerInfo() {
		String query = "UPDATE member set locker_number = null, locker_remain_date = null "
				+ "WHERE locker_remain_date IS NOT NULL AND locker_number IS NOT NULL AND "
				+ "sysdate - locker_remain_date = 0";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*사용중이 아닌 사물함의 갯수를 세는 메서드*/
	public static int remainLocker() {
		String query = "SELECT COUNT(*) FROM member WHERE locker_number IS NULL";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			try(
					ResultSet rs = pstmt.executeQuery();
					) {
				if(rs.next()) {
					return rs.getInt("count(*)");					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
