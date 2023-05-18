package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import button.OkButton;
import dto.Seat;

public class ChangeSeatDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/myseat/check_out_bg.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel changeSeatPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 버튼 */
	JButton beforeBtn = new JButton(new ImageIcon("ui/button/BeforeButton.png"));
	JButton okBtn = new OkButton(this);
	
	
	
	public ChangeSeatDialog(String seatNum, Seat seat) {
		
		
		changeSeatPanel.setBackground(new Color(0,0,0,0));
		changeSeatPanel.setBounds(0, 0, 750, 450);
		changeSeatPanel.setLayout(null);
		
		add(changeSeatPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
