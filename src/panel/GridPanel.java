package panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import button.TimeSelectButton;
import label.StartTimeLabel;

public class GridPanel extends JPanel {

	TimeSelectButton timeSelectBtn;

	LocalTime time = LocalTime.of(0, 0); // timeSelectBtn에 넣을 시간의 default값
	List<TimeSelectButton> btns = new ArrayList<>();

	public GridPanel(JButton upBtn, JButton downBtn, StartTimeLabel startTimeLabel) {
		GridLayout grid = new GridLayout(12, 8);

		grid.setHgap(3);
		grid.setVgap(3);

		for (int i = 0; i < 96; ++i) {
			timeSelectBtn = new TimeSelectButton(upBtn, downBtn, startTimeLabel);
			btns.add(timeSelectBtn);
			timeSelectBtn.setTime(time.plusMinutes(i * 15));
			if (timeSelectBtn.getTime().compareTo(LocalTime.of(22, 00)) > 0) {
				timeSelectBtn.setEnabled(false);
			}
			
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
