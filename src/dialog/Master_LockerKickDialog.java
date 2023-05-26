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

import button.Master_LockerOutButton;
import color.MyColor;

public class Master_LockerKickDialog extends JDialog {

	ImageIcon icon = new ImageIcon("ui/master_seat_kick/locker/Master_LockerLimit_PopUp.png");
	Image image = icon.getImage();

	JPanel lockerKickPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};

	// 버튼
	JButton noBtn = new JButton(new ImageIcon("ui/master_seat_kick/locker/No_Button.png"));
	JButton yesBtn;

	// 라벨
	JLabel phoneNumLabel = new JLabel();

	public Master_LockerKickDialog(Object[] userInfo, int row) {
		phoneNumLabel.setText(userInfo[2].toString());
		phoneNumLabel.setBounds(218, 116, 400, 50);
		phoneNumLabel.setForeground(MyColor.BLACK);
		phoneNumLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 42));
		
		yesBtn = new Master_LockerOutButton(this, userInfo, row);
		yesBtn.setBounds(376, 320, 158, 88);
		noBtn.setBounds(208, 320, 158, 88);
		noBtn.setBorderPainted(false);
		noBtn.setContentAreaFilled(false);
		noBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		lockerKickPanel.setLayout(null);
		lockerKickPanel.setBackground(MyColor.CLEAR);
		lockerKickPanel.setSize(750, 450);
		lockerKickPanel.add(noBtn);
		lockerKickPanel.add(yesBtn);
		lockerKickPanel.add(phoneNumLabel);
		
		add(lockerKickPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
