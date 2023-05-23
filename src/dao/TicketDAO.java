package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Ticket;

public class TicketDAO {
	
	/** 사용중인 티켓이 있는지 알려주는 메서드 */
	public static boolean isUsingTicket(String member_id) {
		
		String query = "SELECT * FROM member WHERE member_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setString(1, member_id);
			try (
					ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				
				Date remain_date = rs.getDate("remain_date");
				rs.getInt("remain_time");
				
				if (rs.getInt("remain_time") == 0 && remain_date == null) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/** 티켓 아이디를 주면 정보에 맞게 티켓을 세팅해서 반환해주는 메서드 */
	public static Ticket getTicket(String ticket_id) {
		String query = "SELECT * FROM ticket WHERE ticket_id=?";
		
		Ticket ticket = new Ticket();
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setString(1, ticket_id);
			try (
					ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				
				ticket.setTicket_id(rs.getString("ticket_id"));
				ticket.setTicket_category(rs.getString("ticket_category"));
				ticket.setTicket_name(rs.getString("ticket_name"));
				ticket.setTicket_price(rs.getInt("ticket_price"));
				ticket.setTicket_value(rs.getInt("ticket_value"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ticket;
	}
}
