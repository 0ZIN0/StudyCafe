package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class RemainStudyRoomLabel extends JLabel {
	
	public RemainStudyRoomLabel() {
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		setForeground(Color.WHITE);
		setText("예약가능");
		setBounds(413, 220, 200, 54);
	}
}
