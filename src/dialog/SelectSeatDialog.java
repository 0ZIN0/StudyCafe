package dialog;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
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
import panel.SelectSeatPanel;

public class SelectSeatDialog extends JDialog {
	/* 레이아웃 */
	CardLayout card = new CardLayout(); 
	
	JLabel label;
	String seatNum;
	
	/* 패널 */
	JPanel selectSeatPanel;

	public SelectSeatDialog(String seatNum) {
		this.seatNum = seatNum;
		selectSeatPanel = new SelectSeatPanel(seatNum); // seatNum을 넘겨주기 위해 패널을 생성자에다가 선언
		
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
		
		getContentPane().add(selectSeatPanel);

		/* 카드 패널 설정 */
		selectSeatPanel.setLayout(null);
		selectSeatPanel.setBounds(0, 0, 750, 750);
		selectSeatPanel.setBackground(new Color(0, 0, 0, 0));
		
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
