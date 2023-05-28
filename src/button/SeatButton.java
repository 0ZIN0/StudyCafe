package button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import dao.SeatDAO;
import dialog.ChangeSeatDialog;
import dialog.MySeatDialog;
import dialog.SelectSeatDialog;
import dto.Button;
import dto.Seat;
import frame.MainFrame;
import panel.SeatReportPanel;

public class SeatButton extends JButton {

	Seat seat = new Seat();
	public boolean use;
	public String seatNum;
	private static int btnId = 0;
	
	public SeatButton(String seatNum) {
		seat.setSeat_id(seatNum);
		this.seatNum = seatNum;
		setText(seatNum);
		setBorderPainted(false);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
		
		use = SeatDAO.isUse(Integer.parseInt(seatNum));
		
		if (use) {
			setBackground(new Color(0x8D8787)); // 사용중인 좌석
			if (Integer.parseInt(seatNum) == SeatReportPanel.mySeat) {
				setBackground(new Color(0xFF5C01)); // 내 좌석
			}
		} else {
			setBackground(new Color(0xD9D9D9)); // 비어있는 좌석
		}

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SeatReportPanel.seat_reservation.setSeat_id(Integer.parseInt(seatNum));
				
				if (use) {
					if (SeatReportPanel.mySeat == Integer.parseInt(seatNum)) {
						// 내좌석을 눌렀을 때 나오는 팝업
						JDialog mySeatPopup = new MySeatDialog(seatNum, seat);
					}
				} else if (!use) {
					if (SeatReportPanel.seatInfoLabel.getText().equals("원하시는 좌석을 선택해주세요.")) {
						// 좌석 이동 팝업
						JDialog changeSeatPopup = new ChangeSeatDialog(seatNum, seat, SeatReportPanel.mySeat);
					} else if (SeatReportPanel.seatInfoLabel.getText().substring(SeatReportPanel.seatInfoLabel.getText().length() - 13, 
							SeatReportPanel.seatInfoLabel.getText().length()).equals("번 좌석을 사용중입니다.")) {
					} else {
						// 사용중이지 않은 좌석을 눌렀을때 나오는 팝업
						MainFrame.btn.setBtnId(btnId);
						JDialog selectSeatPopup = new SelectSeatDialog(seatNum, seat);
					}
				}
			}
		});
	}
	
	public boolean getUse() {
		return use;
	}
	
	public void setUse(boolean use) {
		this.use = use;
	}
}
