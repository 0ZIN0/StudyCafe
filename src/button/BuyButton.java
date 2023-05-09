package button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BuyButton extends JButton {
	
	public BuyButton(ImageIcon buyImageIcon) {

		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(buyImageIcon);
	}
}
