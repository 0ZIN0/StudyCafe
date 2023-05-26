package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import dao.KickDAO;
import panel.Master_SeatKickPanel;
import panel.Master_StudyRoomKickPanel;

public class Master_StudyRoomOutButton extends JButton {
	
	
	public Master_StudyRoomOutButton(JDialog parent, Object[] userInfo, int row) {
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(new ImageIcon("ui/master_seat_kick/locker/Yes_Button.png"));
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KickDAO.setStudyRoomUserOut(userInfo[0].toString());
				Master_StudyRoomKickPanel.model.removeRow(row);
				parent.dispose();
			}
		});
	}
}
