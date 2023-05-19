package button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dao.LockerDAO;
import dialog.LockerPayDialog;

public class LockerButton extends JButton implements ActionListener {
	
	boolean inUse;
	
	public LockerButton(int lockerNum) {
		
		inUse = LockerDAO.inUse(lockerNum);
		setText(Integer.toString(lockerNum));
		setSize(100, 100);
		setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
		setBorderPainted(false);
		addActionListener(this);
		
		if(inUse) {
			setBackground(new Color(0x8D8787));
		} else {
			setBackground(new Color(217, 217, 217));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!inUse) {
			LockerPayDialog lockerPayDialog = new LockerPayDialog(getLockerNum());
		}
		
	}
	
	public String getLockerNum() {
		return getText();
	}
}