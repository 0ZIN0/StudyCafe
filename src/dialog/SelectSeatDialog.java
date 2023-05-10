package dialog;

import java.awt.CardLayout;
import java.awt.Color;
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
import panel.NotUseTicketPanel;
import panel.SelectSeatPanel;
import panel.UseTicketPanel;

public class SelectSeatDialog extends JDialog {
	/* 레이아웃 */
	CardLayout card = new CardLayout(); 
	
	JLabel label;
	String seatNum;
	
	/* 카드 레이아웃 패널 */
	JPanel parentPanel = new JPanel(); // 부모패널
	JPanel selectSeatPanel;
	JPanel useTicketPanel;
	JPanel notUseTicketPanel;
	
	/* 구매 버튼 */
	JButton dayTicketBtn = new DayTicketButton();
	JButton timeTicketBtn = new TimeTicketButton();
	JButton termTicketBtn = new TermTicketButton();
	JButton useTicketBtn = new UseTicketButton(card, parentPanel);
	
	public SelectSeatDialog(String seatNum) {
		
		this.seatNum = seatNum;
		selectSeatPanel = new SelectSeatPanel(seatNum); // seatNum을 넘겨주기 위해 패널을 생성자에다가 선언
		useTicketPanel = new UseTicketPanel(seatNum);
		notUseTicketPanel = new NotUseTicketPanel(seatNum);
		
		/* 이용권 버튼들 설정 */
		dayTicketBtn.setBounds(165, 165, 200, 200);
		timeTicketBtn.setBounds(385, 165, 200, 200);
		termTicketBtn.setBounds(165, 385, 200, 200);
		useTicketBtn.setBounds(385, 385, 200, 200);
		
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
		selectSeatPanel.add(close);
		
		/* 부모 패널 설정 */
		parentPanel.setLayout(card);
		parentPanel.setBounds(0, 0, 1000, 1000);
		
		/* 카드 패널 설정 */
		// 1. 이용권 구매버튼들이 모여있는 1번 패널
		selectSeatPanel.setLayout(null);
		selectSeatPanel.setBounds(0, 0, 750, 750);
		selectSeatPanel.setBackground(new Color(0, 0, 0, 0));
		selectSeatPanel.add(dayTicketBtn);
		selectSeatPanel.add(timeTicketBtn);
		selectSeatPanel.add(termTicketBtn);
		selectSeatPanel.add(useTicketBtn);
		
		// 4-1. 사용중인 이용권이 있을때 나오는 4-1번 패널
		useTicketPanel.setLayout(null);
		useTicketPanel.setBounds(0, 0, 750, 750);
		useTicketPanel.setBackground(new Color(0, 0, 0, 0));
		
		// 4-2. 사용중인 이용권이 없을때 나오는 4-2번 패널
		notUseTicketPanel.setLayout(null);
		notUseTicketPanel.setBounds(0, 0, 750, 750);
		notUseTicketPanel.setBackground(new Color(0, 0, 0, 0));
		
		/* 카드 패널 붙이기 */
		parentPanel.add(selectSeatPanel, "select_seat"); // 고정 1번
		parentPanel.add(useTicketPanel, "use_ticket");
		parentPanel.add(notUseTicketPanel, "not_use_ticket"); // 재훈님이 다뤄야 할 부분 마지막
		
		/* 다이얼로그에 패널 붙이기 */
		add(parentPanel);
		
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
