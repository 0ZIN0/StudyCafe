package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import button.CloseButton;
import panel.backgroundPanel;

public class LeaveDialog extends JDialog {
	
	backgroundPanel bg = new backgroundPanel(new ImageIcon("ui/vacated_Frame.png"));
	CloseButton close = new CloseButton(this);
	
	
	public LeaveDialog(JFrame parent) {
		super(parent);
		close.setLocation(300, 800);
		add(close);
		
		
		/* 출입문 열림 팝업창 기본 설정 */
		add(bg);
		setModal(true);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(585, 80, bg.getWidth(), bg.getHeight());
		setVisible(true);
	}
}
