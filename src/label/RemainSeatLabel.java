package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import dao.SeatDAO;

public class RemainSeatLabel extends JLabel {
	
	public RemainSeatLabel() {

		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		setForeground(Color.WHITE);
		int remain[] = SeatDAO.isRemain();
		setText(remain[0] + " / " + remain[1]);
	}
}
