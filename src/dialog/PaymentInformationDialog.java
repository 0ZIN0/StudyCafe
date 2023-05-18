package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.CheckInFrame;
import panel.OnePassChargePanel;
import panel.PeriodChargePanel;
import panel.TimeChargePanel;

public class PaymentInformationDialog extends JDialog { 


	int onePassChargeItem = OnePassChargePanel.getOnePassChargeItem();
	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();

	int timeChargeItem = TimeChargePanel.getTimeChargeItem();
	int timeChargePrice = TimeChargePanel.getTimeChargePrice();
	
	int periodChargeItem = PeriodChargePanel.getPeriodChargeItem();
	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();
	
	int studyRoomChargePrice = PaymentDialog.getStudyRoomchargePrice();

	
	private ImageIcon check;


	public PaymentInformationDialog() {


		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_Default_1/SeatUse_Pay_info_default_1_revision.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};


		check = new ImageIcon("ui/결제 팝업/PayInfo_Default_1/checkImage.png");

		JButton checkBtn1 = new JButton();
		checkBtn1.setBounds(401, 538, 35, 30);
		checkBtn1.setBorderPainted(false);
		checkBtn1.setContentAreaFilled(false);
		add(checkBtn1);


		JButton checkBtn2 = new JButton(check);
		checkBtn2.setBounds(502, 538, 35, 30);
		checkBtn2.setBorderPainted(false);
		checkBtn2.setContentAreaFilled(false);
		add(checkBtn2);



		JButton checkBtn3 = new JButton(check);
		checkBtn3.setBounds(401, 641, 35, 30);
		checkBtn3.setBorderPainted(false);
		checkBtn3.setContentAreaFilled(false);
		add(checkBtn3);


		JButton checkBtn4 = new JButton();
		checkBtn4.setBounds(502, 641, 35, 30);
		checkBtn4.setBorderPainted(false);
		checkBtn4.setContentAreaFilled(false);
		add(checkBtn4);




		checkBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBtn1.setIcon(check);
				checkBtn2.setIcon(null);
			}
		});

		checkBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBtn1.setIcon(null);
				checkBtn2.setIcon(check);
			}
		});






		checkBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBtn3.setIcon(check);
				checkBtn4.setIcon(null);
			}
		});

		checkBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBtn3.setIcon(null);
				checkBtn4.setIcon(check);
			}
		});






		JButton closeButton = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));

		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBounds(207, 842, 150, 80);
		add(closeButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onePassChargePrice = 0;
				onePassChargeItem = 0;
				timeChargePrice = 0;
				timeChargeItem = 0;
				periodChargePrice = 0;
				periodChargeItem = 0;
				studyRoomChargePrice = 0;
				dispose();
			}
		});

		JButton nextButton = new JButton (new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));  // 다음버튼, (결제버튼)

		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setBounds(375, 842, 150, 80);
		add(nextButton);	
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InstallmentPaymentDialog installmentPaymentDialog = new InstallmentPaymentDialog();
			}
		});



		JLabel whatNum = new JLabel();
		JLabel numIs = new JLabel();
		JLabel whatName = new JLabel();
		JLabel nameIs = new JLabel();
		JLabel howHours = new JLabel();
		JLabel hours = new JLabel();
		JLabel howPrice = new JLabel();
		JLabel priceIs = new JLabel();



		// 이용권 종류별로는 달라지지 않는 라벨들
		whatNum.setText("회원번호");
		whatNum.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		whatNum.setForeground(new Color(35, 35, 35));
		whatNum.setBounds(230, 172, 200, 35);
		add(whatNum);

		String[] userNum = CheckInFrame.member.getPhone_number().split("-");
		numIs.setText(userNum[2]);
		numIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		numIs.setForeground(new Color(35, 35, 35));
		numIs.setBounds(382, 172, 200, 35);
		add(numIs);

		whatName.setText("결제상품"); 
		whatName.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		whatName.setForeground(new Color(35, 35, 35));
		whatName.setBounds(230, 225, 200, 35);
		add(whatName);


		howPrice.setText("결제금액");
		howPrice.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		howPrice.setForeground(new Color(35, 35, 35));
		howPrice.setBounds(230, 331, 200, 35);
		howPrice.setName("label");
		add(howPrice);

		howHours.setText("이용시간");
		howHours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
		howHours.setForeground(new Color(35, 35, 35));
		howHours.setBounds(230, 278, 200, 35);
		howHours.setName("label");
		add(howHours);

		

		if(onePassChargePrice != 0) {
			nameIs.setText("일회이용권"); //////////////////////////////변하는 값
			nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			nameIs.setForeground(new Color(35, 35, 35));
			nameIs.setBounds(382, 225, 200, 35);
			add(nameIs);

			priceIs.setText(String.format("%,d원", onePassChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(382, 331, 200, 35);
			priceIs.setName("label");
			add(priceIs);
			
			if(onePassChargeItem == 99) {
				hours.setText("종일권(2시까지)"); //변하는 값
				hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
				hours.setForeground(new Color(35, 35, 35));
				hours.setBounds(382, 278, 200, 35);
				add(hours);
			} else {
				hours.setText(onePassChargeItem + "시간"); //변하는 값
				hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
				hours.setForeground(new Color(35, 35, 35));
				hours.setBounds(382, 278, 200, 35);
				add(hours);
			}

		}  else if (timeChargePrice != 0) {
			nameIs.setText("시간충전권"); 
			nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			nameIs.setForeground(new Color(35, 35, 35));
			nameIs.setBounds(382, 225, 200, 35);
			add(nameIs);

			priceIs.setText(String.format("%,d원", timeChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(382, 331, 200, 35);
			priceIs.setName("label");
			add(priceIs);
			
			hours.setText(timeChargeItem + "시간"); //변하는 값
			hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			hours.setForeground(new Color(35, 35, 35));
			hours.setBounds(382, 278, 200, 35);
			add(hours);

		} else if (periodChargePrice != 0) {
			nameIs.setText("기간이용권"); 
			nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			nameIs.setForeground(new Color(35, 35, 35));
			nameIs.setBounds(382, 225, 200, 35);
			add(nameIs);

			priceIs.setText(String.format("%,d원", periodChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(382, 331, 200, 35);
			priceIs.setName("label");
			add(priceIs);
			
			hours.setText(periodChargeItem + "주"); //변하는 값
			hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			hours.setForeground(new Color(35, 35, 35));
			hours.setBounds(382, 278, 200, 35);
			add(hours);

		} else if (studyRoomChargePrice == 7000) {
			nameIs.setText("스터디룸 4인 1"); 
			nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			nameIs.setForeground(new Color(35, 35, 35));
			nameIs.setBounds(382, 225, 200, 35);
			add(nameIs);

			priceIs.setText(String.format("%,d원", studyRoomChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(382, 331, 200, 35);
			priceIs.setName("label");
			add(priceIs);
			
			hours.setText("1시간"); //변하는 값
			hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			hours.setForeground(new Color(35, 35, 35));
			hours.setBounds(382, 278, 200, 35);
			add(hours);

		} else if (studyRoomChargePrice == 14000) {
			nameIs.setText("스터디룸 4인 2"); 
			nameIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			nameIs.setForeground(new Color(35, 35, 35));
			nameIs.setBounds(382, 225, 200, 35);
			add(nameIs);

			priceIs.setText(String.format("%,d원", studyRoomChargePrice));
			priceIs.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			priceIs.setForeground(new Color(35, 35, 35));
			priceIs.setBounds(382, 331, 200, 35);
			priceIs.setName("label");
			add(priceIs);
			
			hours.setText("2시간"); //변하는 값
			hours.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
			hours.setForeground(new Color(35, 35, 35));
			hours.setBounds(382, 278, 200, 35);
			add(hours);

		}



		












		background.setBackground(new Color(0,0,0,0));
		add(background);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 60, 750, 960);
		setVisible(true);

	}


//	public static int getOnePassChargeItem() {
//		return onePassChargeItem;
//	}
//
//	public  int getOnePassChargePrice() {
//		return onePassChargePrice;
//	}
//
//	public  int getTimeChargeItem() {
//		return timeChargeItem;
//	}
//
//	public  int getTimeChargePrice() {
//		return timeChargePrice;
//	}




}
