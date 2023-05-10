package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dialog.LockerPayDialog;

public class LockerButton extends JButton implements ActionListener{
	
	
	
	public LockerButton() {
		setSize(100, 100);
		addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌림");
		LockerPayDialog lockerPayDialog = new LockerPayDialog();
		
	}
	
//	public void getlockerPayDialog(LockerPayDialog lockerPayDialog) {
//		this.lockerPayDialog = lockerPayDialog;
//	}
}