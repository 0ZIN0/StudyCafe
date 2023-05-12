package panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Scroll extends JScrollPane {
	
	JPanel panel;
	
	public Scroll(JPanel panel) {
		this.panel = panel;
	}
}
