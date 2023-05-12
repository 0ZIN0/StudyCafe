package dialog;

import java.awt.Color;
import java.awt.Component;
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

public class OnePassChargeDialog extends JDialog {

	private static int hour; 
	private static int price;

	    	
	
	public OnePassChargeDialog() {
		
		
		
		ImageIcon imageIcon = new ImageIcon("ui/결제 팝업/일회이용권/SeatUse_PopUp.png");
		Image bgImage = imageIcon.getImage();
		JPanel background = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bgImage, 0, 0, this);
			};
		};
		
		NumberFormat nf = NumberFormat.getInstance();
		
		   JButton btnNewButton1 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간.png"));
		   btnNewButton1.setBorderPainted(false);
		   btnNewButton1.setContentAreaFilled(false);
		   btnNewButton1.setBounds(45, 380, 200, 200);
		   add(btnNewButton1);
		  
		  
		   
		   JButton btnNewButton2 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간.png"));
		   btnNewButton2.setBorderPainted(false);
		   btnNewButton2.setContentAreaFilled(false);
		   btnNewButton2.setBounds(275, 380, 200, 200);
		   add(btnNewButton2);
		 
		   
		   
		   JButton btnNewButton3 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간.png"));
		   btnNewButton3.setBorderPainted(false);
		   btnNewButton3.setContentAreaFilled(false);
		   btnNewButton3.setBounds(505, 380, 200, 200);
		   add(btnNewButton3);
		 
		   
		   
		   JButton btnNewButton4 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간.png"));
		   btnNewButton4.setBorderPainted(false);
		   btnNewButton4.setContentAreaFilled(false);
		   btnNewButton4.setBounds(45, 610, 200, 200);
		   add(btnNewButton4);
		   
		   
		   JButton btnNewButton5 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간.png"));
		   btnNewButton5.setBorderPainted(false);
		   btnNewButton5.setContentAreaFilled(false);
		   btnNewButton5.setBounds(275, 610, 200, 200);
		   add(btnNewButton5);
		   
		   
		   JButton btnNewButton6 = new JButton(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권.png"));
		   btnNewButton6.setBorderPainted(false);
		   btnNewButton6.setContentAreaFilled(false);
		   btnNewButton6.setBounds(505, 610, 200, 200);
		   add(btnNewButton6);
		   
		   
		      
		
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
	      price = 29800;
          
	      
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
	      
	      
	      
	     
	      
	   
	      
	      btnNewButton1.addActionListener(new ActionListener() { 
	    	    public void actionPerformed(ActionEvent e) {
	    	    	
	    	    	System.out.println("기본 선택값..");
	    	    	hour = 2;
	    	    	price = 5000;
	    	    	
	    	        btnNewButton1.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간_choice.png"));
	    	        btnNewButton2.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간.png"));
	    	        btnNewButton3.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간.png"));
	    	        btnNewButton4.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간.png"));
	    	        btnNewButton5.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간.png"));
	    	        btnNewButton6.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권.png"));
	    	        btnNewButton7.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	    	        btnNewButton8.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));

	    	        Component[] components = background.getComponents();
	    	        for (Component component : components) {
	    	            if (component instanceof JLabel && component.getName().startsWith("label")) {
	    	                background.remove(component);
	    	            }
	    	        }
	    	        
	    	       
	    	        JLabel label1 = new JLabel("결제상품");
	    	        label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label1.setForeground(new Color(35, 35, 35));
	    	        label1.setBounds(230, 172, 200, 35);
	    	        label1.setName("label");
	    	        background.add(label1, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label2 = new JLabel("일회이용권");
	    	        label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label2.setForeground(new Color(35, 35, 35));
	    	        label2.setBounds(382, 172, 200, 35);
	    	        label2.setName("label");
	    	        background.add(label2, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label3 = new JLabel("이용시간");
	    	        label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label3.setForeground(new Color(35, 35, 35));
	    	        label3.setBounds(230, 225, 200, 35);
	    	        label3.setName("label");
	    	        background.add(label3, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label4 = new JLabel(nf.format(hour) + "시간");
	    	        label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label4.setForeground(new Color(35, 35, 35));
	    	        label4.setBounds(382, 225, 200, 35);
	    	        label4.setName("label");
	    			background.add(label4);
	    			background.repaint();
	    			
	    			
	    	        
	    	        
	    	        JLabel label5 = new JLabel("결제금액");
	    	        label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label5.setForeground(new Color(35, 35, 35));
	    	        label5.setBounds(230, 278, 200, 35);
	    	        label5.setName("label");
	    	        background.add(label5, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label6 = new JLabel(nf.format(price) + "원");
	    	        label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    			label6.setForeground(new Color(35, 35, 35));
	    			label6.setBounds(382, 278, 200, 35);
	    			label6.setName("label");
	    			background.add(label6);
	    			background.repaint();
	    	       
	    	    }
	    	});
	      btnNewButton1.setSelected(true);
	     
	      
	      btnNewButton2.addActionListener(new ActionListener() { // 3시간버튼
	    	    public void actionPerformed(ActionEvent e) {
	    	    	hour = 3;
	    	    	price = 6000;
	                 
	    	    	
	    	    	 System.out.println("3시간 선택");
	    	    	 
	    	        btnNewButton1.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간.png"));
	    	        btnNewButton2.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간_choice.png"));
	    	        btnNewButton3.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간.png"));
	    	        btnNewButton4.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간.png"));
	    	        btnNewButton5.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간.png"));
	    	        btnNewButton6.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권.png"));
	    	        btnNewButton7.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	    	        btnNewButton8.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));

	    	        Component[] components = background.getComponents();
	    	        for (Component component : components) {
	    	            if (component instanceof JLabel && component.getName().startsWith("label")) {
	    	                background.remove(component);
	    	            }
	    	        }
	    	        
	    	        JLabel label1 = new JLabel("결제상품");
	    	        label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label1.setForeground(new Color(35, 35, 35));
	    	        label1.setBounds(230, 172, 200, 35);
	    	        label1.setName("label");
	    	        background.add(label1, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label2 = new JLabel("일회이용권");
	    	        label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label2.setForeground(new Color(35, 35, 35));
	    	        label2.setBounds(382, 172, 200, 35);
	    	        label2.setName("label");
	    	        background.add(label2, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label3 = new JLabel("이용시간");
	    	        label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label3.setForeground(new Color(35, 35, 35));
	    	        label3.setBounds(230, 225, 200, 35);
	    	        label3.setName("label");
	    	        background.add(label3, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label4 = new JLabel(nf.format(hour) + "시간");
	    	        label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label4.setForeground(new Color(35, 35, 35));
	    	        label4.setBounds(382, 225, 200, 35);
	    	        label4.setName("label");
	    			background.add(label4);
	    			background.repaint();
	    			
	    			
	    	        
	    	        
	    	        JLabel label5 = new JLabel("결제금액");
	    	        label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label5.setForeground(new Color(35, 35, 35));
	    	        label5.setBounds(230, 278, 200, 35);
	    	        label5.setName("label");
	    	        background.add(label5, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label6 = new JLabel(nf.format(price) + "원");
	    	        label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    			label6.setForeground(new Color(35, 35, 35));
	    			label6.setBounds(382, 278, 200, 35);
	    			label6.setName("label");
	    			background.add(label6);
	    			background.repaint();
	    	       
	    	    }
	    	});
	      
	      
	      
	      btnNewButton3.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	    	hour = 4;
	    	  	    price = 7000;
	    	        btnNewButton1.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간.png"));
	    	        btnNewButton2.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간.png"));
	    	        btnNewButton3.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간_choice.png"));
	    	        btnNewButton4.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간.png"));
	    	        btnNewButton5.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간.png"));
	    	        btnNewButton6.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권.png"));
	    	        btnNewButton7.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	    	        btnNewButton8.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));

	    	        Component[] components = background.getComponents();
	    	        for (Component component : components) {
	    	            if (component instanceof JLabel && component.getName().startsWith("label")) {
	    	                background.remove(component);
	    	            }
	    	        }
	    	        
	    	        JLabel label1 = new JLabel("결제상품");
	    	        label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label1.setForeground(new Color(35, 35, 35));
	    	        label1.setBounds(230, 172, 200, 35);
	    	        label1.setName("label");
	    	        background.add(label1, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label2 = new JLabel("일회이용권");
	    	        label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label2.setForeground(new Color(35, 35, 35));
	    	        label2.setBounds(382, 172, 200, 35);
	    	        label2.setName("label");
	    	        background.add(label2, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label3 = new JLabel("이용시간");
	    	        label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label3.setForeground(new Color(35, 35, 35));
	    	        label3.setBounds(230, 225, 200, 35);
	    	        label3.setName("label");
	    	        background.add(label3, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label4 = new JLabel(nf.format(hour) + "시간");
	    	        label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label4.setForeground(new Color(35, 35, 35));
	    	        label4.setBounds(382, 225, 200, 35);
	    	        label4.setName("label");
	    			background.add(label4);
	    			background.repaint();
	    			
	    			
	    	        
	    	        
	    	        JLabel label5 = new JLabel("결제금액");
	    	        label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label5.setForeground(new Color(35, 35, 35));
	    	        label5.setBounds(230, 278, 200, 35);
	    	        label5.setName("label");
	    	        background.add(label5, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label6 = new JLabel(nf.format(price) + "원");
	    	        label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    			label6.setForeground(new Color(35, 35, 35));
	    			label6.setBounds(382, 278, 200, 35);
	    			label6.setName("label");
	    			background.add(label6);
	    			background.repaint();
	    	       
	    	    }
	    	});
	      
	      
	      
	      
	      btnNewButton4.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	    	hour = 6;
	    	  	    price = 9000;
	    	        btnNewButton1.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간.png"));
	    	        btnNewButton2.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간.png"));
	    	        btnNewButton3.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간.png"));
	    	        btnNewButton4.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간_choice.png"));
	    	        btnNewButton5.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간.png"));
	    	        btnNewButton6.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권.png"));
	    	        btnNewButton7.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	    	        btnNewButton8.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));

	    	        Component[] components = background.getComponents();
	    	        for (Component component : components) {
	    	            if (component instanceof JLabel && component.getName().startsWith("label")) {
	    	                background.remove(component);
	    	            }
	    	        }
	    	        
	    	        JLabel label1 = new JLabel("결제상품");
	    	        label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label1.setForeground(new Color(35, 35, 35));
	    	        label1.setBounds(230, 172, 200, 35);
	    	        label1.setName("label");
	    	        background.add(label1, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label2 = new JLabel("일회이용권");
	    	        label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label2.setForeground(new Color(35, 35, 35));
	    	        label2.setBounds(382, 172, 200, 35);
	    	        label2.setName("label");
	    	        background.add(label2, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label3 = new JLabel("이용시간");
	    	        label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label3.setForeground(new Color(35, 35, 35));
	    	        label3.setBounds(230, 225, 200, 35);
	    	        label3.setName("label");
	    	        background.add(label3, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label4 = new JLabel(nf.format(hour) + "시간");
	    	        label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label4.setForeground(new Color(35, 35, 35));
	    	        label4.setBounds(382, 225, 200, 35);
	    	        label4.setName("label");
	    			background.add(label4);
	    			background.repaint();
	    			
	    			
	    	        
	    	        
	    	        JLabel label5 = new JLabel("결제금액");
	    	        label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label5.setForeground(new Color(35, 35, 35));
	    	        label5.setBounds(230, 278, 200, 35);
	    	        label5.setName("label");
	    	        background.add(label5, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label6 = new JLabel(nf.format(price) + "원");
	    	        label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    			label6.setForeground(new Color(35, 35, 35));
	    			label6.setBounds(382, 278, 200, 35);
	    			label6.setName("label");
	    			background.add(label6);
	    			background.repaint();
	    	       
	    	    }
	    	});
	      
	      
	      
	      btnNewButton5.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	    	hour = 8;
	    	  	    price = 12000;
	    	        btnNewButton1.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간.png"));
	    	        btnNewButton2.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간.png"));
	    	        btnNewButton3.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간.png"));
	    	        btnNewButton4.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간.png"));
	    	        btnNewButton5.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간_choice.png"));
	    	        btnNewButton6.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권.png"));
	    	        btnNewButton7.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	    	        btnNewButton8.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));

	    	        Component[] components = background.getComponents();
	    	        for (Component component : components) {
	    	            if (component instanceof JLabel && component.getName().startsWith("label")) {
	    	                background.remove(component);
	    	            }
	    	        }
	    	        
	    	        JLabel label1 = new JLabel("결제상품");
	    	        label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label1.setForeground(new Color(35, 35, 35));
	    	        label1.setBounds(230, 172, 200, 35);
	    	        label1.setName("label");
	    	        background.add(label1, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label2 = new JLabel("일회이용권");
	    	        label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label2.setForeground(new Color(35, 35, 35));
	    	        label2.setBounds(382, 172, 200, 35);
	    	        label2.setName("label");
	    	        background.add(label2, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label3 = new JLabel("이용시간");
	    	        label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label3.setForeground(new Color(35, 35, 35));
	    	        label3.setBounds(230, 225, 200, 35);
	    	        label3.setName("label");
	    	        background.add(label3, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label4 = new JLabel(nf.format(hour) + "시간");
	    	        label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label4.setForeground(new Color(35, 35, 35));
	    	        label4.setBounds(382, 225, 200, 35);
	    	        label4.setName("label");
	    			background.add(label4);
	    			background.repaint();
	    			
	    			
	    	        
	    	        
	    	        JLabel label5 = new JLabel("결제금액");
	    	        label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label5.setForeground(new Color(35, 35, 35));
	    	        label5.setBounds(230, 278, 200, 35);
	    	        label5.setName("label");
	    	        background.add(label5, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label6 = new JLabel(nf.format(price) + "원");
	    	        label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    			label6.setForeground(new Color(35, 35, 35));
	    			label6.setBounds(382, 278, 200, 35);
	    			label6.setName("label");
	    			background.add(label6);
	    			background.repaint();
	    	       
	    	    }
	    	});
	      
	      
	      
	      btnNewButton6.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	    	hour = 24;
	    	  	    price = 15000;
	    	        btnNewButton1.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_2시간.png"));
	    	        btnNewButton2.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_3시간.png"));
	    	        btnNewButton3.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_4시간.png"));
	    	        btnNewButton4.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_6시간.png"));
	    	        btnNewButton5.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_8시간.png"));
	    	        btnNewButton6.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/Button_종일권_choice.png"));
	    	        btnNewButton7.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/CloseButton.png"));
	    	        btnNewButton8.setIcon(new ImageIcon("ui/결제 팝업/일회이용권/NextButton.png"));

	    	        Component[] components = background.getComponents();
	    	        for (Component component : components) {
	    	            if (component instanceof JLabel && component.getName().startsWith("label")) {
	    	                background.remove(component);
	    	            }
	    	        }
	    	        
	    	        JLabel label1 = new JLabel("결제상품");
	    	        label1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label1.setForeground(new Color(35, 35, 35));
	    	        label1.setBounds(230, 172, 200, 35);
	    	        label1.setName("label");
	    	        background.add(label1, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label2 = new JLabel("일회이용권");
	    	        label2.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label2.setForeground(new Color(35, 35, 35));
	    	        label2.setBounds(382, 172, 200, 35);
	    	        label2.setName("label");
	    	        background.add(label2, 0);
	    	        background.repaint();
	    	        
	    	        JLabel label3 = new JLabel("이용시간");
	    	        label3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label3.setForeground(new Color(35, 35, 35));
	    	        label3.setBounds(230, 225, 200, 35);
	    	        label3.setName("label");
	    	        background.add(label3, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label4 = new JLabel(nf.format(hour) + "시간");
	    	        label4.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label4.setForeground(new Color(35, 35, 35));
	    	        label4.setBounds(382, 225, 200, 35);
	    	        label4.setName("label");
	    			background.add(label4);
	    			background.repaint();
	    			
	    			
	    	        
	    	        
	    	        JLabel label5 = new JLabel("결제금액");
	    	        label5.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    	        label5.setForeground(new Color(35, 35, 35));
	    	        label5.setBounds(230, 278, 200, 35);
	    	        label5.setName("label");
	    	        background.add(label5, 0);
	    	        background.repaint();
	    	        
	    	        
	    	        
	    	        JLabel label6 = new JLabel(nf.format(price) + "원");
	    	        label6.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 28));
	    			label6.setForeground(new Color(35, 35, 35));
	    			label6.setBounds(382, 278, 200, 35);
	    			label6.setName("label");
	    			background.add(label6);
	    			background.repaint();
	    	       
	    	    }
	    	});
	   
	      
	      
	      
	     
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
	
	public static int getPrice() {
        return price;
    }
	
	public static int getHour() {
        return hour;
    }
	
}

