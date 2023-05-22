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

	public TimeChargeDialog(String lockerNum) {

		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/시간충전권_팝업/시간충전권_팝업.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};


		ticketPanel.setLocation(160, 400);
		add(ticketPanel);

		ChargeTimeButton closeButton = new ChargeTimeButton(new ImageIcon("ui/결제 팝업/버튼_수정/CloseButton.png"));
		closeButton.setBounds(210, 842, 150, 100);
		add(closeButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton nextButton = new JButton (new ImageIcon("ui/결제 팝업/버튼_수정/NextButton.png"));  // 다음버튼, (결제버튼)
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setBounds(380, 842, 150, 100);
		add(nextButton);	
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaymentInformationDialog paymentInformationDialog = new PaymentInformationDialog(lockerNum);
			}
		});

		whatName.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		whatName.setForeground(new Color(35, 35, 35));
		whatName.setBounds(255, 177, 200, 35);
		add(whatName);

		nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		nameIs.setForeground(new Color(35, 35, 35));
		nameIs.setBounds(391, 177, 200, 35);
		add(nameIs);

		howHours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		howHours.setForeground(new Color(35, 35, 35));
		howHours.setBounds(255, 230, 200, 35);
		howHours.setName("label");
		add(howHours);

		hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		hours.setForeground(new Color(35, 35, 35));
		hours.setBounds(391, 230, 200, 35);
		hours.setName("label");
		add(hours);

		howPrice.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		howPrice.setForeground(new Color(35, 35, 35));
		howPrice.setBounds(255, 284, 200, 35);
		howPrice.setName("label");
		add(howPrice);

		priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		priceIs.setForeground(new Color(35, 35, 35));
		priceIs.setBounds(391, 284, 200, 35);
		priceIs.setName("label");
		add(priceIs);

		background.setBackground(new Color(0,0,0,0));
		background.setBounds(0, 0, 750, 960);
		add(background);
		setLayout(null);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 60, 750, 960);
		setVisible(true);
	}




}

