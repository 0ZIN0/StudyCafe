package panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import color.MyColor;
import dao.OjdbcConnection;

public class MasterUsersearch extends JPanel{
	
	
	ImageIcon im =new ImageIcon("ui/master/masterUsersearch/Master_UserSearch_Main_Contents.jpg");
	Image image=im.getImage();
	public static JTable table;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	
	public MasterUsersearch(){

        try (Connection connection = OjdbcConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // SQL 쿼리 실행
            ResultSet resultSet = statement.executeQuery("SELECT MEMBER_ID,PHONE_NUMBER,REMAIN_TIME,TO_CHAR(REMAIN_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24:mi:ss'),LOCKER_NUMBER,TO_CHAR(LOCKER_REMAIN_DATE, 'YYYY\"년 \"MM\"월 \"DD\"일\" HH24:mi:ss') FROM member");

            // ResultSet의 메타데이터에서 열 정보 추출
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 열 이름 추출하여 배열로 저장
            String[] columnNames = new String[]{"회원","핸드폰번호","남은시간","종료일","사물함번호", "사물함남은기한"};
//            for (int i = 0; i < columnCount; i++) {
//                columnNames[i] = metaData.getColumnName(i + 1);
//            }
            
            // JTable에 데이터를 표시할 DefaultTableModel 생성
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            
            tableModel = new DefaultTableModel(columnNames, 0) {
    			@Override
    			public boolean isCellEditable(int row, int column) {
    				return false;
    			}
    		};
            
            

            // ResultSet에서 행 데이터 추출하여 DefaultTableModel에 추가
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                   // rowData[i] = resultSet.getObject(i);
                	if (resultSet.getObject(i + 1) == null) {
                		rowData[i] = " ";
                	} else {
                		rowData[i] = " " + resultSet.getObject(i + 1);
                	}
                }
                tableModel.addRow(rowData);
            }

            // JTable 생성 및 표시
            table = new JTable(tableModel);
            
            
            
           
            table.getTableHeader().setPreferredSize(new Dimension(100 ,70));
            table.getTableHeader().setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
            table.setRowHeight(50);
            table.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 20));
            table.getTableHeader().setBackground(new Color(0xB8CFE5));
            table.getTableHeader().setReorderingAllowed(false);
            table.setDragEnabled(false);
            table.setEnabled(true);
            
         // TableCellRenderer를 사용하여 테이블의 특정 셀의 색상 변경
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                               boolean hasFocus, int row, int column) {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    // 클릭된 행의 배경색 변경
                    if (isSelected) {
                        component.setBackground(MyColor.LEMON);
                    } else {
                        component.setBackground(table.getBackground());
                    }
                    return component;
                }
            };
            
            
            
         // 테이블 행 클릭 이벤트 리스너 등록
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        // 클릭된 행을 선택 처리
                        table.setRowSelectionInterval(selectedRow, selectedRow);
                    }
                }
            });
            
            
            table.setDefaultRenderer(Object.class, cellRenderer);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(50, 68, 1600, 640);
            add(scrollPane);
            
            scrollPane.getViewport().setBackground(new Color(0xD9D9D9));
            setLayout(null);
            setVisible(true);
            
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
	}
	
}
