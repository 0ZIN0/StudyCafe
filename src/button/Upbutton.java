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
	
	LocalDate date = Master_salesPanel.date;
	
	public Upbutton() {
		
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
		
		if(Master_salesPanel.date.equals(LocalDate.now())) {
			Master_salesPanel.yearupBtn.setEnabled(false);
			Master_salesPanel.monthupBtn.setEnabled(false);
			Master_salesPanel.dayupBtn.setEnabled(false);
		}
		
		Master_salesPanel.yearDigitLabel.setText(Integer.toString(Master_salesPanel.date.getYear()));
		Master_salesPanel.monthDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getMonthValue()));
		Master_salesPanel.dayDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getDayOfMonth()));
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		Master_salesPanel.yearAmount.setText(numberFormat.format(TicketOrderDAO.sales_year()) + "원");
		Master_salesPanel.monthAmount.setText(numberFormat.format(TicketOrderDAO.sales_month()) + "원");
		Master_salesPanel.dayAmount.setText(numberFormat.format(TicketOrderDAO.sales_day()) + "원");
	}
}
