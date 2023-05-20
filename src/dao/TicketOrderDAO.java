package dao;

import dto.Ticket_order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketOrderDAO {

    // 데이터베이스에 주문 정보를 저장하는 메서드
    public void saveOrder(Ticket_order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // 데이터베이스 연결 설정
            connection = OjdbcConnection.getConnection();  // 적절한 데이터베이스 연결 메서드를 호출하여 connection을 얻으세요.
            
            // SQL 문 작성
            String sql = "INSERT INTO ticket_order (order_id, member_id, ticket_id, order_date, pay_state) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            
            // PreparedStatement 객체 생성
            statement = connection.prepareStatement(sql);
            
            // SQL 문에 값 설정
            statement.setString(1, order.getOrder_id());
            statement.setString(2, order.getMember_id());
            statement.setString(3, order.getTicket_id());
            statement.setString(4, order.getPay_id());
            statement.setDate(5, new java.sql.Date(order.getOrder_date().getTime())); // java.util.Date를 java.sql.Date로 변환
            
            // SQL 문 실행
            statement.executeUpdate();
            
            // 성공적으로 저장되었을 때 처리할 로직 추가
            System.out.println("주문 정보가 저장되었습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // 저장 실패 시 예외 처리 로직 추가
        } finally {
            // 리소스 해제
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // 리소스 해제 실패 시 예외 처리 로직 추가
            }
        }
    }
}