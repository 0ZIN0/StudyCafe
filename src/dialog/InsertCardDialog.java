package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.TicketDAO;
import dao.TicketOrderDAO;
import panel.ButtonPanel;
import panel.OnePassChargePanel;
import panel.PeriodChargePanel;
import panel.TimeChargePanel;

public class InsertCardDialog extends JDialog {
	
	int timeChargePrice = TimeChargePanel.getTimeChargePrice();
	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();
	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();
	int studyRoomChargePrice = PaymentDialog.getStudyRoomchargePrice();
	int lockerChargePrice = ButtonPanel.getLockerChargePrice();
	static int amountPaid; 
	
	public InsertCardDialog() {

		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_CreditCard_3/Payment_CreditCard.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		JButton closeButton = new JButton(new ImageIcon("ui/button/CloseButton.png"));

		JLabel howPrice = new JLabel();
		howPrice.setText("결제하실 금액");
		howPrice.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 32));
		howPrice.setForeground(new Color(35, 35, 35));
		howPrice.setBounds(200, 115, 200, 200);
		howPrice.setName("label");
		add(howPrice);


		if (onePassChargePrice != 0) {
			JLabel priceIs = new JLabel();
			priceIs.setText(String.format("%,d원", onePassChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 35));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(430, 115, 200, 200);
			priceIs.setName("label");
			add(priceIs);
		} 
		
		else if (timeChargePrice != 0) {
			JLabel priceIs = new JLabel();
			priceIs.setText(String.format("%,d원", timeChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 35));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(430, 115, 200, 200);
			priceIs.setName("label");
			add(priceIs);
		}
		
		else if (periodChargePrice != 0 ) {
			JLabel priceIs = new JLabel();
			priceIs.setText(String.format("%,d원", periodChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 35));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(430, 115, 200, 200);
			priceIs.setName("label");
			add(priceIs);
		}
		
		else if (studyRoomChargePrice == TicketDAO.getTicket("T-15").getTicket_price()) {
			JLabel priceIs = new JLabel();
			priceIs.setText(String.format("%,d원", studyRoomChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 35));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(430, 115, 200, 200);
			priceIs.setName("label");
			add(priceIs);
		}
		
		else if (studyRoomChargePrice == TicketDAO.getTicket("T-16").getTicket_price()) {
			JLabel priceIs = new JLabel();
			priceIs.setText(String.format("%,d원", studyRoomChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 35));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(430, 115, 200, 200);
			priceIs.setName("label");
			add(priceIs);
		}
		
		else if (lockerChargePrice != 0) {
			JLabel priceIs = new JLabel();
			priceIs.setText(String.format("%,d원", lockerChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 35));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(430, 115, 200, 200);
			priceIs.setName("label");
			add(priceIs);
		}
		
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (onePassChargePrice != 0) {
					amountPaid = onePassChargePrice;
				} 
				
				if (timeChargePrice != 0) {
					amountPaid = timeChargePrice;
				}
				
				if (periodChargePrice != 0) {
					amountPaid = periodChargePrice;
				}
				
				if (studyRoomChargePrice != 0) {
					amountPaid = studyRoomChargePrice;
				}
				
				if (lockerChargePrice != 0) {
					amountPaid = lockerChargePrice;
				}

				dispose();

				CompletePaymentDialog completePaymentDialog = new CompletePaymentDialog(); 
			}
		});

		closeButton.setBounds(300, 874, 158, 88);


		add(closeButton);


		background.setBackground(new Color(0,0,0,0));
		add(background);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 40, 750, 1000);
		setVisible(true);
	}

	public static int getAmountPaid() {
		return amountPaid;
	}
}

