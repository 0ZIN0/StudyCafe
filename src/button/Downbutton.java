package button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
		
		Master_salesPanel.yearDigitLabel.setText(Integer.toString(Master_salesPanel.date.getYear()));
		Master_salesPanel.monthDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getMonthValue()));
		Master_salesPanel.dayDigitLabel.setText(String.format("%02d", Master_salesPanel.date.getDayOfMonth()));
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		Master_salesPanel.yearAmount.setText(numberFormat.format(TicketOrderDAO.sales_year()) + "원");
		Master_salesPanel.monthAmount.setText(numberFormat.format(TicketOrderDAO.sales_month()) + "원");
		Master_salesPanel.dayAmount.setText(numberFormat.format(TicketOrderDAO.sales_day()) + "원");
	}
}