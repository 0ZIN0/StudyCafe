package dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class LeaveDialog extends JDialog {

	public LeaveDialog(JFrame parent) {
		super(parent);

		JButton close = new JButton("닫기");

		getContentPane().setBackground(Color.WHITE);

		/* 닫기 버튼 설정 */
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		close.setBounds(500, 500, 100, 100);

		/* 출입문 열림 팝업창 기본 설정 */
		add(close);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 1000, 1000);
		setModal(true);
		setVisible(true);
	}
}
