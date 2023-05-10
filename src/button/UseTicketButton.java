package button;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UseTicketButton extends JButton {
	
	boolean remainTicket;
	
	public UseTicketButton(CardLayout card, JPanel parent) {
		setBorderPainted(false);
		setIcon(new ImageIcon("ui/SelectSeatPopup/Button_사용중.png"));
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (remainTicket) {
					card.show(parent, "use_ticket");
				} else {
					card.show(parent, "not_use_ticket");
				}
			}
		});
	}
}
