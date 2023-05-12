package panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import button.TimeSelectButton;

public class GridPanel extends JPanel {
	
	TimeSelectButton timeSelectBtn;
	
	List<TimeSelectButton> btns = new ArrayList<>();
	
	public GridPanel(JButton upBtn, JButton downBtn) {
		GridLayout grid = new GridLayout(12, 8);
		
		grid.setHgap(3);
		grid.setVgap(3);
		
		for (int i = 0; i < 96; ++i) {
			timeSelectBtn = new TimeSelectButton(upBtn, downBtn);
			btns.add(timeSelectBtn);
			timeSelectBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < btns.size(); ++i) {
						if (btns.indexOf(e.getSource()) != i) {
							btns.get(i).setBackground(new Color(0xD9D9D9));
						}
					}
				}
			});
			add(timeSelectBtn);
		}
		
		
		setBounds(681, 90, 473, 450);
		setBackground(new Color(0x494344));
		setLayout(grid);
	}
}
