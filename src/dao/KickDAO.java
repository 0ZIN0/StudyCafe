package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import dbConnection.OjdbcConnection;

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
	
	public static DefaultTableModel setLockerTable() {
		
		String query = "SELECT MEMBER_ID, LOCKER_NUMBER, PHONE_NUMBER, TO_CHAR(locker_remain_date, 'YYYY\"년\"MM\"월\"DD\"일\" HH24:mi:ss') FROM MEMBER WHERE LOCKER_NUMBER IS NOT NULL";
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
					"멤버 ID", "사물함번호", "전화번호", "만료일", ""
			};
			
			int columnCount = metaData.getColumnCount() + 1;
			for (int i = 0; i < header.length; i++) {
				model.addColumn(header[i]);
			}
			
			while (resultSet.next()) {
				Object[] rowData = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					if (i == columnCount) {
						rowData[i - 1] = "이용 제한";
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
	
	/** (개인석)퇴실 처리 기능 */
	public static void setCheckOut(String reservation_id, String phone_number) {
		String query1 = "SELECT * FROM SEAT_RESERVATION WHERE seat_reservation_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				) {

			pstmt1.setString(1, reservation_id);
			try (
					ResultSet rs = pstmt1.executeQuery();
					) {
				String query2 = "UPDATE SEAT_RESERVATION SET SEAT_RESERVATION_END_TIME=sysdate WHERE SEAT_RESERVATION_ID=?";
				String query3 = "UPDATE SEAT SET SEAT_STATE='비어있음', REMAIN_TIME=0 WHERE SEAT_ID=?";
				String query4 = "SELECT ROUND((SEAT_RESERVATION_END_TIME-SEAT_RESERVATION_START_TIME)*24*60) AS MINUTE FROM SEAT_RESERVATION WHERE SEAT_RESERVATION_ID=?";
				String query5 = "UPDATE MEMBER SET REMAIN_TIME=REMAIN_TIME-? WHERE phone_number=?";
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
							pstmt5.setString(2, phone_number);
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
	
	/** (스터디룸)예약 취소하기 버튼을 누르면 퇴실을 시켜버리는 메서드  */
	public static void setStudyRoomUserOut(String studyroom_reservation_id) {
		String query = "DELETE FROM STUDYROOM_RESERVATION WHERE STUDYROOM_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, studyroom_reservation_id.trim());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** (사물함)이용 취소하기 버튼을 누르면 퇴실을 시켜버리는 메서드  */
	public static void setLockerUserOut(String member_id) {
		String query = "UPDATE MEMBER SET LOCKER_NUMBER=NULL, LOCKER_REMAIN_DATE=NULL WHERE MEMBER_ID=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			
			pstmt.setString(1, member_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
