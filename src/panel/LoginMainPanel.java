package panel;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class LoginMainPanel extends JPanel{
	
	CardLayout card = new CardLayout();
	BackgroundPanel background= new BackgroundPanel(new ImageIcon("ui/background/background.png"));
	JButton exitBtn = new JButton("종료");
	NumberKeypad numpad= new NumberKeypad();
	LoginPanel loginpanel = new LoginPanel();
	TermsofUsePanel termsofUsePanel = new TermsofUsePanel();
	
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel();
	JPanel cardPanel = new JPanel();
	
	
	public LoginMainPanel( ) {
		
		setLayout(null);
		
		background.setLayout(null);
		add(background);
		//
		
		background.add(exitBtn);
		
		exitBtn.setBounds(1700,80,100,100);
	
		
		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(130,260,1650,760);
		//cardPanel.setBorder(new TitledBorder(new LineBorder(Color.red,1)));
		
		//cardPanel.add(loginpanel,"login");
		cardPanel.add(memberJoinPanel,"memberjoin");
		cardPanel.add(termsofUsePanel,"termsofUse");
		
		
		setBounds(0,0,1920,1080);
		
		loginpanel.memberJoinBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        card.show(cardPanel, "termsofUse");
		    }
		});
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		

	}
}

//class NumberKeypad extends JPanel implements ActionListener {
//    JTextField textField;// 입력값을 보여줄 텍스트 필드
//    
//    
//    int max;
//    
//    public  NumberKeypad() {
//        setLayout(new GridLayout(4, 3));  // 4행 3열의 그리드 레이아웃
//        
//        // 버튼 생성
//        for (int i = 1; i <= 9; i++) {
//            JButton button = new JButton(Integer.toString(i));
//            button.setBackground(new Color(35,35,35));
//            button.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
//            button.setForeground(Color.white);
//            button.addActionListener(this);
//            add(button);
//        }
//       
//         
//        // Clear 버튼 추가
//        JButton clearButton = new JButton("지우기");
//        clearButton.setBackground(new Color(35,35,35));
//        clearButton.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
//        clearButton.setForeground(Color.white);
//        
//        clearButton.addActionListener(this);
//        add(clearButton);
//        
//        // 0 버튼 추가
//        JButton zeroButton = new JButton("0");
//        zeroButton.setBackground(new Color(35,35,35));
//        zeroButton.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
//        zeroButton.setForeground(Color.white);
//        zeroButton.addActionListener(this);
//        add(zeroButton);
//        
//        JButton confirmButton = new JButton("확인");
//        confirmButton.setBackground(new Color(35,35,35));
//        confirmButton.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
//        confirmButton.setForeground(Color.white);
//        clearButton.addActionListener(this);
//        add(confirmButton);
//    }
//    
//    // 버튼 클릭 시 호출되는 메서드
//    public void actionPerformed(ActionEvent e) {
//        String command = e.getActionCommand();
//        if (command.equals("지우기")) {  // Clear 버튼 클릭 시 텍스트필드 초기화
//        	textField.setText("");
//        } else {  // 숫자 버튼 클릭 시 해당 숫자를 텍스트 필드에 추가
//            if(textField.getText().length()<=max) {
//            	textField.setText(textField.getText() + command);
//            }
//            
//            
//            
//        }
//    }
//
//    public void setTextField(JTextField textField) {
//    	this.textField = textField;
//    }
//    
//    
//    public void setMax(int num) {
//    	this.max =num;
//    }
//    
//    
//    
// }


