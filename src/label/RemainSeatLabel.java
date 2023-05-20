package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import dao.SeatDAO;

public class RemainSeatLabel extends JLabel {

	public static int remain[] = SeatDAO.isRemain();
	
	public RemainSeatLabel() {

		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		setForeground(Color.WHITE);
		setText(String.format("%02d / %02d",remain[0],remain[1]));
	}
}
