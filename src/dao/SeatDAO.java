package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import color.MyColor;
import dbConnection.OjdbcConnection;
import dto.Member;
import panel.MyPagePanel;
import panel.SeatReportPanel;
import panel.UserInfoPanel;
import dto.Seat_reservation;
import frame.MainFrame;
import label.SeatReportLabel;


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

	/* 유저의 잔여시간을 꺼내는 메서드 */
	public static int getRemainTime(String member_id) {
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
		) {
				
			pstmt.setString(1, member_id);
			try (
					ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				return rs.getInt("remain_time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
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
				String query2 = "UPDATE SEAT SET SEAT_STATE='사용중', REMAIN_TIME=(SELECT REMAIN_TIME FROM SEAT WHERE SEAT_ID=?) WHERE SEAT_ID=?";
				String query3 = "UPDATE SEAT SET SEAT_STATE='비어있음', REMAIN_TIME=0 WHERE SEAT_ID=?";

				try (
						PreparedStatement pstmt2 = conn.prepareStatement(query2);
						PreparedStatement pstmt3 = conn.prepareStatement(query3);
						) {

					rs1.next();

					pstmt2.setInt(1, rs1.getInt("seat_id"));
					pstmt2.setInt(2, Integer.parseInt(seatNum));
					pstmt3.setInt(1, rs1.getInt("seat_id"));

					pstmt2.executeUpdate();
					pstmt3.executeUpdate();

					String query4 = "SELECT * FROM SEAT_RESERVATION INNER JOIN SEAT USING (SEAT_ID) WHERE SEAT_STATE='비어있음' AND SEAT_RESERVATION_END_TIME IS NULL";
					try (
							PreparedStatement pstmt4 = conn.prepareStatement(query4);
							ResultSet rs2 = pstmt1.executeQuery();
							) {
						String query5 = "UPDATE SEAT_RESERVATION SET SEAT_ID=? WHERE SEAT_RESERVATION_ID=?";
						try (
								PreparedStatement pstmt5 = conn.prepareStatement(query5);
								) {

							rs2.next();
							pstmt5.setInt(1, Integer.parseInt(seatNum));
							pstmt5.setString(2, rs2.getString("seat_reservation_id"));

							pstmt5.executeUpdate();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 퇴실 처리 기능 */
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
				String query2 = "UPDATE SEAT_RESERVATION SET SEAT_RESERVATION_END_TIME=sysdate WHERE SEAT_RESERVATION_ID=?";
				String query3 = "UPDATE SEAT SET SEAT_STATE='비어있음', REMAIN_TIME=0 WHERE SEAT_ID=?";
				String query4 = "SELECT ROUND((SEAT_RESERVATION_END_TIME-SEAT_RESERVATION_START_TIME)*24*60) AS MINUTE FROM SEAT_RESERVATION WHERE SEAT_RESERVATION_ID=?";
				String query5 = "UPDATE MEMBER SET REMAIN_TIME=REMAIN_TIME-? WHERE MEMBER_ID=?";
				try (
						PreparedStatement pstmt2 = conn.prepareStatement(query2);
						PreparedStatement pstmt3 = conn.prepareStatement(query3);
						PreparedStatement pstmt4 = conn.prepareStatement(query4);
						PreparedStatement pstmt5 = conn.prepareStatement(query5);
						) {
					rs.next();
					pstmt2.setString(1, rs.getString("SEAT_RESERVATION_ID"));
					pstmt3.setString(1, rs.getString("seat_id"));
					
					pstmt2.executeUpdate();
					pstmt3.executeUpdate();
					
					if (!(rs.getString("use_ticket_category").equals("일회이용권") && rs.getString("use_ticket_category").equals("기간이용권"))) {
						pstmt4.setString(1, rs.getString("SEAT_RESERVATION_ID"));
						
						try (
								ResultSet rs2 = pstmt4.executeQuery();
								) {
							rs2.next();
							
							pstmt5.setInt(1, rs2.getInt("MINUTE"));
							pstmt5.setString(2, member_id);
						}
					} else {
						pstmt5.setInt(1, 0);
					}
					pstmt5.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 입실할 때 좌석 예약 테이블에 데이터 추가하는 메서드 */
	public static void setReservation(Seat_reservation seat_reservation) {

		String query1 = "INSERT INTO SEAT_RESERVATION VALUES ('SR-'|| seat_reservation_id_seq.nextval, ?, ?, ?, sysdate, NULL)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				) {

			pstmt1.setString(1, seat_reservation.getSeat_id().toString());
			pstmt1.setString(2, seat_reservation.getMember_id());
			pstmt1.setString(3, seat_reservation.getUse_ticket_category());

			pstmt1.executeUpdate();

			String query2 = "UPDATE SEAT SET SEAT_STATE='사용중' WHERE SEAT_ID=?";
			try (
					PreparedStatement pstmt2 = conn.prepareStatement(query2);
					) {
				pstmt2.setString(1, seat_reservation.getSeat_id().toString());

				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (일회이용권 전용)입실할 때 좌석 예약 테이블에 데이터 추가하는 메서드 */
	public static void setOneDayReservation(Seat_reservation seat_reservation, Integer ticket_useable) {

		String query1 = "INSERT INTO SEAT_RESERVATION VALUES ('SR-'|| seat_reservation_id_seq.nextval, ?, ?, ?, sysdate, NULL)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				) {

			pstmt1.setString(1, seat_reservation.getSeat_id().toString());
			pstmt1.setString(2, seat_reservation.getMember_id());
			pstmt1.setString(3, seat_reservation.getUse_ticket_category());

			pstmt1.executeUpdate();

			String query2 = "UPDATE SEAT SET SEAT_STATE='사용중', REMAIN_TIME=? WHERE SEAT_ID=?";
			try (
					PreparedStatement pstmt2 = conn.prepareStatement(query2);
					) {
				pstmt2.setInt(1, ticket_useable);
				pstmt2.setString(2, seat_reservation.getSeat_id().toString());
				System.out.println(pstmt2.executeUpdate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setUseTicketReservation(Seat_reservation seat_reservation) {

		String query1 = "INSERT INTO SEAT_RESERVATION VALUES ('SR-'|| seat_reservation_id_seq.nextval, ?, ?, ?, sysdate, NULL)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				) {

			pstmt1.setString(1, seat_reservation.getSeat_id().toString());
			pstmt1.setString(2, seat_reservation.getMember_id());
			pstmt1.setString(3, seat_reservation.getUse_ticket_category());

			pstmt1.executeUpdate();

			String query2 = "UPDATE SEAT SET SEAT_STATE='사용중' WHERE SEAT_ID = ?";
			try (
					PreparedStatement pstmt2 = conn.prepareStatement(query2);
					) {
				pstmt2.setString(1, seat_reservation.getSeat_id().toString());
				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 좌석 버튼 색 변경하는 메서드 */
	public static boolean isUse(int num) {

		String query = "SELECT * FROM seat WHERE SEAT_ID=?";
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
	
	public static void findMemberSeat() {

		String query = "SELECT * FROM SEAT_RESERVATION INNER JOIN MEMBER USING (MEMBER_ID) WHERE MEMBER_ID=? AND seat_reservation_end_time IS NULL";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			pstmt.setString(1, MainFrame.member.getMember_id());
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				if(rs.next()) {
					UserInfoPanel.seat.setText(rs.getInt("seat_id") + "번");
					SeatReportPanel.seatInfoLabel.setText(rs.getInt("seat_id") + "번 좌석을 사용중입니다.");
				} else {
					UserInfoPanel.seat.setText("사용중인 좌석이 없습니다");
					SeatReportPanel.seatInfoLabel.setText("사용중인 좌석이 없습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (일회이용권 전용) 이용권 연장 시 seat의 remain_time 시간 추가하는 메서드 */
	public static void plusOneDayTicket(Integer seat_id, Integer remain_time) {
		String query = "UPDATE SEAT SET REMAIN_TIME=REMAIN_TIME+? WHERE SEAT_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setInt(1, remain_time);
			pstmt.setInt(2, seat_id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	/*좌석의 상태를 확인하여 seatButton의 use를 바꿔주는 메서드*/
	public static void checkUse() {
		String query = "SELECT seat_id, seat_state FROM seat";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				) {

			while (rs.next()) {
				int seatNum = rs.getInt("seat_id") - 1;
				if (rs.getString("seat_state").equals("비어있음")) {
					SeatReportPanel.seatBtns.get(seatNum).use = false;
				} else {
					SeatReportPanel.seatBtns.get(rs.getInt("seat_id") - 1).use = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 퇴실 예정인 좌석을 꺼내오는 메서드 */
	public static List<int[]> leaveSeat() {
		LocalTime time = LocalTime.now();
		List<int[]> remaintime = new ArrayList<>();
		
		String query = "SELECT res.seat_id,(remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) AS remain\r\n"
				+ "FROM seat_reservation res, seat seat\r\n"
				+ "WHERE seat.seat_id = res.seat_id\r\n"
				+ "AND seat_reservation_end_time IS NULL\r\n"
				+ "AND use_ticket_category = '일회이용권'\r\n"
				+ "AND (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) < 10";
		
		String query2 = "SELECT res.seat_id,(mem.remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) AS remain\r\n"
				+ "FROM seat_reservation res, member mem\r\n"
				+ "WHERE res.member_id = mem.member_id\r\n"
				+ "AND seat_reservation_end_time IS NULL\r\n"
				+ "AND use_ticket_category = '시간충전권'\r\n"
				+ "AND (mem.remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) < 10";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				ResultSet rs1 = pstmt1.executeQuery();
				ResultSet rs2 = pstmt2.executeQuery();
				) {

			while (rs1.next()) {
				remaintime.add(new int[]{rs1.getInt("seat_id"),rs1.getInt("remain")}); 
			}
			while (rs2.next()) {
				remaintime.add(new int[]{rs2.getInt("seat_id"),rs2.getInt("remain")}); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return remaintime;
	}
}
