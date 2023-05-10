package dialog;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panel.UseTicketPanel;

public class UseTicketDialog extends JDialog {
	
	/* 패널 */
	JPanel useTicketPanel = new UseTicketPanel();
	
	/* 라벨 */
	JLabel seatlabel;
	JLabel remainTimeLabel = new JLabel();
	
	/* 버튼 */
	JButton beforeBtn = new JButton(new ImageIcon("ui/Remain_seat_popup/Before_Button.png"));
	
	public UseTicketDialog(String seatNum) {
		
		/* 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		seatlabel = new JLabel(seatName);
		seatlabel.setBounds(298, 120, 200, 50);
		seatlabel.setForeground(new Color(0x131313));
		seatlabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		
		remainTimeLabel.setText(0 + "분"); // 추후에 DAO 이용해서 잔여시간 가져올 것임
		remainTimeLabel.setBounds(408, 228, 100, 40);
		remainTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		remainTimeLabel.setForeground(new Color(0x232323));
		
		/* 버튼 설정 */
		beforeBtn.setBounds(300, 340, 150, 80);
		beforeBtn.setBorderPainted(false);
		beforeBtn.setContentAreaFilled(false);
		
		/* 패널에 라벨이나 버튼들 붙이기 */
		useTicketPanel.add(seatlabel);
		useTicketPanel.add(beforeBtn);
		
		/* 다이얼로그에 패널붙이기 */
		add(useTicketPanel);
		
		/* 팝업창 기본 설정 */
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
