package dialog;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CloseButton;
import button.DayTicketButton;
import button.TermTicketButton;
import button.TimeTicketButton;
import button.UseTicketButton;
import panel.SelectSeatPanel;

public class SelectSeatDialog extends JDialog {
	
	/* 좌석 번호 알려주는 라벨 */
	JLabel seatNumlabel;
	
	/* 패널 */
	JPanel selectSeatPanel = new SelectSeatPanel();

	public SelectSeatDialog(String seatNum) {
		/* 버튼 */
		JButton dayTicketBtn = new DayTicketButton();
		JButton timeTicketBtn = new TimeTicketButton();
		JButton termTicketBtn = new TermTicketButton();
		JButton useTicketBtn = new UseTicketButton(this, seatNum);
		JButton close = new CloseButton(this);

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
		seatNumlabel.setForeground(new Color(0x131313));
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
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 240, 1000, 1000);
		setVisible(true);
	}
}
