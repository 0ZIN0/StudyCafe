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
import dao.SeatDAO;
import dto.Seat;
import frame.MainFrame;
import panel.SeatReportPanel;
import panel.UserInfoPanel;

public class ChangeSeatDialog extends JDialog {

	ImageIcon icon = new ImageIcon("ui/myseat/check_out_pop_up.png");
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

	/* 라벨 */
	JLabel titleLabel = new JLabel("선택하신 좌석");
	JLabel seatNumLabel = new JLabel();
	JLabel checkLabel = new JLabel("좌석 이동 하시겠습니까?");
	
	int mySeatNum;
	
	public ChangeSeatDialog(String seatNum, Seat seat, Integer mySeatNum) {
		
		this.mySeatNum = mySeatNum;
		
		/* 라벨 */
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setBounds(192, 40, 280, 50);
		titleLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		titleLabel.setForeground(new Color(0x232323));
		
		seatNumLabel.setOpaque(true);
		seatNumLabel.setText(seatNum + "번");
		seatNumLabel.setBackground(Color.WHITE);
		seatNumLabel.setBounds(490, 40, 450, 50);
		seatNumLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		seatNumLabel.setForeground(new Color(0x232323));
		
		checkLabel.setForeground(new Color(0x232323));
		checkLabel.setBounds(152, 170, 550, 50);
		checkLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));

		/* 버튼 */
		beforeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				SeatReportPanel.seatInfoLabel.setText(seatNum + "번 좌석을 사용중입니다.");
				SeatReportPanel.seatInfoLabel.setBounds(537, 28, 550, 50);
				JDialog mySeatPopup = new MySeatDialog(seatNum, seat);
			}
		});

		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Integer beforeNum = SeatReportPanel.mySeat;
				Integer afterNum = Integer.parseInt(seatNum);
				
				SeatDAO.setChangeSeat(MainFrame.member.getMember_id(), seatNum);
				SeatReportPanel.seatInfoLabel.setText(seatNum + "번 좌석을 사용중입니다.");
				SeatReportPanel.seatInfoLabel.setBounds(507, 28, 550, 50);
				SeatReportPanel.seatBtns.get(beforeNum - 1).setBackground(new Color(0xD9D9D9));
				
				SeatReportPanel.seatBtns.get(beforeNum - 1).use = false;
				SeatReportPanel.seatBtns.get(afterNum - 1).setBackground(new Color(0xFF5C01));
				SeatReportPanel.seatBtns.get(afterNum - 1).use = true;
				SeatReportPanel.mySeat = Integer.parseInt(seatNum);
				
				JDialog changeCompletionPopup = new ChangeCompletionDialog(seatNum);
				UserInfoPanel.seat.setText(seatNum + "번");
				MainFrame.change = false;
			}
		});
		
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.setBorderPainted(false);
		beforeBtn.setBounds(202, 270, 154, 88);
		okBtn.setBounds(402, 270, 154, 88);

		/* 패널 설정 */
		changeSeatPanel.setBackground(new Color(0,0,0,0));
		changeSeatPanel.setBounds(0, 0, 750, 400);
		changeSeatPanel.setLayout(null);
		changeSeatPanel.add(beforeBtn);
		changeSeatPanel.add(okBtn);
		changeSeatPanel.add(checkLabel);
		changeSeatPanel.add(titleLabel);
		changeSeatPanel.add(seatNumLabel);

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
