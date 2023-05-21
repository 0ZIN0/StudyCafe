package dialog;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.Member;
import dto.Ticket_order;
import panel.OnePassChargePanel;
import panel.TimeChargePanel;

public class TimeOrPeriodChargeDialog extends JDialog {

	public static Ticket_order ticket_order = new Ticket_order();

	public TimeOrPeriodChargeDialog(Member member) {
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/상품충전_팝업/상품충전_BG.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		
		ImageIcon buttonIcon = new ImageIcon("ui/결제 팝업/버튼_수정/CloseButton.png");
		JButton closeButton = new JButton(buttonIcon);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		ImageIcon buttonIcon2 = new ImageIcon("ui/결제 팝업/상품충전_팝업/Button_시간충전.png");
		JButton TimeButton = new JButton(buttonIcon2);
		TimeButton.setBorderPainted(false);
		TimeButton.setContentAreaFilled(false);
		TimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TimeChargeDialog timeCharge = new TimeChargeDialog();
			}
		});

		ImageIcon buttonIcon3 = new ImageIcon("ui/결제 팝업/상품충전_팝업/Button_기간이용.png");
		JButton PeriodButton = new JButton(buttonIcon3);
		PeriodButton.setBorderPainted(false);
		PeriodButton.setContentAreaFilled(false);
		PeriodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PeriodChargeDialog periodCharge = new PeriodChargeDialog();
			}
		});

		closeButton.setBounds(300, 415, 150, 100);
		add(closeButton);
		TimeButton.setBounds(165, 162, 200, 200);
		add(TimeButton);
		PeriodButton.setBounds(385, 162, 200, 200);
		add(PeriodButton);

		background.setBackground(new Color(0,0,0,0));
		add(background);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 270, 750, 535);
		setVisible(true);
	}
}
