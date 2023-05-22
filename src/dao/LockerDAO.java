package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Member;
import dto.Ticket_order;

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
	
	// 사물함 결제 완료 시 member 테이블에 결제한 사물함 번호를 넣어주는 메서드
	public static void locNumToMem(Member member) {
		String query = "UPDATE member SET locker_number = ? WHERE member_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);

				) {
			pstmt.setString(1, member.getLocker_number());
			pstmt.setString(2, member.getMember_id());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
