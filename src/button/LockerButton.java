package button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import color.MyColor;
import dao.LockerDAO;
import dialog.LockerPayDialog;
import frame.MainFrame;

public class LockerButton extends JButton implements ActionListener {
	
	int usingLocker;
	
	public LockerButton(int lockerNum) {
		
		List<String[]> usingLocker = LockerDAO.isUse();
		
		setText(Integer.toString(lockerNum));
		setSize(100, 100);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		setBorderPainted(false);
		addActionListener(this);
		
		if(usingLocker.get(lockerNum - 1)[1] != null) {
			if(usingLocker.get(lockerNum - 1)[0].equals(MainFrame.member.getMember_id())) {
				setBackground(MyColor.ORANGE);
				setEnabled(false);
			} else {
				setBackground(MyColor.GRAY);
				setEnabled(false);
			}
		} else {
			setBackground(MyColor.LIGHTGRAY);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LockerPayDialog lockerPayDialog = new LockerPayDialog(getLockerNum());
	}
	public String getLockerNum() {
		return getText();
	}
}