package button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import dao.TicketOrderDAO;
import panel.Master_salesPanel;

public class Upbutton extends JButton implements ActionListener{
	
	String type;
	LocalDate date = Master_salesPanel.date;
	
	public Upbutton(String type) {
		
		this.type = type;
		setEnabled(false);
		
		addActionListener(this);
		
		setIcon(new ImageIcon("ui/study_room/TimeUp_Button_01.png"));
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(type.equals("year")) {
			Master_salesPanel.date = Master_salesPanel.date.plusYears(1);
		} else if(type.equals("month")) {
			Master_salesPanel.date = Master_salesPanel.date.plusMonths(1);

		} else {
			Master_salesPanel.date = Master_salesPanel.date.plusDays(1);

		}
		Master_salesPanel.yearDigitLabel.setText(Integer.toString(Master_salesPanel.date.getYear()));
		Master_salesPanel.monthDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getMonthValue()));
		Master_salesPanel.dayDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getDayOfMonth()));
		
		if(Master_salesPanel.date.equals(LocalDate.now())) {
			Master_salesPanel.isTodayLabel.setVisible(true);
			Master_salesPanel.yearupBtn.setEnabled(false);
			Master_salesPanel.monthupBtn.setEnabled(false);
			Master_salesPanel.dayupBtn.setEnabled(false);
		} else {
			Master_salesPanel.isTodayLabel.setVisible(false);
		}
		
		Master_salesPanel.table.setModel(TicketOrderDAO.salesTableModel());
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		Master_salesPanel.yearAmount.setText(numberFormat.format(TicketOrderDAO.sales_year()) + "원");
		Master_salesPanel.monthAmount.setText(numberFormat.format(TicketOrderDAO.sales_month()) + "원");
		Master_salesPanel.dayAmount.setText(numberFormat.format(TicketOrderDAO.sales_day()) + "원");
	}
}
