package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeatDAO {

	/** 좌석 버튼 색 변경하는 메서드 */
	public static boolean isUse(int num) {

		String query = "SELECT * FROM seat WHERE SEAT_NUMBER=?"; // 추후에 SEAT_ID로 변경할 거임
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {

			pstmt.setInt(1, num);
			try (
					ResultSet rs = pstmt.executeQuery();
					) {
				rs.next();
				if (rs.getString("seat_state").equals("사용중")) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/** 좌석 현황을 알려주는 메서드 */
	public static int[] isRemain() {
		int[] remain = new int[2];

		String query = "SELECT seat_state FROM seat"; // 추후에 SEAT_ID로 변경할 거임
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				) {

			while (rs.next()) {
				++remain[1];
				if (rs.getString("seat_state").equals("비어있음")) {
					++remain[0];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return remain;
	}
}
