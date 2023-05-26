package renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import color.MyColor;

public class MyTableCellRenderer extends DefaultTableCellRenderer {

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