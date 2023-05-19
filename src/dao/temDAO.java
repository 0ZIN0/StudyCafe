package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.temDTO;
// 연습용 클래스. 나중에 지우기
public class temDAO {

    public void addTem(temDTO dto12) {
        
        String query = "INSERT INTO hello_ticket VALUES (?, ?)";
        try (
            Connection conn = OjdbcConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, dto12.getId());
            pstmt.setString(2, dto12.getDescription());
            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("레코드가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("레코드 추가에 실패했습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}