package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.ChargeTimeButton;
import dao.TicketDAO;
import dialog.PaymentDialog;
import dialog.TimeOrPeriodChargeDialog;
import dto.Ticket;

public class TimeChargePanel extends JPanel {


	public static int timeChargeItem; 
	public static int timeChargePrice;

	public Ticket ticket;

	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();
	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();
	int studyRoomChargePrice = PaymentDialog.getStudyRoomchargePrice();
	
	GridLayout grid = new GridLayout(2, 2, 20, 20);
	List<ChargeTimeButton> chargeBtns = new ArrayList<>();
	ImageIcon[] basicIcons = new ImageIcon[] {
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_30시간_choice.png"),
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_50시간_choice.png"),
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_100시간_choice.png"),
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_200시간_choice.png")
	};

	ImageIcon[] selectedIcons = new ImageIcon[] { 
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_30시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_50시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_100시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/시간충전권_팝업/Button_200시간_choice_line.png")
	};

	NumberFormat nf = NumberFormat.getNumberInstance();
	
	public TimeChargePanel(JLabel whatName, JLabel NameIs, JLabel howHours, 
			JLabel hours, JLabel howPrice, JLabel priceIs) {

		for(int i = 0; i < basicIcons.length; i++) {
			ChargeTimeButton chargeBtn = new ChargeTimeButton(basicIcons[i]);
			String labelText = "";
			if (i == 0) {
				ticket = TicketDAO.getTicket("T-07");

				timeChargePrice = ticket.getTicket_price();
				labelText = nf.format(timeChargePrice) + "원";
			} else if (i == 1) {
				ticket = TicketDAO.getTicket("T-08");

				timeChargePrice = ticket.getTicket_price();
				labelText = nf.format(timeChargePrice) + "원";
			} else if (i == 2) {
				ticket = TicketDAO.getTicket("T-09");

				timeChargePrice = ticket.getTicket_price();
				labelText = nf.format(timeChargePrice) + "원";
			} else if (i == 3) {
				ticket = TicketDAO.getTicket("T-10");

				timeChargePrice = ticket.getTicket_price();
				labelText = nf.format(timeChargePrice) + "원";
			} 
			
			JLabel label = new JLabel(labelText);
			label.setHorizontalAlignment(JLabel.CENTER);
			chargeBtn.setLayout(new BorderLayout());
			chargeBtn.add(label, BorderLayout.SOUTH);
			Font font3 = new Font("Noto Sans KR Medium", Font.PLAIN, 32);
			label.setFont(font3);
			label.setForeground(new Color(35, 35, 35));

			chargeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					SeatReportPanel.seat_reservation.setUse_ticket_category("시간충전권");
					for(int i = 0; i < chargeBtns.size(); i++) {
						if(chargeBtns.indexOf(e.getSource()) == i) {
							chargeBtns.get(i).setIcon(selectedIcons[i]);

							OnePassChargePanel.onePassChargePrice = 0;
							TimeChargePanel.timeChargePrice  = 0; 
							PeriodChargePanel.periodChargePrice = 0;
							PaymentDialog.studyRoomChargePrice = 0;
							ButtonPanel.lockerChargePrice = 0;

							if (i == 0) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-07");
								ticket = TicketDAO.getTicket("T-07");

								timeChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(timeChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(timeChargePrice) + "원");
								
								timeChargeItem = 30;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(timeChargeItem) + "시간");
								
							} else if (i == 1) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-08");

								ticket = TicketDAO.getTicket("T-08");

								timeChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(timeChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(timeChargePrice) + "원");

								timeChargeItem = 50;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(timeChargeItem) + "시간");

							} else if (i == 2) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-09");
								
								ticket = TicketDAO.getTicket("T-09");

								timeChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(timeChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(timeChargePrice) + "원");

								timeChargeItem = 100;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(timeChargeItem) + "시간");

							} else if (i == 3) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-10");
								
								ticket = TicketDAO.getTicket("T-10");

								timeChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(timeChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(timeChargePrice) + "원");

								timeChargeItem = 200;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(timeChargeItem) + "시간");
							} 
						} else {
							chargeBtns.get(i).setIcon(basicIcons[i]);
						}
					}

					Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
					whatName.setFont(font);
					whatName.setText("결제상품");

					Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
					NameIs.setFont(font1);
					NameIs.setText("시간충전권");

					Font font2 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
					howHours.setFont(font2);
					howHours.setText("이용시간");

					Font font3 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
					howPrice.setFont(font3);
					howPrice.setText("결제금액");
				}
			});
			chargeBtns.add(chargeBtn);
			add(chargeBtn);
			chargeBtn.doClick();

		}
		setBounds(100, 100, 420, 420);
		setBackground(Color.white);
		setLayout(grid);
		setVisible(true);
	}

	public static int getTimeChargeItem() {
		return timeChargeItem;
	}

	public static int getTimeChargePrice() {
		return timeChargePrice;
	}

	public void setTimeChargePrice(int price) {
		timeChargePrice = price;
	}

	public void setTimeChargeItem(int item) {
		timeChargeItem = item;

	}
}

