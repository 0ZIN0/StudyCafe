package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CloseButton;
import dto.StudyRoom_Reservation;

public class PaymentDialog extends JDialog {
	
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
	
	/* 라벨 */
	JLabel startTimeLabel = new JLabel();
	JLabel endTimeLabel = new JLabel();
	
	public PaymentDialog(StudyRoom_Reservation myStudyRoom_Reservation) {
		
		/* temp Label */
		startTimeLabel.setText("시작 시간: " + myStudyRoom_Reservation.getStudyRoom_start_time());
		startTimeLabel.setBounds(385, 240, 250, 40);
		startTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		
		endTimeLabel.setText("퇴실 시간: " + myStudyRoom_Reservation.getStudyRoom_end_time());
		endTimeLabel.setBounds(385, 340, 250, 40);
		endTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		
		/* temp button */
		closeBtn.setLocation(300, 640);
		
		/* 기본 설정 */
		paymentPanel.add(startTimeLabel);
		paymentPanel.add(endTimeLabel);
		paymentPanel.add(closeBtn);
		
		paymentPanel.setLayout(null);
		paymentPanel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		paymentPanel.setBackground(new Color(0, 0, 0, 0));
		
		add(paymentPanel);
		
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 340, icon.getIconWidth(), icon.getIconHeight());
		setVisible(true);
	}
}
