package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CloseButton;
import dao.SeatDAO;
import frame.MainFrame;
import panel.UserInfoPanel;

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
	JLabel remainTime = new JLabel("잔여시간");
	JLabel remainTimeLabel = new JLabel();
	JLabel remainDate = new JLabel("만료일");
	JLabel remainDateLabel = new JLabel();
	
	public ExitDialog() {
		
		/* 라벨 */ 
		if (MainFrame.member.getRemain_date() != null) {
			// date
			remainDate.setForeground(new Color(0x232323));
			remainDate.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 25));
			remainDate.setBounds(238, 220, 130, 40);
			
			Date remain = MainFrame.member.getRemain_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd HH:mm 종료");
			String remainDateStr = sdf.format(remain);
			remainDateLabel.setText(remainDateStr);
			remainDateLabel.setBounds(408, 218, 300, 40);
			remainDateLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 25));
			remainDateLabel.setForeground(new Color(0x232323));
			
			exitPanel.add(remainDate);
			exitPanel.add(remainDateLabel);
			UserInfoPanel.seat.setText("없음");
		} else {
			// time
			remainTime.setBounds(238, 220, 130, 40);
			remainTime.setForeground(new Color(0x232323));
			remainTime.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
			
			int newRemainTime = SeatDAO.getRemainTime(MainFrame.member.getMember_id());
			
			String remain = newRemainTime + "분";	
			
			if (newRemainTime >= 60 ) {
				int hour = newRemainTime / 60;
				int minute = newRemainTime % 60;
				remain = hour + "시간 " + minute + "분";
			}
				
			remainTimeLabel.setText(remain);
			remainTimeLabel.setBounds(408, 218, 450, 40);
			remainTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
			remainTimeLabel.setForeground(new Color(0x232323));
			
			exitPanel.add(remainTime);
			exitPanel.add(remainTimeLabel);
			UserInfoPanel.seat.setText("없음");
		}
		
		/* 패널 */
		exitPanel.setBackground(new Color(0,0,0,0));
		exitPanel.setBounds(0, 0, 750, 450);
		exitPanel.setLayout(null);
		
		closeBtn.setLocation(300, 325);
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// 메인을 초기화 시키고 로그인창으로 넘어가게끔 만드는 메서드
			}
		});
		
		exitPanel.add(closeBtn);
		
		exitPanel.setLayout(null);
		exitPanel.setBackground(new Color(0, 0, 0, 0));
		exitPanel.setBounds(0, 0, 750, 450);
		
		add(exitPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
	
	// 아직 구현 안됨 구현해야함
	public int setRemainMinute(int getRemainMinute) {
		
		return 0;
	}
}
