package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class NextButton extends JButton {
	
	public NextButton(JDialog parent) {
		
		setIcon(new ImageIcon("ui/button/NextButton.png"));
		setContentAreaFilled(false);
		setBorderPainted(false);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				// 결제 다이얼로그 생성하시면 됩니다.
			}
		});
	}
}