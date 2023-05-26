package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import dao.KickDAO;
import panel.Master_LockerKickPanel;
import panel.Master_StudyRoomKickPanel;

public class Master_LockerOutButton extends JButton {
	
	public Master_LockerOutButton(JDialog parent, Object[] userInfo, int row) {
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(new ImageIcon("ui/master_seat_kick/locker/Yes_Button.png"));
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KickDAO.setLockerUserOut(userInfo[0].toString().trim());
				Master_LockerKickPanel.model.removeRow(row);
				parent.dispose();
			}
		});
	}
}
