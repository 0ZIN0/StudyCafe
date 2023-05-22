package dao;

import dto.Ticket_order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketOrderDAO {

	/** 일회이용권, 시간충전권, 기간이용권 구매완료 후 db로 값 넘겨주는 메서드 **/
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
	
	
	
}


