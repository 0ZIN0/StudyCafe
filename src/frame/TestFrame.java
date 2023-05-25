package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panel.BackgroundPanel;
import panel.MasterLoginPanel;
import panel.Master_salesPanel;
import panel.NumberKeypad;
import thread.TimeRun;
import thread.UpdateInfo;

public class TestFrame extends JFrame{
	
	

	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	Master_salesPanel sales = new Master_salesPanel();
	
	JButton exitBtn = new JButton();

	public TestFrame() {
		
		background.setLayout(null);
		add(background);
		sales.setLocation(110,220);
		
		background.add(sales);
	
		// 종료버튼 이벤트
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		exitBtn.setBounds(1700,80,100,100);
		background.add(exitBtn);

		setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new TestFrame();

	}
}
