package toggle;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class UserInfoToggle extends JToggleButton {

	CardLayout myPageCard;
	JPanel userInfoPanel;
	JPanel myPageContainer;
	
	public UserInfoToggle(ImageIcon userInfoTogOn, CardLayout myPageCard, JPanel userInfoPanel, JPanel myPageContainer) {

		this.myPageContainer = myPageContainer;
		this.userInfoPanel = userInfoPanel;
		this.myPageCard = myPageCard;
		
		setIcon(userInfoTogOn);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setBounds(10, 190, 484, 258);
		setOpaque(false);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPageCard.show(myPageContainer, "UserInfomation");
			}
		});
		
	} // end of constructor
	
} // end of class
