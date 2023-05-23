package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Ticket_order;

public class TicketOrderDAO {

	// 데이터베이스에 주문 정보를 저장하는 메서드
	public static void saveOrder(Ticket_order order) {

		String query = "INSERT INTO ticket_order VALUES ('TO-'|| order_id_seq.nextval, ?, ?, ?, '결제완료', sysdate)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);

				) {
			pstmt.setString(1, order.getMember_id());
			pstmt.setString(2, order.getTicket_id());
			pstmt.setInt(3, order.getOrder_total_price());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setLockerinMember(Ticket_order order, String lockerNum) {
		String query1 = "SELECT * FROM TICKET_ORDER INNER JOIN TICKET USING(TICKET_ID) WHERE ORDER_ID=?";
		String query2 = "UPDATE MEMBER SET LOCKER_NUMBER=?, LOCKER_REMAIN_DATE=sysdate+? WHERE MEMBER_ID=?";
			
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				) {
			pstmt1.setString(1, order.getOrder_id());

			try (
				ResultSet rs = pstmt1.executeQuery();	
			) {
				
				rs.next();
				
				
				pstmt2.setString(1, lockerNum);
				
				pstmt2.setInt(2, rs.getInt("ticket_value"));
				pstmt2.setString(3, order.getMember_id());
				
				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


