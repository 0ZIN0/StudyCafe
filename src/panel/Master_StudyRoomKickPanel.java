package panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.MyColor;
import dao.KickDAO;

public class Master_StudyRoomKickPanel extends JPanel {
	
	public static DefaultTableModel model = KickDAO.setStudyTable();
	public static JTable table = new JTable(model);
	
	public Master_StudyRoomKickPanel() {

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 20));
		table.getTableHeader().setPreferredSize(new Dimension(100 ,60));
		table.getTableHeader().setBackground(new Color(0xB8CFE5));
		table.getTableHeader().setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		table.setRowHeight(50);
		table.putClientProperty(table, Boolean.FALSE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				// 퇴실조치 컬럼을 클릭했을때
				if (col == 5) {
					Object[] objArr = new Object[table.getColumnCount()];
					
					for (int i = 0; i < table.getColumnCount(); i++) {
						objArr[i] = table.getModel().getValueAt(row, i);
					}
					
					// 원하는 팝업 띄우는 곳
				}
			}
		});

		DefaultTableCellRenderer kick_renderer = new DefaultTableCellRenderer();
		kick_renderer.setHorizontalAlignment(SwingConstants.CENTER);
		kick_renderer.setBackground(new Color(0xFFC7CE));
		kick_renderer.setForeground(new Color(0x9C0006));
		kick_renderer.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));

		table.getColumnModel().getColumn(5).setCellRenderer(kick_renderer);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 1600, 540);
		add(scrollPane);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TableCellRenderer renderer = new MyTableCellRenderer();
		try {
			table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		setBounds(50, 210, 1600, 540);
		setLayout(null);
		setBackground(MyColor.BACKGROUND);
	}
}

class MyTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean 

			isSelected, boolean hasFocus, int row, int column) {

		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (!isSelected) {
			cell.setBackground(new Color(0xEEEEEE));
		} else {
			cell.setBackground(MyColor.LEMON);
		}
		return cell;
	}

}