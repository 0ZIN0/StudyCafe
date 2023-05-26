package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CloseButton;
import frame.MainFrame;
import panel.SeatReportPanel;
import panel.StudyRoomPanel;

public class ChangeCompletionDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/myseat/check_out_pop_up.png");
	Image image = icon.getImage();

	/* 패널 */
	JPanel changeCompletionPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 버튼 */
	CloseButton closeBtn = new CloseButton(this);
	
	/* 라벨 */
	JLabel titleLabel = new JLabel("좌석 이동");
	JLabel checkLabel = new JLabel();

	
	public ChangeCompletionDialog(String seatNum) {
		/* 라벨 */
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setBounds(290, 40, 500, 50);
		titleLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		titleLabel.setForeground(new Color(0x232323));
		
		checkLabel.setText(seatNum + "번 좌석 이동 완료되었습니다.");
		checkLabel.setForeground(new Color(0x232323));
		checkLabel.setBounds(129, 170, 550, 50);
		checkLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
		
		/* 버튼 */
		closeBtn.setLocation(300, 270);
		
		/* 패널 설정 */
		changeCompletionPanel.add(closeBtn);
		changeCompletionPanel.add(checkLabel);
		changeCompletionPanel.add(titleLabel);
		changeCompletionPanel.setBackground(new Color(0,0,0,0));
		changeCompletionPanel.setBounds(0, 0, 750, 400);
		changeCompletionPanel.setLayout(null);
		add(changeCompletionPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
