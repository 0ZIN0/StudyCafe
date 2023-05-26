package panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.StreamCorruptedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MasterUsersearch extends JPanel{
	
	ImageIcon im =new ImageIcon("ui/master/masterUsersearch/Master_UserSearch_Main_Contents.jpg");
	Image image=im.getImage();

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	
	public MasterUsersearch(){
		// SQL 연결 정보 설정
        String url = "jdbc:oracle:thin:@localhost:1521:XE";  // 데이터베이스 URL
        String username = "testuser";  // 데이터베이스 사용자 이름
        String password = "1234";  // 데이터베이스 비밀번호

        // SQL 쿼리 실행하여 결과를 JTable에 표시
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // SQL 쿼리 실행
            ResultSet resultSet = statement.executeQuery("SELECT * FROM member");

            // ResultSet의 메타데이터에서 열 정보 추출
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 열 이름 추출하여 배열로 저장
            String[] columnNames = new String[6];
//            for (int i = 0; i < columnCount; i++) {
//                columnNames[i] = metaData.getColumnName(i + 1);
//            }

            // JTable에 데이터를 표시할 DefaultTableModel 생성
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // ResultSet에서 행 데이터 추출하여 DefaultTableModel에 추가
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                   // rowData[i] = resultSet.getObject(i);
                    rowData[i] = resultSet.getObject(i + 1);
                }
                tableModel.addRow(rowData);
            }

            // JTable 생성 및 표시
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBackground(Color.black);
            scrollPane.setBounds(0, 0, 1000, 300);
            add(scrollPane);
            scrollPane.setBorder(new LineBorder(Color.red,1));
            //setBounds(0, 0, 1600, 540);
            setVisible(true);
            //setLayout(null);
            
            //JFrame frame = new JFrame();
            //frame.add(this);
            //frame.setBounds(0, 0, 1920, 1080);
            //frame.setUndecorated(true);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setVisible(true);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
        
	}
//	public static void main(String[] args) {
//		JFrame f= new JFrame();
//		f.setVisible(true);
//		//f.setLayout(null);
//		f.setBounds(0,0,1920,1080);
//		MasterUsersearch a= new MasterUsersearch();
//		//a.setBounds(0,0,1000,500);
//		a.setBorder(new LineBorder(Color.red,1));
//
//		f.add(a);
//		//a.setBounds(0,0,1920,1080);
//		
//		
//	}

}
