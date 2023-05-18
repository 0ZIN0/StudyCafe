package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import panel.OnePassChargePanel;
import panel.PeriodChargePanel;
import panel.TimeChargePanel;
import panel.MainPanel;
   
public class CompletePaymentDialog extends JDialog {

	
   public CompletePaymentDialog() {
	   System.out.println("결제완료금액: " + InsertCardDialog.amountPaid); 
	   
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_Compelete_4/Payment_Complete.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		
	      
	      ImageIcon buttonIcon2 = new ImageIcon("ui/결제 팝업/PayInfo_Compelete_4/MainButton.png");
	      JButton mainButton = new JButton(buttonIcon2);
	      
	      mainButton.setBorderPainted(false);
	      mainButton.setContentAreaFilled(false);
	      mainButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	
	        	 TimeChargePanel.timeChargePrice  = 0; 
	        	 OnePassChargePanel.onePassChargePrice = 0;
	        	 PeriodChargePanel.periodChargePrice = 0;
	        	 PaymentDialog.studyRoomChargePrice = 0;
	        	 
	        //	 insertOrder(TimeOrPeriodChargeDialog.ticket_order);
	        	 
	            dispose();
	            
	         }
	      });
	  
	      mainButton.setBounds(250, 320, 250, 80);
	      
	     
	      add(mainButton);
	      
	      
	      background.setBackground(new Color(0,0,0,0));
	      //panel.setBackground(Color.RED);
	      add(background);
	      setModal(true);
	      setUndecorated(true);
	      setBackground(new Color(0,0,0,0));
	     // setBackground(Color.BLUE);
	      setResizable(false);
	      setBounds(585, 315, 750, 450);
	      setVisible(true);
		
   }
   

}