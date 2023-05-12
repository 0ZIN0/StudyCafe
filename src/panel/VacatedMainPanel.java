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
	
	
	public VacatedMainPanel(List<Seat> seats) {
		System.out.println(seats.size());
		for(int i = 0; i < seats.size(); i++) {
			Seat seat = seats.get(i);
			VacatedMiniPanel miniPanel = new VacatedMiniPanel(seat);
			add(miniPanel);
		}
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 636, 526);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
	}
}
