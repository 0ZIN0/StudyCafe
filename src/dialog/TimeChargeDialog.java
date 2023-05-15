package dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.ChargeTimeButton;
import panel.OnePassChargePanel;
import panel.TimeChargePanel;

public class TimeChargeDialog extends JDialog {


	
	
	JLabel whatName = new JLabel();
	JLabel nameIs = new JLabel();
	JLabel howHours = new JLabel();
	JLabel hours = new JLabel();
	JLabel howPrice = new JLabel();
	JLabel priceIs = new JLabel();

	
	TimeChargePanel ticketPanel = new TimeChargePanel(whatName, nameIs, howHours, hours, howPrice, priceIs);

	public TimeChargeDialog() {

		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/일회이용권/SeatUse_PopUp.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};


		ticketPanel.setLocation(53, 400);
		add(ticketPanel);

		ChargeTimeButton CloseButton = new ChargeTimeButton(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
		CloseButton.setBounds(207, 842, 150, 80);
		add(CloseButton);
		CloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketPanel.setTimeChargePrice(0);
				dispose();
			}
		});

		JButton NextButton = new JButton (new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));  // 다음버튼, (결제버튼)
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setBounds(375, 842, 150, 80);
		add(NextButton);	
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaymentInformationDialog paymentInformationDialog = new PaymentInformationDialog();
			}
		});

		whatName.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		whatName.setForeground(new Color(35, 35, 35));
		whatName.setBounds(230, 172, 200, 35);
		add(whatName);

		nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		nameIs.setForeground(new Color(35, 35, 35));
		nameIs.setBounds(382, 172, 200, 35);
		add(nameIs);

		howHours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		howHours.setForeground(new Color(35, 35, 35));
		howHours.setBounds(230, 225, 200, 35);
		howHours.setName("label");
		add(howHours);

		hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		hours.setForeground(new Color(35, 35, 35));
		hours.setBounds(382, 225, 200, 35);
		hours.setName("label");
		add(hours);

		howPrice.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		howPrice.setForeground(new Color(35, 35, 35));
		howPrice.setBounds(230, 278, 200, 35);
		howPrice.setName("label");
		add(howPrice);

		priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		priceIs.setForeground(new Color(35, 35, 35));
		priceIs.setBounds(382, 278, 200, 35);
		priceIs.setName("label");
		add(priceIs);

		background.setBackground(new Color(0,0,0,0));
		//background.setBackground(Color.blue);
		add(background);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 60, 750, 960);
		setVisible(true);
	}




}

