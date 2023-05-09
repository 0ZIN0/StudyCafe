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

import button.DayTicketButton;
import button.TermTicketButton;
import button.TimeTicketButton;
import button.UseTicketButton;

public class SelectSeatDialog extends JDialog {

	ImageIcon icon = new ImageIcon("ui/SelectSeatPopup/Background.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel panel = new JPanel() {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	JLabel label;
	
	/* 구매 버튼 */
	JButton dayTicketBtn = new DayTicketButton();
	JButton timeTicketBtn = new TimeTicketButton();
	JButton termTicketBtn = new TermTicketButton();
	JButton useTicketBtn = new UseTicketButton();

	public SelectSeatDialog(String seatNum) {
		/* 닫기 버튼 설정 */
		JButton close = new JButton(new ImageIcon("ui/SelectSeatPopup/CloseButton.png"));

		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setBounds(300, 640, 150, 80);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(close);
		
		/* 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		
		label = new JLabel(seatName);
		
		label.setBounds(287, 55, 200, 50);
		label.setForeground(new Color(0x131313));
		label.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		panel.add(label);
		
		/* 이용권 버튼들 설정 */
		dayTicketBtn.setBounds(165, 165, 200, 200);
		timeTicketBtn.setBounds(385, 165, 200, 200);
		termTicketBtn.setBounds(165, 385, 200, 200);
		useTicketBtn.setBounds(385, 385, 200, 200);
		getContentPane().add(panel);

		/* 패널 */
		panel.add(dayTicketBtn);
		panel.add(timeTicketBtn);
		panel.add(termTicketBtn);
		panel.add(useTicketBtn);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 750, 750);
		panel.setBackground(new Color(0, 0, 0, 0));
		
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
