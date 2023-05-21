package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import dao.SeatDAO;
import frame.CheckInFrame;
import panel.SeatReportPanel;

public class SeatReportLabel extends JLabel {
	
	public SeatReportLabel() {

		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		setForeground(Color.WHITE);
		
		if (SeatReportPanel.mySeat == 0) {
			setText("사용중인 좌석이 없습니다.");
			setBounds(507, 28, 550, 50);
		} else {
			setText(SeatReportPanel.mySeat + "번 좌석을 사용중입니다.");
			setBounds(507, 28, 550, 50);
		}
	}
}
