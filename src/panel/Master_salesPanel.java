package panel;

import java.awt.BorderLayout;
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
import color.MyColor;
import dao.TicketOrderDAO;
import dto.Ticket_order;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class Master_salesPanel extends JPanel{
	
	public static LocalDate date = LocalDate.now();
	
	public static NumberFormat numberFormat = NumberFormat.getInstance();
	
	public static DefaultTableModel model = TicketOrderDAO.salesTableModel();
	public static JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);

	public static JButton yearupBtn = new Upbutton("year");
	public static JButton monthupBtn = new Upbutton("month");
	public static JButton dayupBtn = new Upbutton("day");
	JButton yeardownBtn = new Downbutton("year");	
	JButton monthdownBtn = new Downbutton("month");
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
	
	JPanel panel = new BackgroundPanel(new ImageIcon("ui/master/amount_panel.png"));
	
	public Master_salesPanel() {
		panel.setBackground(new Color(23, 23, 23));
		panel.setBounds(50, 160, 1600, 60);
		add(panel);
		panel.setLayout(new GridLayout(0, 6, 0, 0));
		
		// date label
		yearDigitLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearDigitLabel.setBounds(1070, 48, 110, 58);
		yearDigitLabel.setForeground(Color.white);
		
		yearLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearLabel.setBounds(1170, 25, 200, 100);
		yearLabel.setForeground(Color.white);
		
		monthDigitLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthDigitLabel.setBounds(1260, 28, 200, 100);
		monthDigitLabel.setForeground(Color.white);
		
		monthLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthLabel.setBounds(1320, 25, 200, 100);
		monthLabel.setForeground(Color.white);
		
		dayDigitLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		dayDigitLabel.setBounds(1410, 28, 200, 100);
		dayDigitLabel.setForeground(Color.white);
		
		dayLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		dayLabel.setBounds(1470, 25, 200, 100);
		dayLabel.setForeground(Color.white);
		
		isTodayLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		isTodayLabel.setBounds(1540, 60, 100, 28);
		isTodayLabel.setForeground(new Color(0xFF5C00));
		
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
		
		daySales.setHorizontalAlignment(SwingConstants.CENTER);
		daySales.setBackground(Color.WHITE);
		daySales.setBounds(100, 700, 150, 50);
		daySales.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		daySales.setForeground(new Color(23, 23, 23));
		panel.add(daySales);
		
		dayAmount.setBounds(250, 700, 300, 50);
		dayAmount.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		dayAmount.setForeground(new Color(0xFF5C00));
		panel.add(dayAmount);
		
		monthSales.setHorizontalAlignment(SwingConstants.CENTER);
		monthSales.setBounds(630, 700, 150, 50);
		monthSales.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthSales.setForeground(new Color(23, 23, 23));
		panel.add(monthSales);
		
		monthAmount.setBounds(780, 700, 300, 50);
		monthAmount.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		monthAmount.setForeground(new Color(0xFF5C00));
		panel.add(monthAmount);
		
		yearSales.setHorizontalAlignment(SwingConstants.CENTER);
		yearSales.setBounds(1180, 700, 150, 50);
		yearSales.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 36));
		yearSales.setForeground(new Color(23, 23, 23));
		
		panel.add(yearSales);
		panel.add(yearAmount);
		/*******************************************************************************/
		
		//buttons
		yearupBtn.setBounds(1100, 34, 34, 25);
		yeardownBtn.setBounds(1100, 105, 34, 25);
		
		monthupBtn.setBounds(1265, 34, 34, 25);
		monthdownBtn.setBounds(1265, 105, 34, 25);
		
		dayupBtn.setBounds(1415, 34, 34, 25);
		daydownBtn.setBounds(1415, 105, 34, 25);
	
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
		table.getTableHeader().setBackground(new Color(0xB8CFE5));
		table.setCellSelectionEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDragEnabled(false);
		table.setEnabled(false);
		/*******************************************************************************/
		
		// scrollPane settings
		scrollPane.setBounds(50,250, 1600, 540);
		scrollPane.getViewport().setBackground(new Color(0XD9D9D9));
		add(scrollPane);
		
		// Panel settings
		setLayout(null);
		setOpaque(false);
		setSize(1700,760);
		
		
	}
}
