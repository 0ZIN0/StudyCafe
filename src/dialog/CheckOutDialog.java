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

import button.OkButton;
import dto.Seat;

public class CheckOutDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/myseat/check_out_pop_up.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel checkOutPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 버튼 */
	JButton beforeBtn = new JButton(new ImageIcon("ui/button/BeforeButton.png"));
	JButton okBtn = new OkButton(this);
	
	/* 라벨 */ 
	JLabel checkLabel = new JLabel();
	
	public CheckOutDialog(String seatNum, Seat seat) {
		
		beforeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				JDialog mySeatPopup = new MySeatDialog(seatNum, seat);
			}
		});
		
		
		/* 라벨 설정 */
		checkLabel.setText("퇴실하시겠습니까?");
		checkLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		checkLabel.setBounds(202, 170, 450, 50);
		
		/* 버튼 설정 */
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.setBorderPainted(false);
		beforeBtn.setBounds(202, 270, 154, 88);
		okBtn.setBounds(402, 270, 154, 88);
		
		/* 패널 설정 */
		checkOutPanel.setLayout(null);
		checkOutPanel.setBackground(new Color(0, 0, 0, 0));
		checkOutPanel.setBounds(0, 0, 750, 450);
		checkOutPanel.add(beforeBtn);
		checkOutPanel.add(okBtn);
		checkOutPanel.add(checkLabel);
		
		add(checkOutPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
