package panel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MasterLoginPanel extends JPanel{
	NumberKeypad numpad= new NumberKeypad();
	JPanel inputPanel = new JPanel();
	
	
	public MasterLoginPanel() {
		setLayout(null);
		add(numpad);
		numpad.setBounds(1080,50,550,690);
		
		add(inputPanel);
		inputPanel.setBounds(0,0,990,760);
		//inputPanel.getBackground(new ImageIcon("ui/master/masterLogin/Left_Frame.png"));
		//inputPanel.setForeground();
		
	}

}
