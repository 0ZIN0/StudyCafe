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

public class UseTicketDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/Remain_seat_popup/UseTicket.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel useTicketPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 라벨 */
	JLabel seatlabel;
	JLabel remainTimeLabel = new JLabel();
	
	/* 버튼 */
	JButton beforeBtn = new JButton(new ImageIcon("ui/Remain_seat_popup/Before_Button.png"));
	JButton useStartBtn = new JButton(new ImageIcon("ui/Remain_seat_popup//useStart_Button.png"));
	
	public UseTicketDialog(String seatNum) {
		
		/* 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		seatlabel = new JLabel(seatName);
		seatlabel.setBounds(298, 120, 200, 50);
		seatlabel.setForeground(new Color(0x131313));
		seatlabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		
		remainTimeLabel.setText(60 + "분"); // 추후에 DAO 이용해서 잔여시간 가져올 것임
		remainTimeLabel.setBounds(408, 218, 100, 40);
		remainTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		remainTimeLabel.setForeground(new Color(0x232323));
		
		/* 버튼 설정 */
		beforeBtn.setBounds(202, 340, 150, 80);
		beforeBtn.setBorderPainted(false);
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectSeatDialog selectSeatPopup = new SelectSeatDialog(seatNum);
			}
		});
		
		useStartBtn.setBounds(402, 340, 150, 80);
		useStartBtn.setBorderPainted(false);
		useStartBtn.setContentAreaFilled(false);
		useStartBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UseLastDialog useLastPopup = new UseLastDialog();
			}
		});
		
		/* 패널에 라벨이나 버튼들 붙이기 */
		useTicketPanel.add(seatlabel);
		useTicketPanel.add(beforeBtn);
		useTicketPanel.add(remainTimeLabel);
		useTicketPanel.add(useStartBtn);
		
		/* 다이얼로그에 패널붙이기 */
		add(useTicketPanel);
		
		/* 팝업창 기본 설정 */
		useTicketPanel.setLayout(null);
		useTicketPanel.setBackground(new Color(0, 0, 0, 0));
		useTicketPanel.setSize(750, 450);
		
		add(useTicketPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
