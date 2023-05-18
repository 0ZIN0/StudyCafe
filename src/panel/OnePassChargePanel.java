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
			new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권_choice.png")	
	};

	ImageIcon[] selectedIcons = new ImageIcon[] { 
			new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간_choice_line.png"),
			new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권_choice_line.png")
	};


	public OnePassChargePanel(JLabel whatName, JLabel NameIs, JLabel howHours, JLabel hours, JLabel howPrice, JLabel priceIs) {

		
		for(int i = 0; i < basicIcons.length; i++) {

			ChargeTimeButton chargeBtn = new ChargeTimeButton(basicIcons[i]);

			String labelText = "";
			if (i == 0) {
				labelText = "5,000원";
			} else if (i == 1) {
				labelText = "6,000원";
			} else if (i == 2) {
				labelText = "7,000원";
			} else if (i == 3) {
				labelText = "9,000원";
			} else if (i == 4) {
				labelText = "12,000원";
			} else if (i == 5) {
				labelText = "15,000원";
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

							TimeChargePanel.timeChargePrice  = 0; 
				        	 OnePassChargePanel.onePassChargePrice = 0;
				        	 PeriodChargePanel.periodChargePrice = 0;
				        	 PaymentDialog.studyRoomChargePrice = 0;
							

							if (i == 0) {
								onePassChargePrice = 5000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 2;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 1) {
								onePassChargePrice = 6000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 3;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 2) {
								onePassChargePrice = 7000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 4;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 3) {
								onePassChargePrice = 9000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 6;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");


							} else if (i == 4) {
								onePassChargePrice = 12000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 8;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText(nf.format(onePassChargeItem) + "시간");

							} else if (i == 5) {
								onePassChargePrice = 15000;
								Font font = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								priceIs.setFont(font);
								priceIs.setText(nf.format(onePassChargePrice) + "원");

								onePassChargeItem = 99;
								Font font1 = new Font("Noto Sans KR Medium", Font.PLAIN, 28);
								hours.setFont(font1);
								hours.setText("종일권(2시까지)");
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

