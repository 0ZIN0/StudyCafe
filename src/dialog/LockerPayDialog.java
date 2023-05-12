package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import button.CloseButton;

import javax.swing.JLabel;

public class LockerPayDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	ImageIcon icon = new ImageIcon("ui/Locker_PopUp/Locker_PopUp_Background.png");
	Image image = icon.getImage();
	CloseButton close = new CloseButton(this);
	
	/* 패널 */
	JPanel background = new JPanel() {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		};
	};

	/**
	 * Create the dialog.
	 */
	public LockerPayDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("사물함 결제");
		lblNewLabel.setBounds(235, 55, 122, 53);
		contentPanel.add(lblNewLabel);
		
		
		add(close);
		
		background.setSize(750, 1000);
		add(background);
		
		
		setModal(true);
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setBounds(585, 40, 750, 1000);
		setVisible(true);
	}
}
