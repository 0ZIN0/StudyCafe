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

public class OnePassChargePanel extends JPanel {

	public static int onePassChargeItem; 
	public static int onePassChargePrice;
	
	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();

	int timeChargePrice = TimeChargePanel.getTimeChargePrice();
	
	int studyRoomChargePrice = PaymentDialog.getStudyRoomchargePrice();
	
	
	GridLayout grid = new GridLayout(2, 3, 20, 20);
	List<ChargeTimeButton> chargeBtns = new ArrayList<>();
	ImageIcon[] basicIcons = new ImageIcon[] {
			new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간_choice.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간_choice.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간_choice.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간_choice.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간_choice.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권_choice_revision.png")	
	};

	ImageIcon[] selectedIcons = new ImageIcon[] { 
			new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권_choice_line_revision.png")
	};
	
	Ticket ticket;
	NumberFormat nf = NumberFormat.getNumberInstance();
	
	public OnePassChargePanel(JLabel whatName, JLabel NameIs, JLabel howHours, JLabel hours, JLabel howPrice, JLabel priceIs) {

		
		for(int i = 0; i < basicIcons.length; i++) {

			ChargeTimeButton chargeBtn = new ChargeTimeButton(basicIcons[i]);

			String labelText = "";
			if (i == 0) {
				ticket = TicketDAO.getTicket("T-01");

				onePassChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(onePassChargePrice) + "원";
			} else if (i == 1) {
				ticket = TicketDAO.getTicket("T-02");

				onePassChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(onePassChargePrice) + "원";
			} else if (i == 2) {
				ticket = TicketDAO.getTicket("T-03");

				onePassChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(onePassChargePrice) + "원";
			} else if (i == 3) {
				ticket = TicketDAO.getTicket("T-04");

				onePassChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(onePassChargePrice) + "원";
			} else if (i == 4) {
				ticket = TicketDAO.getTicket("T-05");

				onePassChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(onePassChargePrice) + "원";
			} else if (i == 5) {
				ticket = TicketDAO.getTicket("T-06");

				onePassChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(onePassChargePrice) + "원";
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
					
					SeatReportPanel.seat_reservation.setUse_ticket_category("일회이용권");
					
					for(int i = 0; i < chargeBtns.size(); i++) {
						if(chargeBtns.indexOf(e.getSource()) == i) {
							chargeBtns.get(i).setIcon(selectedIcons[i]);
							
							OnePassChargePanel.onePassChargePrice = 0;
							TimeChargePanel.timeChargePrice  = 0; 
							PeriodChargePanel.periodChargePrice = 0;
							PaymentDialog.studyRoomChargePrice = 0;
							ButtonPanel.lockerChargePrice = 0;
							
							if (i == 0) {
								
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-01");
								ticket = TicketDAO.getTicket("T-01");

								onePassChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(onePassChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 2;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 1) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-02");
								
								ticket = TicketDAO.getTicket("T-02");
								
								onePassChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(onePassChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 3;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 2) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-03");
								
								ticket = TicketDAO.getTicket("T-03");

								onePassChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(onePassChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 4;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 3) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-04");
								
								ticket = TicketDAO.getTicket("T-04");

								onePassChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(onePassChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 6;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");


							} else if (i == 4) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-05");
								
								ticket = TicketDAO.getTicket("T-05");

								onePassChargePrice = ticket.getTicket_price();
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(onePassChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 8;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 5) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-06");

								ticket = TicketDAO.getTicket("T-06");

								onePassChargePrice = ticket.getTicket_price();	
								TimeOrPeriodChargeDialog.ticket_order.setOrder_total_price(onePassChargePrice);
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 99;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText("종일권");
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
					NameIs.setText("일회이용권");

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
		setSize(640, 420);
		setBackground(Color.white);
		setLayout(grid);
		setVisible(true);
	}

	public static  int getOnePassChargeItem() {
		return onePassChargeItem;
	}
	
	public static  int getOnePassChargePrice() {
		return onePassChargePrice;
	}

	public void setOnePassChargePrice(int price) {
		onePassChargePrice = price;
	}
	
	public void setOnePassChargeItem(int item) {
		onePassChargeItem = item;
	}

	
	

}

