package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class SeatReportLabel extends JLabel {
	
	boolean mySeat;
	
	public SeatReportLabel() {

		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		setForeground(Color.WHITE);
		setBounds(457, 28, 550, 50);
		
		if (!mySeat) {
			setText("사용 중인 좌석이 없습니다.");
		} else {
			// 사용자가 사용 중인 좌석이 존재할때 적용할 곳 
			// DB에서 사용자가 이용하고 있는 좌석 가져옴
		}
		
	}
}
