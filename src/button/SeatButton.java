package button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import dao.SeatDAO;
import dialog.SelectSeatDialog;
import dto.Seat;

public class SeatButton extends JButton {
	
	Seat seat = new Seat();
	boolean use;
	boolean mySeat;
	JDialog selectSeatPopup;
	
	public SeatButton(String seatNum) {
		seat.setSeat_id(seatNum);
		setText(seatNum);
		setBorderPainted(false);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
		
		use = SeatDAO.isUse(Integer.parseInt(seatNum));
		
		if (use) {
			setBackground(new Color(0x8D8787)); // 사용중인 좌석
		} else {
			setBackground(new Color(0xD9D9D9)); // 비어있는 좌석
		}
		
		if (mySeat) {
			setBackground(new Color(0xFF5C00));
		}
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mySeat) {
					// 내좌석을 눌렀을 때 나오는 팝업
				} else if (use) {
					// 사용중인 좌석을 눌렀을 때 나오는 팝업
				} else if (!use) {
					// 사용중이지 않은 좌석을 눌렀을때 나오는 팝업
					selectSeatPopup = new SelectSeatDialog(seatNum, seat);
				}
			}
		});
		
	}
}
