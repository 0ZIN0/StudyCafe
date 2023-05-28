package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import panel.OnePassChargePanel;
import panel.PeriodChargePanel;
import panel.TimeChargePanel;

public class InstallmentPaymentDialog extends JDialog {
	
	int onePassChargeItem = OnePassChargePanel.getOnePassChargeItem();
	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();

	int timeChargeItem = TimeChargePanel.getTimeChargeItem();
	int timeChargePrice = TimeChargePanel.getTimeChargePrice();
	
	int periodChargeItem = PeriodChargePanel.getPeriodChargeItem();
	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();
	
	public InstallmentPaymentDialog() {

		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_Default_2/Pay_PopUp2_revision.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("일시불");
		comboBox.addItem("2개월");
		comboBox.addItem("3개월");
		comboBox.addItem("4개월");
		comboBox.addItem("5개월");
		comboBox.addItem("6개월");
		comboBox.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));

		comboBox.setBounds(383, 186, 128, 52);

		add(comboBox);

		JLabel installmentLabel = new JLabel("할부기간");
		installmentLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		installmentLabel.setBounds(236, 180, 150, 62);
		add(installmentLabel);

		JButton closeButton = new JButton(new ImageIcon("ui/button/CloseButton.png"));
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onePassChargePrice = 0;
				onePassChargeItem = 0;
				timeChargePrice = 0;
				timeChargeItem = 0;
				periodChargePrice = 0;
				periodChargeItem = 0;
				
				TimeChargePanel.timeChargePrice  = 0; 
	        	 OnePassChargePanel.onePassChargePrice = 0;
	        	 PeriodChargePanel.periodChargePrice = 0;
	        	 
	        	 TimeChargePanel.timeChargeItem  = 0; 
	        	 OnePassChargePanel.onePassChargePrice = 0;
	        	 PeriodChargePanel.periodChargePrice = 0;
	        	 
				
				dispose();
			}
		});

		JButton nextButton = new JButton (new ImageIcon("ui/button/NextButton.png"));

		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertCardDialog insertCardDialog = new InsertCardDialog();
			}
		});
		closeButton.setBounds(207, 350, 158, 88);
		nextButton.setBounds(375, 350, 158, 88);

		add(closeButton);
		add(nextButton);



		background.setBackground(new Color(0,0,0,0));
		add(background);
		setModal(true);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setResizable(false);
		setBounds(585, 315, 750, 450);
		setVisible(true);

	}
}