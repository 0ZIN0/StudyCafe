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

public class OpenDoorDialog extends JDialog {
	
	
	JPanel mainPanel = new JPanel() {
		ImageIcon icon = new ImageIcon("ui/SelectSeatPopup/Background.png");
		Image image = icon.getImage();
		
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	JLabel titleLabel = new JLabel("출입문이 열립니다.");
	
	public OpenDoorDialog() {
		JButton close = new CloseButton(this);
		close.setLocation(300, 640);
		
		/* 라벨 설정 */
		titleLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		titleLabel.setBounds(287, 105, 200, 50);
		
		/* 패널 설정 */
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		mainPanel.setBounds(0, 0, 750, 750);
		mainPanel.setLayout(null);
		mainPanel.add(titleLabel);
		
		/* 출입문 열림 팝업창 기본 설정 */
		add(close);
		add(mainPanel);
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 240, 1000, 1000);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setVisible(true);
	}
	
}
