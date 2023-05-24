package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MyPagePanel extends JPanel {

	/* 레이아웃 */
	public static CardLayout myPageCard = new CardLayout();
	
    JButton logoutBtn = new JButton("로그아웃");
    JButton mainBtn = new JButton("좌석보기");
    
    // 마이페이지 배경
    ImageIcon myPageBg = new ImageIcon("ui/background/MyPage_BG.jpg"); 
    
    // 마이페이지 안쪽 
    ImageIcon myPageContBg = new ImageIcon("ui/MyPage/MyPage_Contents.jpg"); 
    
    // 회원정보, 이용권미지
    ImageIcon myPageUserInfoBg = new ImageIcon("ui/MyPage/MyPage_UserInfo_Rigth_Frame.png");
    ImageIcon myPageUseTicketBg = new ImageIcon("ui/MyPage/MyPage_UseTicket_Rigth_Frame.png");
    
    /* 패널 */
    BackgroundPanel myPagebg = new BackgroundPanel(myPageBg);
    BackgroundPanel mpMainCont = new BackgroundPanel(myPageContBg);
    
    Container myPageContainer = new JPanel();
    BackgroundPanel userInfoPanel = new BackgroundPanel(myPageUserInfoBg);
    BackgroundPanel useTicketPanel = new BackgroundPanel(myPageUseTicketBg);
	
	// 회원정보 토글 버튼
	JToggleButton userInfoToggleBtn = createToggleButton("ui/MyPage/UserInfo_Button_Empty.png",
			"ui/MyPage/UserInfo_Button.png", 10, 190, 484, 258);
	
	// 이용권 토글 버튼
	JToggleButton useTicketToggleBtn = createToggleButton("ui/MyPage/UseTicket_Button_Empty.png",
			"ui/MyPage/UseTicket_Button.png", 10, 470, 484, 258);
	
	ButtonGroup myPageTogGroup = new ButtonGroup(); // 토글버튼 그룹 지정
	

    public MyPagePanel() {
    	

    	// 기본 배경 설정
    	add(myPagebg);
    	setLayout(null);

        // MyPage 배경 설정
    	myPagebg.add(mpMainCont);
        mpMainCont.setBounds(110, 230, 1700, 760);
        
        mpMainCont.add(myPageContainer);
        myPageContainer.setBounds(510, 10, 1190, 740);
        myPageContainer.setBackground(new Color(0, 0, 0, 0));
        myPageContainer.setLayout(myPageCard);
        
        myPageContainer.add(userInfoPanel, "UserInfomation");
        myPageContainer.add(useTicketPanel, "UseTicket");
        
        
        
        // MyPage 토글 버튼 
        mpMainCont.add(userInfoToggleBtn);
        mpMainCont.add(useTicketToggleBtn);
        
        // MyPage 토글 그룹  
        myPageTogGroup.add(userInfoToggleBtn);
        myPageTogGroup.add(useTicketToggleBtn);
        
        
        
        
    } // end of constructor 

    private JToggleButton createToggleButton(String iconPathBefore, String iconPathAfter, int x, int y, int width, int height) {
    	// 버튼 선택 전, 후 이미지 절대 경로
        ImageIcon iconBefore = new ImageIcon(iconPathBefore);
        ImageIcon iconAfter = new ImageIcon(iconPathAfter);

        // 버튼 기본 상태 설정
        JToggleButton toggleButton = new JToggleButton(iconBefore);
        toggleButton.setContentAreaFilled(false);
        toggleButton.setBorderPainted(false);
        toggleButton.setFocusPainted(false);
        toggleButton.setBounds(x, y, width, height);

        // 버튼 클릭 시 이미지 변경 이벤트
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.isSelected()) {
                    toggleButton.setIcon(iconAfter);
                } else {
                    toggleButton.setIcon(iconBefore);
                }
            }
        });
        

        return toggleButton;
    }
}
