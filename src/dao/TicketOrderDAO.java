package dao;

import dto.Ticket_order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketOrderDAO {

	// 데이터베이스에 주문 정보를 저장하는 메서드
	public static void saveOrder(Ticket_order order) {


		String query = "INSERT INTO ticket_order VALUES ('TO-'|| order_id_seq.nextval, ?, ?,  '결제완료', sysdate)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);

				) {
			pstmt.setString(1, order.getMember_id());
			pstmt.setString(2, order.getTicket_id());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


