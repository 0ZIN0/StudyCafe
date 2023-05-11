package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import dialog.OpenDoorDialog;

public class OpenDoorButton extends JButton {

	JDialog openDoorPopup;

	public OpenDoorButton(ImageIcon openDoorImageIcon, JFrame parent) {
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(openDoorImageIcon);

		/** 출입문 열림 버튼을 누르면 발생하는 메서드(출입문 열림 팝업창 설정) */
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openDoorPopup = new OpenDoorDialog();
			}
		});
	}
}
