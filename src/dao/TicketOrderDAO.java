package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;

import color.MyColor;
import dbConnection.OjdbcConnection;
import dto.Ticket_order;
import frame.MainFrame;
import panel.LockerPanel;
import panel.Master_salesPanel;

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
			LockerPanel.lockerBtns.get(Integer.parseInt(lockerNum) - 1).setBackground(MyColor.ORANGE);
			LockerPanel.lockerBtns.get(Integer.parseInt(lockerNum) - 1).setEnabled(false);
			MainFrame.member.setLocker_number("L-" + lockerNum);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DefaultTableModel salesTableModel() {
		DefaultTableModel model = new DefaultTableModel();
		
		String[] header = new String[] {
	    		"주문번호", "회원번호", "이용권번호", "결제 금액", "결제 상태", "결제 날짜"
	    		};
		
		String query = "SELECT "
				+ "order_id, member_id, ticket_id, order_total_price, pay_state, "
				+ "TO_CHAR(order_date, 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24:mi:ss') "
				+ "FROM ticket_order "
				+ "WHERE to_date(order_date) = ? "
				+ "ORDER BY order_date DESC";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			// 데이터 모델 생성
			Date sqlDate = Date.valueOf(Master_salesPanel.date);
			pstmt.setDate(1, sqlDate);
			
			try(
					ResultSet rs = pstmt.executeQuery();
					) {
				ResultSetMetaData metaData = rs.getMetaData();

				int columnCount = metaData.getColumnCount();
				for (int i = 0; i < header.length; i++) {
					model.addColumn(header[i]);
				}
				while (rs.next()) {
					Object[] rowData = new Object[columnCount];
					for (int i = 1; i <= columnCount; i++) {
						rowData[i - 1] = " " + rs.getObject(i);
					}
					model.addRow(rowData);
				}
				return model;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static long sales_year() {
		String query = "SELECT SUM(order_total_price) as total\r\n"
				+ "FROM ticket_order\r\n"
				+ "WHERE EXTRACT(YEAR FROM order_date) = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			pstmt.setString(1, Integer.toString(Master_salesPanel.date.getYear()));
			try(
					ResultSet rs = pstmt.executeQuery()
					){
				if(rs.next()) {
					return rs.getLong("total");					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long sales_month() {
		String query = "SELECT SUM(order_total_price) as total\r\n"
				+ "FROM ticket_order\r\n"
				+ "WHERE EXTRACT(YEAR FROM order_date) = ?\r\n"
				+ "      AND EXTRACT(MONTH FROM order_date) = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			pstmt.setString(1, Integer.toString(Master_salesPanel.date.getYear()));
			pstmt.setString(2, Integer.toString(Master_salesPanel.date.getMonthValue()));
			try(
					ResultSet rs = pstmt.executeQuery()
					){
				if(rs.next()) {
					return rs.getLong("total");					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long sales_day() {
		String query = "SELECT SUM(order_total_price) as total\r\n"
				+ "FROM ticket_order\r\n"
				+ "WHERE EXTRACT(YEAR FROM order_date) = ?\r\n"
				+ "      AND EXTRACT(MONTH FROM order_date) = ? "
				+ "AND EXTRACT(DAY FROM order_date) = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			pstmt.setString(1, Integer.toString(Master_salesPanel.date.getYear()));
			pstmt.setString(2, Integer.toString(Master_salesPanel.date.getMonthValue()));
			pstmt.setString(3, Integer.toString(Master_salesPanel.date.getDayOfMonth()));
			
			try(
					ResultSet rs = pstmt.executeQuery()
					){
				if(rs.next()) {
					return rs.getLong("total");					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}


