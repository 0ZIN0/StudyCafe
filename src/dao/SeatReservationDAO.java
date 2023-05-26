package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import color.MyColor;
import dbConnection.OjdbcConnection;
import dto.CheckRemaintime;
import dto.Seat_reservation;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.SeatReportPanel;

public class SeatReservationDAO {
	
	/*좌석예약의 남은 시간을 체크하는 메서드*/
	public static List<CheckRemaintime> getRemainTimes() {
		List<CheckRemaintime> remainTimes = new ArrayList<>();
		
		String query1 = "SELECT \r\n"
				+ "seat_reservation_id, res.seat_id, res.use_ticket_category, res.member_id, "
				+ "(remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) as remain \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, seat seat \r\n"
				+ "WHERE \r\n"
				+ "    res.seat_id = seat.seat_id \r\n"
				+ "AND \r\n"
				+ "    res.use_ticket_category = '일회이용권'"
				+ " AND res.seat_reservation_end_time IS NULL";
		
		String query2 = "SELECT \r\n"
				+ "seat_reservation_id, res.seat_id, res.use_ticket_category, res.member_id, "
				+ "(remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) as remain \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, member mem \r\n"
				+ "WHERE \r\n"
				+ "    res.member_id = mem.member_id \r\n"
				+ "AND \r\n"
				+ "    res.use_ticket_category = '시간충전권'"
				+ " AND res.seat_reservation_end_time IS NULL";
		
		String query3 = "SELECT \r\n"
				+ "seat_reservation_id, res.seat_id, res.use_ticket_category, res.member_id, "
				+ "(ROUND((remain_date - sysdate) * 24 * 60)) as remain \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, member mem \r\n"
				+ "WHERE \r\n"
				+ "    res.member_id = mem.member_id \r\n"
				+ "AND \r\n"
				+ "    res.use_ticket_category = '기간이용권'"
				+ " AND res.seat_reservation_end_time IS NULL";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				PreparedStatement pstmt3 = conn.prepareStatement(query3);
				) {
			try (
					ResultSet rs1 = pstmt1.executeQuery();
					ResultSet rs2 = pstmt2.executeQuery();
					ResultSet rs3 = pstmt3.executeQuery();
					) {
				while(rs1.next()) {
					CheckRemaintime checkOneday = new CheckRemaintime();
					checkOneday.setSeat_reservation_id(rs1.getString("seat_reservation_id"));
					checkOneday.setSeat_id(rs1.getInt("seat_id"));
					checkOneday.setMember_id(rs1.getString("member_id"));
					checkOneday.setusing_ticket(rs1.getString("use_ticket_category"));
					checkOneday.setRemainTime(rs1.getInt("remain"));
					remainTimes.add(checkOneday);
				}
				while(rs2.next()) {
					CheckRemaintime checkChage = new CheckRemaintime();
					checkChage.setSeat_reservation_id(rs2.getString("seat_reservation_id"));
					checkChage.setSeat_id(rs2.getInt("seat_id"));
					checkChage.setMember_id(rs2.getString("member_id"));
					checkChage.setusing_ticket(rs2.getString("use_ticket_category"));
					checkChage.setRemainTime(rs2.getInt("remain"));
					remainTimes.add(checkChage);
				}
				while(rs3.next()) {
					CheckRemaintime checkPeriod = new CheckRemaintime();
					checkPeriod.setSeat_reservation_id(rs3.getString("seat_reservation_id"));
					checkPeriod.setSeat_id(rs3.getInt("seat_id"));
					checkPeriod.setMember_id(rs3.getString("member_id"));
					checkPeriod.setusing_ticket(rs3.getString("use_ticket_category"));
					checkPeriod.setRemainTime(rs3.getInt("remain"));
					remainTimes.add(checkPeriod);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return remainTimes;
	}
	
	/** 좌석이 현재 상태와 사용중이라면 사용중인 멤버의 id를 조회해주는 메서드*/
	public static void UsingSeats() {
		String query = "SELECT \r\n"
				+ "    seat.seat_id, \r\n"
				+ "    NVL(res.member_id, '없음') AS member_id, \r\n"
				+ "    seat.seat_state\r\n"
				+ "FROM \r\n"
				+ "    seat LEFT JOIN seat_reservation res \r\n"
				+ "ON \r\n"
				+ "    seat.seat_id = res.seat_id \r\n"
				+ "    AND seat_reservation_end_time IS NULL";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				while(rs.next()) {
					int seatNum = rs.getInt("seat_id") - 1;
					String memId = rs.getString("member_id");
					String state = rs.getString("seat_state");
					if(memId.equals(MainFrame.member.getMember_id())) {
						SeatReportPanel.seatBtns.get(seatNum).setBackground(MyColor.ORANGE);
					} else {
						if(state.equals("사용중")) {
							SeatReportPanel.seatBtns.get(seatNum).setBackground(MyColor.GRAY);
						} else {
							SeatReportPanel.seatBtns.get(seatNum).setBackground(MyColor.LIGHTGRAY);
						}
					}
				}
				int remain[] = SeatDAO.isRemain();
				SeatReportPanel.remainSeatLabel.setText(String.format("%02d / %02d", remain[0], remain[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 남은 시간이 0이 되면 자동 퇴실 시키는 메서드*/
	public static void autoLeaveSystem() {
		List<Integer> leaveSeat = new ArrayList<>();
		
		for(CheckRemaintime remainTime : getRemainTimes()) {
			if(remainTime.getRemainTime() < 0) {
				String query = "UPDATE seat SET seat_state = '비어있음' WHERE seat_id = ?";
				String query1 = "UPDATE seat_reservation SET seat_reservation_end_time = sysdate WHERE seat_reservation_id = ?";
				try (Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt1 = conn.prepareStatement(query);
					PreparedStatement pstmt2 = conn.prepareStatement(query1);
				) {
					pstmt1.setInt(1, remainTime.getSeat_id());
					pstmt1.executeUpdate();
					pstmt2.setString(1, remainTime.getSeat_reservation_id());
					pstmt2.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(remainTime.getusing_ticket().equals("일회이용권")) {
					String query2 = "UPDATE seat SET remain_time = 0 WHERE seat_id = ?";
					try (Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(query2);
					) {
						pstmt.setInt(1, remainTime.getSeat_id());
						pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if(remainTime.getusing_ticket().equals("시간충전권")) {
					String query3 = "UPDATE member SET remain_time = 0 WHERE member_id = ?";
					try (Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(query3);
					) {
						System.out.println(remainTime.getMember_id());
						pstmt.setString(1, remainTime.getMember_id());
						pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					String query4 = "UPDATE member SET remain_date = null WHERE member_id = ?";
					try (Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(query4);
					) {
						pstmt.setString(1, remainTime.getMember_id());
						pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}
