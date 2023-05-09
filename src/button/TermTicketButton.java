package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TermTicketButton extends JButton {
	
	public TermTicketButton() {
		setBorderPainted(false);
		setIcon(new ImageIcon("ui/SelectSeatPopup/Button_기간이용.png"));
		
		addActionListener(new ActionListener() {
			
			// 클릭하면 실행되는 메서드
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
