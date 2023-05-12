package dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertCardDialog extends JDialog {
	
	public InsertCardDialog() {
		
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_CreditCard_3/Payment_CreditCard.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		
	      
	      ImageIcon buttonIcon2 = new ImageIcon("ui/결제 팝업/PayInfo_CreditCard_3/CloseButton.png");
	      JButton btnNewButton6 = new JButton(buttonIcon2);
	      
	      btnNewButton6.setBorderPainted(false);
	      btnNewButton6.setContentAreaFilled(false);
	      btnNewButton6.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            CompletePaymentDialog completePaymentDialog = new CompletePaymentDialog();
	         }
	      });
	  
	      btnNewButton6.setBounds(300, 874, 150, 80);
	      
	     
	      add(btnNewButton6);
	      
	      
	      background.setBackground(new Color(0,0,0,0));
	      //panel.setBackground(Color.RED);
	      add(background);
	      setModal(true);
	      setUndecorated(true);
	      setBackground(new Color(0,0,0,0));
	     // setBackground(Color.BLUE);
	      setResizable(false);
	      setBounds(585, 40, 750, 1000);
	      setVisible(true);
		
	      
	      
	      
	  
		
		
		
	}
}

