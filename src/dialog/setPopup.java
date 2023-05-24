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

public class setPopup extends JDialog{
	CloseButton closeBtn = new CloseButton(this);

	
	public setPopup(String text) {
		setLayout(null);
        setUndecorated(true); // 윈도우 장식 비활성화

        // 이미지 레이블 생성
        //ImageIcon imageIcon = new ImageIcon("ui/main/popup/popup_defalut.png");
        
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 750, 450); // 이미지 레이블 위치와 크기 설정
        imageLabel.setBackground(Color.white);
        //imageLabel.peak;

        // 텍스트 레이블 생성
        JLabel textLabel = new JLabel(text);
        
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setBounds(0, 85, 750, 60);// 텍스트 레이블 위치와 크기 설정
        
        textLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 50));
        
        //ff7c33
        
        // 컴포넌트 추가
        add(imageLabel);
        imageLabel.add(textLabel);
        
        // 다이얼로그 크기 설정
        setSize(750, 450); 
        setLocationRelativeTo(null);
        
        
        imageLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 dispose(); 
			}
		});
	}
	
	public setPopup(String text, String underText) {
		setLayout(null);
        setUndecorated(true); // 윈도우 장식 비활성화

        // 이미지 레이블 생성
        ImageIcon imageIcon = new ImageIcon("ui/main/popup/popup_defalut.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 750, 450); // 이미지 레이블 위치와 크기 설정
        //imageLabel.peak;

        // 텍스트 레이블 생성
        JLabel textLabel = new JLabel(text);
        JLabel textLabel2 = new JLabel(underText);
        
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setBounds(0, 85, 750, 60); // 텍스트 레이블 위치와 크기 설정
        
        textLabel2.setHorizontalAlignment(JLabel.CENTER);
        textLabel2.setBounds(0, 170, 750, 60); // 텍스트 레이블 위치와 크기 설정
        
        
        
        textLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 50));
        textLabel2.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
        textLabel2.setForeground(new Color(255,124,51));
        //textLabel.setForeground(new Color(0,0,0,0));
        
        // 컴포넌트 추가
        add(imageLabel);
        imageLabel.add(textLabel);
        imageLabel.add(textLabel2);
        
        // 다이얼로그 크기 설정
        setSize(750, 450); 
        setLocationRelativeTo(null);
        
        
        imageLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 dispose(); 
			}
		});
	}
	
	public setPopup(String text, String underText, int width, int height) {
		setLayout(null);
        setUndecorated(true); // 윈도우 장식 비활성화

     // 이미지 레이블 생성
        //ImageIcon imageIcon = new ImageIcon("ui/main/popup/popup_defalut.png");
        
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, width, 450); // 이미지 레이블 위치와 크기 설정
        imageLabel.setBackground(Color.white);

        // 텍스트 레이블 생성
        JLabel textLabel = new JLabel(text);
        JLabel textLabel2 = new JLabel(underText);
        
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setBounds(0, 85, width, 60); // 텍스트 레이블 위치와 크기 설정
        
        textLabel2.setHorizontalAlignment(JLabel.CENTER);
        textLabel2.setBounds(0, 85, width, 60); // 텍스트 레이블 위치와 크기 설정
        textLabel2.setForeground(new Color(255,124,51));
        
        
        textLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 50));
        textLabel2.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 40));
        //textLabel.setForeground(new Color(0,0,0,0));
        
        // 컴포넌트 추가
        add(imageLabel);
        imageLabel.add(textLabel);
        imageLabel.add(textLabel2);
        
        // 다이얼로그 크기 설정
        setSize(width, height); 
        setLocationRelativeTo(null);
        
        
        imageLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 dispose(); 
			}
		});
	}
	
	// 이미지 팝업
		public setPopup(ImageIcon imageIcon) {
			setLayout(new BorderLayout());
	        setUndecorated(true); // 윈도우 장식 비활성화
	        setBackground(new Color(0,0,0,0));
	        
	        
	        JLabel imageLabel = new JLabel(imageIcon);
	        imageLabel.add(closeBtn);
	        closeBtn.setLocation(300,330);
	        
	        // 컴포넌트 추가 중앙 정렬
	        add(imageLabel,BorderLayout.CENTER);
	        
	        // 다이얼로그 크기 설정
	        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	        
	       
	        setLocationRelativeTo(null);
	        //CloseButton closeBtn = new CloseButton(this);
	        
	        
	        closeBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
	        
	        
	        imageLabel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					 
				}
			});
		}
		
		
		
		public setPopup(ImageIcon imageIcon, int closBtnheight) {
			setLayout(new BorderLayout());
	        setUndecorated(true); // 윈도우 장식 비활성화
	        setBackground(new Color(0,0,0,0));
	        
	        
	        JLabel imageLabel = new JLabel(imageIcon);
	        imageLabel.add(closeBtn);
	        closeBtn.setLocation(300,closBtnheight);
	        
	        // 컴포넌트 추가 중앙 정렬
	        add(imageLabel,BorderLayout.CENTER);
	        
	        // 다이얼로그 크기 설정
	        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	        
	       
	        setLocationRelativeTo(null);
	        //CloseButton closeBtn = new CloseButton(this);
	        
	        
	        closeBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
	        
	        
	        
//	        imageLabel.addMouseListener(new MouseListener() {
//				
//				@Override
//				public void mouseReleased(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void mousePressed(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					 dispose(); 
//				}
//			});
		}
	
	
	
}

   