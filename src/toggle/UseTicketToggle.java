package toggle;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class UseTicketToggle extends JToggleButton {

	CardLayout myPageCard;
	JPanel useTicketPanel;
	JPanel myPageContainer;
	
	public UseTicketToggle(CardLayout myPageCard, JPanel useTicketPanel, JPanel myPageContainer) {

		this.myPageContainer = myPageContainer;
		this.useTicketPanel = useTicketPanel;
		this.myPageCard = myPageCard;
		
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(10, 470, 484, 258);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPageCard.show(myPageContainer, "UseTicket");
			}
		});
		
	} // end of constructor
	
} // end of class
