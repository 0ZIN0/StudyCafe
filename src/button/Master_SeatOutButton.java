package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import dao.KickDAO;
import dao.SeatDAO;
import panel.Master_SeatKickPanel;
import panel.Master_StudyRoomKickPanel;

public class Master_SeatOutButton extends JButton {
	
	public Master_SeatOutButton(JDialog parent, Object[] userInfo, int row) {
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(new ImageIcon("ui/master_seat_kick/seat/Out_Button.png"));
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KickDAO.setCheckOut(userInfo[0].toString().trim(), userInfo[2].toString().trim());
				Master_SeatKickPanel.model.removeRow(row);
				parent.dispose();
			}
		});
	}
}
