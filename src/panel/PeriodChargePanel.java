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
import dialog.PaymentDialog;
import dialog.TimeOrPeriodChargeDialog;

public class PeriodChargePanel extends JPanel {

	public static int periodChargeItem; 
	public static int periodChargePrice;

	//int onePassChargeItem = OnePassChargePanel.getOnePassChargeItem();
	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();

	int timeChargePrice = TimeChargePanel.getTimeChargePrice();

	int studyRoomChargePrice = PaymentDialog.getStudyRoomchargePrice();

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


	public PeriodChargePanel(JLabel whatName, JLabel NameIs, JLabel howHours, JLabel hours, JLabel howPrice, JLabel priceIs) {


		for(int i = 0; i < basicIcons.length; i++) {

			ChargeTimeButton chargeBtn = new ChargeTimeButton(basicIcons[i]);

			String labelText = "";
			if (i == 0) {
				labelText = "90,000원";
			} else if (i == 1) {
				labelText = "160,000원";
			} else if (i == 2) {
				labelText = "300,000원";
			} else if (i == 3) {
				labelText = "420,000원";
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
					for(int i = 0; i < chargeBtns.size(); i++) {



						if(chargeBtns.indexOf(e.getSource()) == i) {

							chargeBtns.get(i).setIcon(selectedIcons[i]);

							NumberFormat nf = NumberFormat.getNumberInstance();

							OnePassChargePanel.onePassChargePrice = 0;
							TimeChargePanel.timeChargePrice  = 0; 
							PeriodChargePanel.periodChargePrice = 0;
							PaymentDialog.studyRoomChargePrice = 0;
							ButtonPanel.lockerChargePrice = 0;


							if (i == 0) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("TI-11");
								periodChargePrice = 90000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 2;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");

							} else if (i == 1) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("TI-12");
								periodChargePrice = 160000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 4;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");

							} else if (i == 2) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("TI-13");
								periodChargePrice = 300000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(periodChargePrice) + "원");

								periodChargeItem = 8;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(periodChargeItem) + "주");

							} else if (i == 3) {
								TimeOrPeriodChargeDialog.ticket_order.setTicket_id("TI-14");
								periodChargePrice = 420000;
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

