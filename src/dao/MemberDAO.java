package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import dto.Member;

public class MemberDAO {
	
	public static Member setMember(String phoneNumber) {
		String query = "SELECT * FROM member WHERE phone_number=?";
		Member member = new Member();
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setString(1, phoneNumber);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				rs.next();

				Date date_of_birth = rs.getDate("date_of_birth");
				Date remain_date = rs.getDate("remain_date");
				member.setDate_of_birth(date_of_birth);
				member.setRemain_date(remain_date);
				member.setMember_id(rs.getString("member_id"));
				member.setPhone_number(rs.getString("phone_number"));
				member.setRemain_time(rs.getInt("remain_time"));
				member.setLocker_number(rs.getString("locker_number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}
	
	public static int usingSeat(String memId) {
		String query = "SELECT seat_id FROM seat_reservation member WHERE member_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.setString(1, memId);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				rs.next();
				return rs.getInt("seat_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
