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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.SeatDAO;
import dto.Seat;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.SeatReportPanel;
import panel.UserInfoPanel;

public class UseTicketDialog extends JDialog {
	
	ImageIcon icon = new ImageIcon("ui/Remain_seat_popup/UseTicket.png");
	Image image = icon.getImage();
	
	/* 패널 */
	JPanel useTicketPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};
	
	/* 라벨 */
	JLabel seatlabel;
	JLabel remainTimeLabel = new JLabel();
	JLabel remainDate = new JLabel();
	JLabel remainDateLabel = new JLabel();

	/* 버튼 */
	JButton beforeBtn = new JButton(new ImageIcon("ui/button/BeforeButton.png"));
	JButton useStartBtn = new JButton(new ImageIcon("ui/button/useStartButton.png"));
	
	public UseTicketDialog(String seatNum, Seat seat) {
		SeatReportPanel.seat_reservation.setSeat_id(Integer.parseInt(seatNum));
		
		/* 라벨 설정 */
		String seatName = seatNum + "번 좌석";
		seatlabel = new JLabel(seatName);
		seatlabel.setBounds(288, 120, 200, 50);
		seatlabel.setForeground(new Color(0x232323));
		seatlabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
		
		remainDate.setOpaque(true);
		remainDate.setText("만료일");
		remainDate.setForeground(new Color(0x232323));
		remainDate.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 25));
		remainDate.setBackground(Color.WHITE);
		remainDate.setBounds(238, 220, 130, 40);
		
		if (MainFrame.member.getRemain_date() != null) {
			SeatReportPanel.seat_reservation.setUse_ticket_category("기간이용권");
			remainDate.setVisible(true);
			
			Date remain = MainFrame.member.getRemain_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd HH:mm 종료");
			String remainDateStr = sdf.format(remain);
			remainDateLabel.setText(remainDateStr);
			remainDateLabel.setBounds(408, 218, 300, 40);
			remainDateLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 25));
			remainDateLabel.setForeground(new Color(0x232323));
			remainDateLabel.setVisible(true);
			remainTimeLabel.setVisible(false);
		} else {
			SeatReportPanel.seat_reservation.setUse_ticket_category("시간충전권");
			remainDate.setVisible(false);
			
			int newRemainTime = SeatDAO.getRemainTime(MainFrame.member.getMember_id());
			String remain = newRemainTime + "분";	
			
			if (newRemainTime >= 60 ) {
				int hour = newRemainTime / 60;
				int minute = newRemainTime % 60;
				remain = hour + "시간 " + minute + "분";
			}
			
			remainTimeLabel.setText(remain); // 추후에 DAO 이용해서 잔여시간 가져올 것임
			remainTimeLabel.setBounds(408, 218, 450, 40);
			remainTimeLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
			remainTimeLabel.setForeground(new Color(0x232323));
			remainTimeLabel.setVisible(true);
			remainDateLabel.setVisible(false);
		}
		
		/* 버튼 설정 */
		beforeBtn.setBounds(202, 340, 158, 88);
		beforeBtn.setBorderPainted(false);
		beforeBtn.setContentAreaFilled(false);
		beforeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectSeatDialog selectSeatPopup = new SelectSeatDialog(seatNum, seat);
			}
		});
		
		useStartBtn.setBounds(402, 340, 158, 88);
		useStartBtn.setBorderPainted(false);
		useStartBtn.setContentAreaFilled(false);
		useStartBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeatReportPanel.seat_reservation.setMember_id(MainFrame.member.getMember_id());
				SeatDAO.setReservation(SeatReportPanel.seat_reservation);
				
				int seat = Integer.parseInt(seatNum);
				
				SeatReportPanel.seatInfoLabel.setText(seatNum + "번 좌석을 사용중입니다.");
				SeatReportPanel.seatInfoLabel.setBounds(507, 28, 550, 50);
				SeatReportPanel.seatBtns.get(seat - 1).setBackground(new Color(0xFF5C01));
				SeatReportPanel.seatBtns.get(seat - 1).use = true;
				SeatReportPanel.mySeat = Integer.parseInt(seatNum);
				
				RemainSeatLabel.remain = SeatDAO.isRemain();
				SeatReportPanel.remainSeatLabel.setText(String.format("%02d / %02d",RemainSeatLabel.remain[0],RemainSeatLabel.remain[1]));
				
				UseLastDialog useLastPopup = new UseLastDialog();
				UserInfoPanel.seat.setText(seatNum + "번");
			}
		});
		
		/* 패널에 라벨이나 버튼들 붙이기 */
		useTicketPanel.add(seatlabel);
		useTicketPanel.add(beforeBtn);
		useTicketPanel.add(remainTimeLabel);
		useTicketPanel.add(remainDate);
		useTicketPanel.add(remainDateLabel);
		useTicketPanel.add(useStartBtn);
		
		/* 팝업창 기본 설정 */
		useTicketPanel.setLayout(null);
		useTicketPanel.setBackground(new Color(0, 0, 0, 0));
		useTicketPanel.setSize(750, 450);
		
		add(useTicketPanel);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setLayout(null);
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setBackground(new Color(0, 0, 0, 0)); 
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(585, 315, 750, 450);
		setVisible(true);
	}
}
