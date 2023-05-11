package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import button.CloseButton;

public class UseLastDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/Remain_seat_popup/UseLastPopup.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel useLastPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 버튼 */
	JButton closeBtn = new CloseButton(this);
	
	public UseLastDialog() {
		
		closeBtn.setLocation(300, 340);
		
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// 추가적으로 로그인 화면으로 이동하는 기능을 구현 할 것임.
			}
		});
		
		useLastPanel.add(closeBtn);
		
		/* 팝업창 기본 설정 */
		useLastPanel.setLayout(null);
		useLastPanel.setBackground(new Color(0, 0, 0, 0));
		useLastPanel.setSize(750, 450);
		
		add(useLastPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
