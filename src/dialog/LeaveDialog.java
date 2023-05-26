package dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import button.CloseButton;
import dto.Seat;
import panel.BackgroundPanel;
import panel.LeaveMainPanel;

public class LeaveDialog extends JDialog {

	BackgroundPanel bg = new BackgroundPanel(new ImageIcon("ui/vacated_Frame.png"));
	CloseButton close = new CloseButton(this);
	
	public LeaveDialog(List<Seat> seats) {
		LeaveMainPanel main = new LeaveMainPanel();
		JScrollPane scroll = new JScrollPane(main);
		close.setLocation(300, 800);
		
		scroll.setPreferredSize(new Dimension(200, 300));
		scroll.setBounds(57, 237, 636, 526);
		add(scroll);
		add(close);
		
		add(bg);
		setModal(true);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(585, 80, bg.getWidth(), bg.getHeight());
		setVisible(true);
	}
}
