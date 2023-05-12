package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaymentInformationDialog extends JDialog { 

	int price = OnePassChargeDialog.getPrice();
	int hour = OnePassChargeDialog.getHour();
	
	public PaymentInformationDialog() {
		
		
		
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_Default_1/SeatUse_Pay_info_default_1.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		NumberFormat nf = NumberFormat.getInstance();
		
		
		 JButton btnNewButton7 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	      btnNewButton7.setBorderPainted(false);
	      btnNewButton7.setContentAreaFilled(false);
	      btnNewButton7.setBounds(207, 842, 150, 80);
	      add(btnNewButton7);
	      btnNewButton7.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	         }
	      });
	      
	      
	     
	      JButton btnNewButton8 = new JButton (new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));  // 다음버튼, (결제버튼)
	      
	      
	      btnNewButton8.setBorderPainted(false);
	      btnNewButton8.setContentAreaFilled(false);
	      btnNewButton8.setBounds(375, 842, 150, 80);
	      add(btnNewButton8);	
	      btnNewButton8.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            PaymentInformationDialog paymentInformationDialog = new PaymentInformationDialog();
	         }
	      });
	      
		
		
		
		
        
//////////////////////////
JLabel label5 = new JLabel("가격: " + nf.format(price) + "원");
label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
label5.setForeground(new Color(35, 35, 35));
label5.setBounds(395, 329, 200, 35);
background.add(label5);
background.repaint();


        
    

background.setBackground(new Color(0,0,0,0));
//panel.setBackground(Color.RED);
add(background);
setModal(true);
setUndecorated(true);
setBackground(new Color(0,0,0,0));
// setBackground(Color.BLUE);
setResizable(false);
setBounds(585, 60, 750, 960);
setVisible(true);
		
	}
	
}
