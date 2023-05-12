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

public class InstallmentPaymentDialog extends JDialog {
	
	public InstallmentPaymentDialog() {
		
		
	        
	        
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/PayInfo_Default_2/Pay_PopUp2.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
	    
	      JButton btnNewButton5 = new JButton(new ImageIcon("ui/결제 팝업/PayInfo_Default_2/CloseButton.png"));
	      btnNewButton5.setBorderPainted(false);
	      btnNewButton5.setContentAreaFilled(false);
	      btnNewButton5.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	         }
	      });
	      
	      
	     
	      JButton btnNewButton6 = new JButton (new ImageIcon("ui/결제 팝업/PayInfo_Default_2/NextButton.png"));
	      
	      btnNewButton6.setBorderPainted(false);
	      btnNewButton6.setContentAreaFilled(false);
	      btnNewButton6.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            InsertCardDialog insertCardDialog = new InsertCardDialog();
	         }
	      });
	      btnNewButton5.setBounds(207, 350, 150, 80);
	      btnNewButton6.setBounds(375, 350, 150, 80);
	      
	      add(btnNewButton5);
	      add(btnNewButton6);
	      
	      
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

