package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
		String query = "UPDATE MEMBER SET LOCKER_REMAIN_DATE= CASE\r\n"
				+ "    WHEN LOCKER_REMAIN_DATE IS NULL THEN SYSDATE + (SELECT TICKET_VALUE FROM TICKET WHERE TICKET_ID = ?)\r\n"
				+ "    ELSE LOCKER_REMAIN_DATE + (SELECT TICKET_VALUE FROM TICKET WHERE TICKET_ID = ?)\r\n"
				+ "END, LOCKER_NUMBER=?\r\n"
				+ "WHERE MEMBER_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			pstmt.setString(1, order.getTicket_id());
			pstmt.setString(2, order.getTicket_id());
			pstmt.setString(3, "L-" + lockerNum);
			pstmt.setString(4, order.getMember_id());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


