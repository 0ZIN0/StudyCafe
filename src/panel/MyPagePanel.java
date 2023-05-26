package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


import dao.MemberDAO;
import dao.SeatDAO;
import frame.LoginFrame;
import frame.MainFrame;
import toggle.UseTicketToggle;
import toggle.UserInfoToggle;



public class MyPagePanel extends JPanel {

	/* 레이아웃 */
	public static CardLayout myPageCard = new CardLayout();
	
    JButton logoutBtn = new JButton("로그아웃");
    JButton mainBtn = new JButton("메인화면");
    
    // 마이페이지  배경 이미지
    ImageIcon myPageBg = new ImageIcon("ui/background/MyPage_BG.jpg"); 
    
    // 마이페이지 콘텐츠 영역 이미지
    ImageIcon myPageContBg = new ImageIcon("ui/MyPage/MyPage_Contents_Frame.jpg"); 
    
    ImageIcon userInfoTogOn = new ImageIcon("ui/MyPage/UserInfo_Button.png");

    ImageIcon useTicketOn = new ImageIcon("ui/MyPage/UseTicket_Button.png");
    
    /* 패널 */
    BackgroundPanel myPagebg = new BackgroundPanel(myPageBg);
    BackgroundPanel mpMainCont = new BackgroundPanel(myPageContBg);
    
    JPanel myPageContainer = new JPanel();
    
    UserInfoPanel userInfoPanel = new UserInfoPanel();
    UseTicketPanel useTicketPanel = new UseTicketPanel();
    
    JToggleButton userInfoTogBtn = new UserInfoToggle(userInfoTogOn, myPageCard, userInfoPanel, myPageContainer);
    JToggleButton useTicketTogBtn = new UseTicketToggle(myPageCard, useTicketPanel, myPageContainer);
    
	ButtonGroup myPageTogGroup = new ButtonGroup(); // 토글버튼 그룹 지정

    public MyPagePanel(JFrame parent) {
    	

    	add(myPagebg);
    	setLayout(null);
    	
    	myPagebg.add(logoutBtn);
    	myPagebg.add(mainBtn);
    	
        // MyPage 배경 설정
    	myPagebg.add(mpMainCont);
    	mpMainCont.setLayout(null);
        mpMainCont.setBounds(110, 230, 1700, 760);
        
        // 카드레이아웃 부모 컨테이너
        mpMainCont.add(myPageContainer);
        myPageContainer.setLayout(myPageCard);
        myPageContainer.setOpaque(false);
        myPageContainer.setBounds(510, 10, 1190, 740);
        
        userInfoPanel.setLayout(null);
        userInfoPanel.setBounds(510, 10, 1190, 740);
        
        useTicketPanel.setLayout(null);
        useTicketPanel.setBounds(510, 10, 1190, 740);
        
        myPageContainer.add(userInfoPanel, "UserInfomation");
        myPageContainer.add(useTicketPanel, "UseTicket");
        
        // MyPage 토글 버튼 
        mpMainCont.add(userInfoTogBtn);
        mpMainCont.add(useTicketTogBtn);
        
        userInfoTogBtn.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				userInfoTogBtn.setIcon(userInfoTogOn);
				useTicketTogBtn.setIcon(null);
			}
		});
        
        useTicketTogBtn.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				useTicketTogBtn.setIcon(useTicketOn);
				userInfoTogBtn.setIcon(null);
			}
		});
        
        
        // MyPage 토글 그룹  
        myPageTogGroup.add(userInfoTogBtn);
        myPageTogGroup.add(useTicketTogBtn);
        
		/* 로그아웃, 마이페이지 버튼 */
		logoutBtn.setBounds(62, 114, 200, 40);
		logoutBtn.setForeground(new Color(0xFF5C00));
		logoutBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);

		mainBtn.setBounds(1592, 114, 300, 40);
		mainBtn.setForeground(new Color(0xFF5C00));
		mainBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		mainBtn.setContentAreaFilled(false);
		mainBtn.setBorderPainted(false);
        
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				MainFrame.card.show(getParent(), "main");
				
			}
		});
		
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				new LoginFrame();
			}
		});
        
    } // end of constructor 

} // end of class
