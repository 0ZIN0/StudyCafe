package dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class OpenDoorDialog extends JDialog {
	
	public OpenDoorDialog(JFrame parent) {
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
		setUndecorated(true); // 팝업창 위 닫기버튼들을 다 없앰
		setResizable(false); // 사용자가 팝업창 크기를 조정하는것을 해제
		setBounds(100, 100, 1000, 1000);
		setModal(true); // 팝업창 이외에 다른 버튼들은 누를 수 없음
		setVisible(true);
	}
}
