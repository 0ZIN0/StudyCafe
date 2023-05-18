package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import dao.SeatDAO;
import dto.Seat;

public class VacatedMainPanel extends JPanel {
	
	List<int[]> remainTime = SeatDAO.leaveSeat();
	public VacatedMainPanel() {
		for(int i = 0; i < remainTime.size(); i++) {
			VacatedMiniPanel miniPanel = new VacatedMiniPanel(remainTime, i);
			add(miniPanel);
		}
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 636, 526);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
	}
}
