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

import color.MyColor;

public class ProgramOffDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/master/Master_KiostProgram_Off_Popup.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel offPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	// 버튼
	JButton noBtn = new JButton();
	JButton offBtn = new JButton();
	
	public ProgramOffDialog() {
		
		noBtn.setContentAreaFilled(false);
		noBtn.setBorderPainted(false);
		noBtn.setBounds(208, 320, 158, 88);
		offBtn.setBounds(376, 320, 158, 88);
		offBtn.setContentAreaFilled(false);
		offBtn.setBorderPainted(false);
		
		noBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		offBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		offPanel.setBackground(MyColor.CLEAR);
		offPanel.setLayout(null);
		offPanel.setBounds(0, 0, 750, 450);
		
		offPanel.add(noBtn);
		offPanel.add(offBtn);
		
		add(offPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
