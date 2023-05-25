package button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import dao.TicketOrderDAO;
import panel.Master_salesPanel;

public class Downbutton extends JButton implements ActionListener{
	
	String type;
	
	public Downbutton(String type) {
		
		this.type = type;
		
		addActionListener(this);
		
		setIcon(new ImageIcon("ui/study_room/TimeUp_Button_02.png"));
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(type.equals("year")) {
			Master_salesPanel.date = Master_salesPanel.date.minusYears(1);
		} else if(type.equals("month")) {
			Master_salesPanel.date = Master_salesPanel.date.minusMonths(1);

		} else {
			Master_salesPanel.date = Master_salesPanel.date.minusDays(1);

		}
		Master_salesPanel.yearDigitLabel.setText(Integer.toString(Master_salesPanel.date.getYear()));
		Master_salesPanel.monthDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getMonthValue()));
		Master_salesPanel.dayDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getDayOfMonth()));
		
		if(Master_salesPanel.date.equals(LocalDate.now())) {
			Master_salesPanel.isTodayLabel.setVisible(true);
		} else {
			Master_salesPanel.isTodayLabel.setVisible(false);
			Master_salesPanel.yearupBtn.setEnabled(true);
			Master_salesPanel.monthupBtn.setEnabled(true);
			Master_salesPanel.dayupBtn.setEnabled(true);
		}
		
		Master_salesPanel.table.setModel(TicketOrderDAO.salesTableModel());
	}
}