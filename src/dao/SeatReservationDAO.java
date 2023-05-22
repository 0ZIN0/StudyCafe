package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import color.MyColor;
import dto.Seat_reservation;
import dto.UsingSeat;
import frame.CheckInFrame;
import label.RemainSeatLabel;
import panel.SeatReportPanel;

public class SeatReservationDAO {
	
	
	public static List<int[]> getRemainTimes() {
		List<int[]> remainTimes = new ArrayList<>();
		
		String query1 = "SELECT \r\n"
				+ "    res.seat_id, (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) as remain \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, seat seat \r\n"
				+ "WHERE \r\n"
				+ "    res.seat_id = seat.seat_id \r\n"
				+ "AND \r\n"
				+ "    res.use_ticket_category = '일회이용권'";
		
		String query2 = "SELECT \r\n"
				+ "    res.seat_id, (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) as remain \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, member mem \r\n"
				+ "WHERE \r\n"
				+ "    res.member_id = mem.member_id \r\n"
				+ "AND \r\n"
				+ "    res.use_ticket_category = '시간충전권'";
		
		String query3 = "SELECT \r\n"
				+ "    res.seat_id, (ROUND((remain_date - sysdate) * 24 * 60)) as remain \r\n"
				+ "FROM \r\n"
				+ "    seat_reservation res, member mem \r\n"
				+ "WHERE \r\n"
				+ "    res.member_id = mem.member_id \r\n"
				+ "AND \r\n"
				+ "    res.use_ticket_category = '기간이용권'";
		
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
					remainTimes.add(new int[] {rs1.getInt("seat_id"), rs1.getInt("remain")});
				}
				while(rs2.next()) {
					remainTimes.add(new int[] {rs2.getInt("seat_id"), rs2.getInt("remain")});
				}
				while(rs3.next()) {
					remainTimes.add(new int[] {rs3.getInt("seat_id"), rs3.getInt("remain")});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return remainTimes;
	}
	
	/** 좌석의 상태를 불러오는 메서드*/
	public static void UsingSeats() {
		String query = "SELECT seat.seat_id, NVL(res.member_id, '없음') AS member_id, seat.seat_state \r\n"
				+ "FROM seat_reservation res, seat seat \r\n"
				+ "WHERE seat.seat_id = res.seat_id (+)";
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
					if(memId.equals(CheckInFrame.member.getMember_id())) {
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
	public static void autoLeave() {
		// remain_time이 0이 되면 end_time을 sysdate로 변경
		String query1 = "UPDATE \r\n"
				+ "    seat_reservation \r\n"
				+ "SET seat_reservation_end_time = sysdate \r\n"
				+ "WHERE seat_id IN \r\n"
				+ "    (SELECT res.seat_id\r\n"
				+ "        FROM seat_reservation res, seat seat\r\n"
				+ "        WHERE seat.seat_id = res.seat_id\r\n"
				+ "        AND (remain_time - ROUND((sysdate - seat_reservation_start_time) * 24 * 60)) < 0)";
		
		// end_time이 null이 아닐때 seat_state를 비어있음으로 변경
		String query2 = "UPDATE seat \r\n"
				+ "SET seat_state = '비어있음' \r\n"
				+ "WHERE seat_id \r\n"
				+ "    IN (SELECT res.seat_id\r\n"
				+ "        FROM seat_reservation res, seat seat\r\n"
				+ "        WHERE seat.seat_id = res.seat_id\r\n"
				+ "        AND res.seat_reservation_end_time IS NOT NULL)";
		
		
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
		) {
			pstmt1.executeQuery();
			pstmt2.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void autoLeaveSystem() {
		List<Integer> leaveSeat = new ArrayList<>();
		
		for(int[] remainTime : getRemainTimes()) {
			if(remainTime[1] < 0) {
				String query = "UPDATE seat SET seat_state = '비어있음' WHERE seat_id = ?";
				
				try (Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
				) {
					pstmt.setInt(0, remainTime[0]);
					pstmt.executeQuery();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
