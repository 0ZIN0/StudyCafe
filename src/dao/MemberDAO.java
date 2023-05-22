package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.Date;

import dto.Member;
import frame.CheckInFrame;
import panel.MyPagePanel;

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
				Date remain_date = rs.getDate("remain_date");
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
		String query = "SELECT seat_id FROM seat_reservation WHERE member_id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
				pstmt.setString(1, memId);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				if(rs.next()) {
					return rs.getInt("seat_id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int updateRemainTime(String memId) {
		String query1 = "select\r\n"
				+ "mem.member_id, (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60))\r\n"
				+ "AS remain \r\n"
				+ "from \r\n"
				+ "seat_reservation res, member mem\r\n"
				+ "WHERE res.member_id = mem.member_id\r\n"
				+ "AND mem.member_id = ?\r\n"
				+ "AND seat_reservation_end_time IS NULL";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				) {
			conn.setAutoCommit(false);
			pstmt1.setString(1, memId);
			try (
					ResultSet rs = pstmt1.executeQuery();
					){
				if(rs.next()) {
					int remain_time = rs.getInt("remain");
					if(remain_time > 0) {
						if(remain_time >= 60) {
							int hour = remain_time / 60;
							int minute = remain_time % 60;
							MyPagePanel.time.setText(hour + "시간 " + minute + "분");
						} else {
							MyPagePanel.time.setText(remain_time + "분");
						}
					} else {
						MyPagePanel.time.setText("0분");
					}					
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}


