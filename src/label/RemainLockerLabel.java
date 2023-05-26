package label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import dao.LockerDAO;
import dao.SeatDAO;

public class RemainLockerLabel extends JLabel {
	
	int remain = LockerDAO.remainLocker();

	public RemainLockerLabel() {
		
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		setForeground(Color.WHITE);
		setText(String.format("%02d / %02d", remain, 20));
	} 
}
