package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import dao.SeatDAO;
import frame.CheckInFrame;

public class SeatReportLabel extends JLabel {
	
	int mySeat = SeatDAO.isUsingMySeat(CheckInFrame.member.getMember_id());
	
	public SeatReportLabel() {

		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		setForeground(Color.WHITE);
		
		if (mySeat == 0) {
			setText("사용중인 좌석이 없습니다.");
			setBounds(507, 28, 550, 50);
		} else {
			setText("번 좌석을 사용중입니다.");
			setBounds(537, 28, 550, 50);
		}
	}
}
