package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import button.CloseButton;
import button.NextButton;
import dao.TicketDAO;
import dto.Ticket;
import panel.ButtonPanel;

public class LockerPayDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	ImageIcon icon = new ImageIcon("ui/Locker_PopUp/Locker_PopUp_Background.png");
	Image image = icon.getImage();
	
	Ticket ticket;
	NumberFormat nf = NumberFormat.getNumberInstance();
	
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
	public LockerPayDialog(String lockerNum) {
		CloseButton close = new CloseButton(this);
		NextButton next = new NextButton(this);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel label1 = new JLabel("결제상품");
		label1.setBounds(235, 170, 200, 50);
		label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		label1.setForeground(new Color(13, 13, 13));
		add(label1);
		
		JLabel label2 = new JLabel("사물함");
		label2.setBounds(387, 170, 100, 50);
		label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		label2.setForeground(new Color(13, 13, 13));
		add(label2);
		
		JLabel label3 = new JLabel("[" + lockerNum + "]");
		label3.setBounds(475, 170, 100, 50);
		label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		label3.setForeground(new Color(13, 13, 13));
		add(label3);
		
		JLabel label4 = new JLabel("이용시간");
		label4.setBounds(235, 222, 200, 50);
		label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		label4.setForeground(new Color(13, 13, 13));
		add(label4);
		
		JLabel period = new JLabel("2주");
		period.setBounds(387, 222, 100, 50);
		period.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		period.setForeground(new Color(13, 13, 13));
		add(period);
		
		JLabel label6 = new JLabel("결제금액");
		label6.setBounds(235, 277, 200, 50);
		label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		label6.setForeground(new Color(13, 13, 13));
		add(label6);
		
		ticket = TicketDAO.getTicket("T-19");
		String price = nf.format(ticket.getTicket_price()) + "원";
		
		JLabel fee = new JLabel(price);
		fee.setBounds(387, 277, 200, 50);
		fee.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		fee.setForeground(new Color(13, 13, 13));
		add(fee);
		
		ButtonPanel buttonPanel = new ButtonPanel(period, fee);
		buttonPanel.setBackground(new Color(0,0,0,0));
		buttonPanel.setLocation(165, 395);
		add(buttonPanel);
		
		close.setLocation(207, 860);
		add(close);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		next.setBounds(375,860, 150, 80);
		add(next);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaymentInformationDialog payInfo = new PaymentInformationDialog();
			}
		});
		
		background.setBackground(new Color(0,0,0,0));
		background.setSize(750, 1000);
		add(background);
		
		contentPanel.setBackground(new Color(0, 0, 0, 0));
		setModal(true);
		setLayout(null);
		setUndecorated(true);

		setResizable(false);
		setBounds(585, 40, 750, 1000);
		setVisible(true);
	}
}
