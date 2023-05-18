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

import button.CloseButton;
import button.NextButton;
import dto.StudyRoom_Reservation;
import panel.OnePassChargePanel;
import panel.PeriodChargePanel;
import panel.TimeChargePanel;

public class PaymentDialog extends JDialog {


	public static int studyRoomChargePrice; 

	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();

	int timeChargePrice = TimeChargePanel.getTimeChargePrice();

	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();



	ImageIcon icon = new ImageIcon("ui/study_room/Study_Room_payment_Popup.png");
	Image image = icon.getImage();

	/* 패널 */
	JPanel paymentPanel = new JPanel() {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};

	/* 버튼 */
	CloseButton closeBtn = new CloseButton(this);
	JButton nextBtn = new NextButton(this);

	/* 라벨 */
	JLabel label1 = new JLabel("이용 상품");
	JLabel label2 = new JLabel("이용 시간");
	JLabel label3 = new JLabel("결제 금액");

	JLabel studyRoom_numLabel = new JLabel();
	JLabel useTimeLabel = new JLabel();
	JLabel payInfoLabel = new JLabel();

	public PaymentDialog(StudyRoom_Reservation myStudyRoom_Reservation, JLabel whatTimeLabel) {



		/* Label */
		label1.setBounds(220, 184, 150, 40);
		label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));

		label2.setBounds(220, 236, 150, 40);
		label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));

		label3.setBounds(220, 288, 150, 40);
		label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));

		String roomNum;
		TimeChargePanel.timeChargePrice  = 0; 
		OnePassChargePanel.onePassChargePrice = 0;
		PeriodChargePanel.periodChargePrice = 0;
		PaymentDialog.studyRoomChargePrice = 0;

		if (myStudyRoom_Reservation.getStudyRoom_id().equals("SI-1")) {
			roomNum = "스터디룸 4인 1";
		} else {
			roomNum = "스터디룸 4인 2";
		}
		studyRoom_numLabel.setText(roomNum);
		studyRoom_numLabel.setBounds(410, 184, 250, 40);
		studyRoom_numLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));

		useTimeLabel.setText(myStudyRoom_Reservation.getStudyRoom_start_time() + " ~ " + myStudyRoom_Reservation.getStudyRoom_end_time());
		useTimeLabel.setBounds(410, 236, 250, 40);
		useTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));

		String pay;
		if (whatTimeLabel.getText().equals("1")) {
			pay = "7,000원";
			studyRoomChargePrice = 7000;
		} else {
			pay = "14,000원";
			studyRoomChargePrice = 14000;
		}
		payInfoLabel.setText(pay);
		payInfoLabel.setBounds(410, 288, 250, 40);
		payInfoLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));



		/* button */
		closeBtn.setLocation(202, 410);
		nextBtn.setBounds(402, 410, 150, 80);

		/* 기본 설정 */
		paymentPanel.add(label1);
		paymentPanel.add(label2);
		paymentPanel.add(label3);

		paymentPanel.add(studyRoom_numLabel);
		paymentPanel.add(useTimeLabel);
		paymentPanel.add(payInfoLabel);
		paymentPanel.add(closeBtn);
		paymentPanel.add(nextBtn);

		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaymentInformationDialog payInfor = new PaymentInformationDialog();
			}
		});

		paymentPanel.setLayout(null);
		paymentPanel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		paymentPanel.setBackground(new Color(0, 0, 0, 0));

		add(paymentPanel);

		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, icon.getIconWidth(), icon.getIconHeight());
		setVisible(true);
	}

	public static int getStudyRoomchargePrice() {
		return studyRoomChargePrice;
	}
}
