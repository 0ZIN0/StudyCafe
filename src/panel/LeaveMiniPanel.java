package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import color.MyColor;
import dto.Seat;

public class LeaveMiniPanel extends JPanel {
	
	JLabel seatLabel = new JLabel();
	JLabel remainTimeLabel = new JLabel();
	JPanel backPanel = new JPanel();
	
	public LeaveMiniPanel(List<int[]> remainTime, int i) {
		
		backPanel.setBackground(Color.WHITE);
		backPanel.setBounds(3, 3, 620, 90);
		backPanel.setVisible(true);
		backPanel.setLayout(null);
		add(backPanel);
		
		backPanel.add(seatLabel);
		seatLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		seatLabel.setText(remainTime.get(i)[0] + "번");
		seatLabel.setBounds(140, 20, 100, 50);
		
		backPanel.add(remainTimeLabel);
		remainTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		remainTimeLabel.setText(remainTime.get(i)[1] + "분");
		remainTimeLabel.setBounds(447, 20, 100, 50);
		
		setPreferredSize(new Dimension(300, 100));
		setLayout(null);
		setBorder(new LineBorder(MyColor.BLACK));
		setSize(630, 100);
		setBackground(Color.WHITE);
		setVisible(true);
	}
}
