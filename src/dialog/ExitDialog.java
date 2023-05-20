package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CloseButton;

public class ExitDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/myseat/exit_popup.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel exitPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 버튼 */
	CloseButton closeBtn = new CloseButton(this);
	
	/* 라벨 */
	JLabel remainLabel = new JLabel();
	JLabel remainTimeLabel = new JLabel();
	
	public ExitDialog() {
		
		closeBtn.setLocation(300, 800);
		
		/* 패널 */
		exitPanel.setBackground(new Color(0,0,0,0));
		exitPanel.setBounds(0, 0, 750, 450);
		exitPanel.setLayout(null);
		
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메인을 초기화 시키고 로그인창으로 넘어가게끔 만드는 메서드
			}
		});
		
		exitPanel.add(closeBtn);
		
		add(exitPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
