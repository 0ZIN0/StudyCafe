package panel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MembershipMainPanel extends JPanel {
	
	public MembershipMainPanel() {
	
		BackgroundPanel msBg = new BackgroundPanel(new ImageIcon("ui/Membership_ui/Main_Membership_BG.png"));
		add(msBg);
		msBg.setLocation(0, 0);
		msBg.setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		
		
	} // end of constructor
	
	
	

} // end of class
