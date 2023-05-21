package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CloseButton;
import button.DayTicketButton;
import button.TermTicketButton;
import button.TimeTicketButton;
import button.UseTicketButton;
import dto.Seat;
import dto.Ticket_order;

public class SelectSeatDialog extends JDialog {
	
	Seat seat;
	/* 백그라운드 이미지 */
	ImageIcon icon = new ImageIcon("ui/SelectSeatPopup/Background.png");
	Image image = icon.getImage();
	
	/* 좌석 번호 알려주는 라벨 */
	JLabel seatNumlabel;
	
	/* 패널 */
	JPanel selectSeatPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	};
	
	JLabel label;
	
	public SelectSeatDialog(String seatNum, Seat seat) {
		this.seat = seat;
		
		
		/* 구매 버튼 */
		JButton dayTicketBtn = new DayTicketButton(seat, this);
		JButton timeTicketBtn = new TimeTicketButton(this);
		JButton termTicketBtn = new TermTicketButton(this);
		JButton useTicketBtn = new UseTicketButton(this, seatNum, seat);
		JButton close = new CloseButton(this);
		
		if (UseTicketButton.useSeat) {
			useTicketBtn.setEnabled(false);
		}
		
		
		/* 닫기 버튼 설정 */
		close.setLocation(300, 640);
		
		/* 이용권 버튼들 크기 설정 */
		dayTicketBtn.setBounds(165, 165, 200, 200);
		timeTicketBtn.setBounds(385, 165, 200, 200);
		termTicketBtn.setBounds(165, 385, 200, 200);
		useTicketBtn.setBounds(385, 385, 200, 200);
		
		/* 좌석 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		seatNumlabel = new JLabel(seatName);
		seatNumlabel.setBounds(287, 55, 200, 50);
		seatNumlabel.setForeground(new Color(0x232323));
		seatNumlabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		
		/* 패널에 잡것들 붙이기 */
		selectSeatPanel.add(seatNumlabel);
		selectSeatPanel.add(dayTicketBtn);
		selectSeatPanel.add(timeTicketBtn);
		selectSeatPanel.add(termTicketBtn);
		selectSeatPanel.add(useTicketBtn);
		selectSeatPanel.add(close);
		
		/* 다이얼로그에 패널 붙이기 */
		add(selectSeatPanel);

		/* 팝업창 기본 설정 */
		selectSeatPanel.setLayout(null);
		selectSeatPanel.setBounds(0, 0, 750, 750);
		selectSeatPanel.setBackground(new Color(0, 0, 0, 0));
		
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 240, 1000, 1000);
		setVisible(true);
	}
}
