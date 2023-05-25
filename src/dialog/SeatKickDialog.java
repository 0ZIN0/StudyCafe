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
import button.OutButton;
import color.MyColor;

public class SeatKickDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/master_seat_kick/seat/Master_UserDischarge_PopUp.png");
	Image image = icon.getImage();
	
	JPanel seatKickPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	// 버튼
	CloseButton closeBtn = new CloseButton(this);
	JButton outBtn;
	
	// 라벨
	JLabel phoneNumLabel = new JLabel();
	
	public SeatKickDialog(Object[] userInfo, int row) {
		
		phoneNumLabel.setText(userInfo[2].toString());
		phoneNumLabel.setBounds(218, 156, 400, 50);
		phoneNumLabel.setForeground(MyColor.BLACK);
		phoneNumLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 42));
		
		outBtn = new OutButton(this, userInfo, row);
		outBtn.setBounds(376, 320, 158, 88);
		closeBtn.setLocation(208, 320);
		
		seatKickPanel.setLayout(null);
		seatKickPanel.setBackground(MyColor.CLEAR);
		seatKickPanel.setSize(750, 450);
		seatKickPanel.add(closeBtn);
		seatKickPanel.add(outBtn);
		seatKickPanel.add(phoneNumLabel);
		
		add(seatKickPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
