package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import button.ChangeSeatButton;
import button.CheckOutButton;
import button.CloseButton;
import button.UsePlusButton;
import dto.Seat;

public class MySeatDialog extends JDialog {
	
	/* 백그라운드 이미지 */
	ImageIcon icon = new ImageIcon("ui/myseat/check_out_bg.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel mySeatPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	};
	
	
	public MySeatDialog(String seatNum, Seat seat) {
		
		/* 버튼 */
		JButton changeSeatBtn = new ChangeSeatButton(this);
		JButton checkOutBtn = new CheckOutButton(this, seatNum, seat);
		JButton usePlusBtn = new UsePlusButton(this, seatNum, seat);
		CloseButton closeBtn = new CloseButton(this);

		closeBtn.setLocation(300, 415);
		
		/* 패널 설정 */
		mySeatPanel.add(changeSeatBtn);
		mySeatPanel.add(checkOutBtn);
		mySeatPanel.add(usePlusBtn);
		mySeatPanel.add(closeBtn);
		mySeatPanel.setBackground(new Color(0, 0, 0, 0));
		mySeatPanel.setBounds(0, 0, 750, 535);
		mySeatPanel.setLayout(null);
		
		/* 팝업창 기본 설정 */
		add(mySeatPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0));
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 272, 750, 535);
		setVisible(true);
	}
}
