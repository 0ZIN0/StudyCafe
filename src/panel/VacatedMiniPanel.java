package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dto.Seat;

public class VacatedMiniPanel extends JPanel {
	
	JLabel seatLabel = new JLabel();
	JLabel remainTimeLabel = new JLabel();
	
	public VacatedMiniPanel(Seat seat) {
		JPanel backPanel = new JPanel();
		backPanel.setBackground(Color.WHITE);
		backPanel.setBounds(3, 3, 620, 90);
		backPanel.setVisible(true);
		backPanel.setLayout(null);
		add(backPanel);
		
		backPanel.add(seatLabel);
		seatLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		seatLabel.setText(seat.getSeat_id());
		seatLabel.setBounds(140, 20, 100, 50);
		
		backPanel.add(remainTimeLabel);
		remainTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		remainTimeLabel.setText(seat.getRemain_time()+ "분");
		remainTimeLabel.setBounds(447, 20, 100, 50);
		
		setPreferredSize(new Dimension(300, 100));
		setLayout(null);
		setBorder(new LineBorder(Color.BLACK, 2));
		setSize(630, 100);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public JLabel getRemainTimeLabel() {
		return remainTimeLabel;
	}
}
