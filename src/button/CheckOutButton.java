package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import dialog.CheckOutDialog;
import dialog.MySeatDialog;
import dto.Seat;

public class CheckOutButton extends JButton {
	
	public CheckOutButton(MySeatDialog parent, String seatNum, Seat seat) {

		setIcon(new ImageIcon("ui/myseat/Button_check_out.png"));
		setBounds(275, 162, 200, 200);
		setBackground(new Color(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				// 만들어야됨 체크아웃 확인팝업
				JDialog checkOutDialog = new CheckOutDialog(seatNum, seat);
			}
		});
	}
}
