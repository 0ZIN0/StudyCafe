package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import button.Downbutton;
import button.Upbutton;
import dao.TicketOrderDAO;
import dto.Ticket_order;

public class Master_salesPanel extends JPanel{
	
	public static LocalDate date = LocalDate.now();
	
	public static NumberFormat numberFormat = NumberFormat.getInstance();

	
	public static DefaultTableModel model = TicketOrderDAO.salesTableModel();
	public static JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);

	public static JButton yearupBtn = new Upbutton("year");
	JButton yeardownBtn = new Downbutton("year");	
	public static JButton monthupBtn = new Upbutton("month");
	JButton monthdownBtn = new Downbutton("month");
	public static JButton dayupBtn = new Upbutton("day");
	JButton daydownBtn = new Downbutton("day");
	
	public static JLabel yearDigitLabel = new JLabel(Integer.toString(date.getYear()));
	public static JLabel monthDigitLabel = new JLabel(String.format("%02d", date.getMonthValue()));
	public static JLabel dayDigitLabel = new JLabel(Integer.toString(date.getDayOfMonth()));
	public static JLabel isTodayLabel = new JLabel("TODAY");
	
	JLabel yearLabel = new JLabel("년");
	JLabel monthLabel = new JLabel("월");
	JLabel dayLabel = new JLabel("일");
	
	JLabel yearSales = new JLabel("연매출 : ");
	JLabel monthSales = new JLabel("월매출 : ");
	JLabel daySales = new JLabel("일매출 : ");
	
	public static JLabel yearAmount = new JLabel(numberFormat.format(TicketOrderDAO.sales_year()) + "원");
	public static JLabel monthAmount = new JLabel(numberFormat.format(TicketOrderDAO.sales_month()) + "원");
	public static JLabel dayAmount = new JLabel(numberFormat.format(TicketOrderDAO.sales_day()) + "원");
	
	
	
	public Master_salesPanel() {
		
		// date label
		yearDigitLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearDigitLabel.setBounds(960, 47, 110, 58);
		yearDigitLabel.setForeground(Color.white);
		
		yearLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearLabel.setBounds(1090, 25, 200, 100);
		yearLabel.setForeground(Color.white);
		
		monthDigitLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthDigitLabel.setBounds(1190, 25, 200, 100);
		monthDigitLabel.setForeground(Color.white);
		
		monthLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthLabel.setBounds(1270, 25, 200, 100);
		monthLabel.setForeground(Color.white);
		
		dayDigitLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		dayDigitLabel.setBounds(1370, 25, 200, 100);
		dayDigitLabel.setForeground(Color.white);
		
		dayLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		dayLabel.setBounds(1470, 25, 200, 100);
		dayLabel.setForeground(Color.white);
		
		isTodayLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 24));
		isTodayLabel.setBounds(1550, 60, 80, 28);
		isTodayLabel.setForeground(new Color(0xFF5C00));
		
		daySales.setBounds(100, 700, 150, 50);
		daySales.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		daySales.setForeground(new Color(0xFF5C00));
		
		dayAmount.setBounds(250, 700, 300, 50);
		dayAmount.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		dayAmount.setForeground(new Color(0xFF5C00));
		
		monthSales.setBounds(630, 700, 150, 50);
		monthSales.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthSales.setForeground(new Color(0xFF5C00));
		
		monthAmount.setBounds(780, 700, 300, 50);
		monthAmount.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthAmount.setForeground(new Color(0xFF5C00));
		
		yearSales.setBounds(1180, 700, 150, 50);
		yearSales.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearSales.setForeground(new Color(0xFF5C00));
		
		yearAmount.setBounds(1330, 700, 300, 50);
		yearAmount.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearAmount.setForeground(new Color(0xFF5C00));
		
		add(isTodayLabel);
		add(yearDigitLabel);
		add(yearLabel);
		add(monthDigitLabel);
		add(monthLabel);
		add(dayDigitLabel);
		add(dayLabel);
		
		add(yearSales);
		add(yearAmount);
		add(monthSales);
		add(monthAmount);
		add(daySales);
		add(dayAmount);
		/*******************************************************************************/
		
		//buttons
		yearupBtn.setBounds(988, 32, 34, 25);
		yeardownBtn.setBounds(988, 105, 34, 25);
		
		monthupBtn.setBounds(1194, 32, 34, 25);
		monthdownBtn.setBounds(1194, 105, 34, 25);
		
		dayupBtn.setBounds(1374, 32, 34, 25);
		daydownBtn.setBounds(1374, 105, 34, 25);
	
		add(yearupBtn);
		add(yeardownBtn);
		add(monthupBtn);
		add(monthdownBtn);
		add(dayupBtn);
		add(daydownBtn);
		
		/*******************************************************************************/
		
		// table settings
		table.getTableHeader().setPreferredSize(new Dimension(100 ,50));
		table.getTableHeader().setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		table.setRowHeight(50);
		table.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 20));
		table.setBackground(new Color(0xEEEEEE));
		table.setCellSelectionEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDragEnabled(false);
		table.setEnabled(false);
		/*******************************************************************************/
		
		// scrollPane settings
		scrollPane.setBounds(50,150, 1600, 540);
		add(scrollPane);
		
		// this Panel settings
		setLayout(null);
		setOpaque(false);
		setSize(1700,800);
	}
}
