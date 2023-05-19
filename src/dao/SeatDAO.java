package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class SeatDAO {

	/* temp method */
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
	
	/* 좌석 이동 시 유저의 데이터를 변경하는 메서드 */
	public static void setChangeSeat(String member_id, String seatNum) {
		String query1 = "SELECT * FROM SEAT_RESERVATION INNER JOIN SEAT USING(SEAT_ID) WHERE MEMBER_ID=? AND SEAT_RESERVATION_END_TIME IS NULL";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
		) {

			pstmt1.setString(1, member_id);
			
			try (
					ResultSet rs1 = pstmt1.executeQuery();
			) {
				String query2 = "UPDATE SEAT SET SEAT_STATE='비어있음' WHERE SEAT_ID=?";

				try (
						PreparedStatement pstmt2 = conn.prepareStatement(query2);
						) {
					rs1.next();
					pstmt2.setString(1, rs1.getString("seat_id"));
					
					String query3 = "UPDATE SEAT SET SEAT_STATE='사용중' WHERE SEAT_ID=?";
					try (
							PreparedStatement pstmt3 = conn.prepareStatement(query3);
					) {
						pstmt3.setString(1, seatNum);
						
						String query4 = "SELECT * FROM SEAT_RESERVATION INNER JOIN SEAT USING (SEAT_ID) WHERE SEAT_STATE='비어있음'";
						try (
								PreparedStatement pstmt4 = conn.prepareStatement(query4);
								ResultSet rs2 = pstmt1.executeQuery();
						) {
							String query5 = "UPDATE SEAT_RESERVATION SET SEAT_ID=? WHERE SEAT_RESERVATION_ID=?";
							try (
									PreparedStatement pstmt5 = conn.prepareStatement(query5);
							) {
								
								rs2.next();
								pstmt5.setString(1, seatNum);
								pstmt5.setString(2, rs2.getString("seat_reservation_id"));
								
								pstmt5.executeUpdate();
							}
						}
						pstmt3.executeUpdate();
					}
					
					pstmt2.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 퇴실할때 퇴실 시간 찍어주는 메서드 */
	public static void setCheckOut(String member_id) {
		String query1 = "SELECT * FROM SEAT_RESERVATION WHERE MEMBER_ID=? AND SEAT_RESERVATION_END_TIME IS NULL";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				) {

			pstmt1.setString(1, member_id);
			try (
					ResultSet rs = pstmt1.executeQuery();
					) {
				String query2 = "UPDATE SEAT_RESERVATION SET SEAT_RESERVATION_END_TIME= WHERE SEAT_RESERVATION_ID=?";

				try (
						PreparedStatement pstmt2 = conn.prepareStatement(query2);
						) {
					rs.next();
					java.util.Date utilCheckOutTime = new java.util.Date();
					java.sql.Date sqlCheckOutDate = new java.sql.Date(utilCheckOutTime.getTime());

					pstmt2.setDate(1, sqlCheckOutDate);
					pstmt2.setString(2, rs.getString("seat_reservaion_id"));
					
					pstmt2.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	public static int isUsingMySeat(String member_id) {

		String query = "SELECT * FROM SEAT_RESERVATION INNER JOIN MEMBER USING (MEMBER_ID) WHERE MEMBER_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setString(1, member_id);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					if (rs.getString("seat_reservation_end_time") == null) {
						return rs.getInt("seat_id");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
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
}
