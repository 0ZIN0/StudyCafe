package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import dao.KickDAO;
import panel.Master_SeatKickPanel;

public class OutButton extends JButton {
	
	public OutButton(JDialog parent, Object[] userInfo, int row) {
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(new ImageIcon("ui/master_seat_kick/seat/Out_Button.png"));
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				KickDAO.setSeatUserOut(userInfo[0].toString());
				Master_SeatKickPanel.model.removeRow(row);
				
			}
		});
	}
}
