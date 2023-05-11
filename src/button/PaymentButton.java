package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PaymentButton extends JButton {
	
	public PaymentButton() {
		
		setIcon(new ImageIcon("ui/study_room/Payment_Button.png"));
		setBounds(164, 477, 268, 108);
		setBorderPainted(false);
		setContentAreaFilled(false);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제창 팝업 띄우기
			}
		});
	}
}
