package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dialog.MySeatDialog;
import panel.SeatReportPanel;

public class ChangeSeatButton extends JButton {
	
	public ChangeSeatButton(MySeatDialog parent) {

		setIcon(new ImageIcon("ui/myseat/Button_change.png"));
		setBounds(55, 162, 200, 200);
		setBackground(new Color(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				setIcon(new ImageIcon("ui/myseat/Button_change_line.png"));
				SeatReportPanel.seatInfoLabel.setText("원하시는 좌석을 선택해주세요.");
				SeatReportPanel.seatInfoLabel.setBounds(437, 28, 700, 50);
				SeatReportPanel.seatNumLabel.setVisible(false);
			}
		});
	}
}
