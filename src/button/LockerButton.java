package button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dao.LockerDAO;
import dialog.LockerPayDialog;

public class LockerButton extends JButton implements ActionListener{
	
	int usingLocker;
	
	public LockerButton(int lockerNum) {
		
		usingLocker = LockerDAO.isUse().indexOf(lockerNum);
		setText(Integer.toString(lockerNum));
		setSize(100, 100);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		setBorderPainted(false);
		addActionListener(this);
		
		if(usingLocker >= 0) {
			setBackground(new Color(0x8D8787));
			setEnabled(false);
		} else {
			setBackground(new Color(217, 217, 217));
			
		}
		System.out.println(usingLocker);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		LockerPayDialog lockerPayDialog = new LockerPayDialog(getLockerNum());
	}
	public String getLockerNum() {
		return getText();
	}
}