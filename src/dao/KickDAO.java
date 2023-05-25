package dao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.MyColor;
import dialog.SeatKickDialog;
import dialog.setPopup;
import frame.MainFrame;

public class KickDAO {
	
	/** 좌석 이용현황 테이블 생성 메서드 */
	public static DefaultTableModel setSeatTable() {

		String query = "SELECT seat_reservation_id, seat_id, phone_number, use_ticket_category, TO_CHAR(seat_reservation_start_time, 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24:mi:ss')\r\n"
				+ "FROM seat_reservation inner join member using(member_id)\r\n"
				+ "where seat_reservation_end_time is null order by seat_reservation_id";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet resultSet = pstmt.executeQuery();
				) {

			// 데이터 모델 생성
			DefaultTableModel model = new DefaultTableModel() {
				public boolean isCellEditable(int rowIndex, int mColIndex) {
					return false;
				}
			};
			ResultSetMetaData metaData = resultSet.getMetaData();

			String[] header = new String[] {
					"예약번호", "좌석번호", "전화번호", "사용중인 이용권", "입실시간", ""
			};

			int columnCount = metaData.getColumnCount() + 1;
			for (int i = 0; i < header.length; i++) {
				model.addColumn(header[i]);
			}

			while (resultSet.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					if (i == columnCount) {
						rowData[i - 1] = "퇴실 조치";
					} else {
						rowData[i - 1] = " " + resultSet.getObject(i);
					}
				}
				model.addRow(rowData);
			}
			
			return model;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static DefaultTableModel setStudyTable() {
		
		String query = "SELECT studyroom_reservation_id, studyroom_id, phone_number, TO_CHAR(studyroom_start_time, 'YYYY\"년\"MM\"월\"DD\"일\" HH24:mi:ss'), TO_CHAR(studyroom_end_time, 'YYYY\"년\"MM\"월\"DD\"일\" HH24:mi:ss')\r\n"
				+ "FROM studyroom_reservation inner join member using(member_id)\r\n"
				+ "where studyroom_start_time >= sysdate\r\n"
				+ "ORDER BY studyroom_reservation_id";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet resultSet = pstmt.executeQuery();
				) {
			
			// 데이터 모델 생성
			DefaultTableModel model = new DefaultTableModel() {
				public boolean isCellEditable(int rowIndex, int mColIndex) {
					return false;
				}
			};
			ResultSetMetaData metaData = resultSet.getMetaData();
			
			String[] header = new String[] {
					"예약번호", "스터디룸 번호", "전화번호", "입실시간", "퇴실시간", ""
			};
			
			int columnCount = metaData.getColumnCount() + 1;
			for (int i = 0; i < header.length; i++) {
				model.addColumn(header[i]);
			}
			
			while (resultSet.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					if (i == columnCount) {
						rowData[i - 1] = "예약 취소";
					} else {
						rowData[i - 1] = " " + resultSet.getObject(i);
					}
				}
				model.addRow(rowData);
			}
			
			return model;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** (개인석)퇴실 조치하기 버튼을 누르면 퇴실을 시켜버리는 메서드  */
	public static void setSeatUserOut(String seat_reservation_id) {
		String query = "UPDATE SEAT_RESERVATION SET seat_reservation_end_time=sysdate WHERE SEAT_RESERVATION_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
				pstmt.setString(1, seat_reservation_id.trim());
			
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
