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
import dialog.TimeOrPeriodChargeDialog;
import dto.Ticket;

public class PeriodChargePanel extends JPanel {

	public static int periodChargeItem; 
	public static int periodChargePrice;
	
	GridLayout grid = new GridLayout(2, 2, 20, 20);
	List<ChargeTimeButton> chargeBtns = new ArrayList<>();
	ImageIcon[] basicIcons = new ImageIcon[] {
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_2Weeks_choice.png"),
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_4Weeks_choice.png"),
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_8Weeks_choice.png"),
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_12Weeks_choice.png")
	};

	ImageIcon[] selectedIcons = new ImageIcon[] { 
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_2Weeks_choice_line.png"),
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_4Weeks_choice_line.png"),
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_8Weeks_choice_line.png"),
			new ImageIcon("ui/결제 팝업/기간이용권_팝업/Button_12Weeks_choice_line.png")
	};

	Ticket ticket;
	NumberFormat nf = NumberFormat.getNumberInstance();
	
	public PeriodChargePanel(JLabel whatName, JLabel NameIs, JLabel howHours, JLabel hours, JLabel howPrice, JLabel priceIs) {

		
		for(int i = 0; i < basicIcons.length; i++) {

			ChargeTimeButton chargeBtn = new ChargeTimeButton(basicIcons[i]);

			String labelText = "";
			if (i == 0) {
				ticket = TicketDAO.getTicket("T-11");

				periodChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(periodChargePrice) + "원";
			} else if (i == 1) {
				ticket = TicketDAO.getTicket("T-12");

				periodChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(periodChargePrice) + "원";
			} else if (i == 2) {
				ticket = TicketDAO.getTicket("T-13");

				periodChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(periodChargePrice) + "원";
			} else if (i == 3) {
				ticket = TicketDAO.getTicket("T-14");

				periodChargePrice = ticket.getTicket_price();
				
				labelText = nf.format(periodChargePrice) + "원";
			}
			JLabel label = new JLabel(labelText);
			label.setHorizontalAlignment(JLabel.CENTER);
			chargeBtn.setLayout(new BorderLayout());
			chargeBtn.add(label, BorderLayout.SOUTH);
			Font font3 = new Font("Noto Sans KR Medium", Font.PLAIN, 32);
			label.setFont(font3);

			chargeBtn.addActionListener(new ActionListener() {




				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i < chargeBtns.size(); i++) {


						if(chargeBtns.indexOf(e.getSource()) == i) {

							chargeBtns.get(i).setIcon(selectedIcons[i]);

							periodChargeItem = 0;
							periodChargePrice = 0;


							if (i == 0) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-11");
								ticket = TicketDAO.getTicket("T-11");

								periodChargePrice = ticket.getTicket_price();
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 2;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");

							} else if (i == 1) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-12");
								
								ticket = TicketDAO.getTicket("T-12");

								periodChargePrice = ticket.getTicket_price();
								
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 4;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");

							} else if (i == 2) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-13");
								
								ticket = TicketDAO.getTicket("T-13");

								periodChargePrice = ticket.getTicket_price();
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 8;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");

							} else if (i == 3) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("T-14");

								ticket = TicketDAO.getTicket("T-14");

								periodChargePrice = ticket.getTicket_price();
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 12;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");


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
					NameIs.setText("기간이용권");

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

	public static int getPeriodChargeItem() {
		return periodChargeItem;
	}
	
	public static int getPeriodChargePrice() {
		return periodChargePrice;
	}
	
	public void setPeriodChargePrice(int price) {
		periodChargePrice = price;
	}
	
	public void setPeriodChargeItem(int item) {
		periodChargeItem = item;
		
	}

}

