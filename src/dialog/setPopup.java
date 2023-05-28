package dialog;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import button.CloseButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class setPopup extends JDialog {

	CloseButton close = new CloseButton(this);
	
	// 이미지 팝업
		public setPopup(ImageIcon imageIcon) {
			setLayout(new BorderLayout());
	        setUndecorated(true); // 윈도우 장식 비활성화
	        setBackground(new Color(0,0,0,0));
	        
	        
	        JLabel imageLabel = new JLabel(imageIcon);
	        imageLabel.add(close);
	        close.setLocation(300,330);
	        
	        // 컴포넌트 추가 중앙 정렬
	        add(imageLabel,BorderLayout.CENTER);
	        
	        // 다이얼로그 크기 설정
	        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	        
	   
	        setLocationRelativeTo(null);
	        
	        
	        close.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});

		}
		public setPopup(ImageIcon imageIcon, int closBtnheight) {
			setLayout(new BorderLayout());
	        setUndecorated(true); // 윈도우 장식 비활성화
	        setBackground(new Color(0,0,0,0));
	        
	        
	        JLabel imageLabel = new JLabel(imageIcon);
	        imageLabel.add(close);
	        close.setLocation(300,closBtnheight);
	        
	        // 컴포넌트 추가 중앙 정렬
	        add(imageLabel,BorderLayout.CENTER);
	        
	        // 다이얼로그 크기 설정
	        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	        
	       
	        setLocationRelativeTo(null);
	        
	        
	        close.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
		}
}

   