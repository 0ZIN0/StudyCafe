package panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import button.TimeSelectButton;

public class GridPanel extends JPanel {
	
	TimeSelectButton timeSelectBtn;
	
	public GridPanel() {
		GridLayout grid = new GridLayout(12, 8);
		
		grid.setHgap(3);
		grid.setVgap(3);
		
		for (int i = 0; i < 96; ++i) {
			timeSelectBtn = new TimeSelectButton();
			add(timeSelectBtn);
		}
		
		setBounds(681, 90, 473, 450);
		setBackground(new Color(0x494344));
		setLayout(grid);
	}
}
