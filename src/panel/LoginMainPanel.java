package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
	public NumberKeypad numpad= new NumberKeypad();
	LoginPanel loginpanel = new LoginPanel();
	MemberJoinPanel memberJoinPanel = new MemberJoinPanel();
	
	
	public LoginMainPanel() {
		setLayout(null);
		
		//numpad.setBounds(0,0,500,500);
		
		background.setLayout(null);
		//background.setBounds(0,0,1920,1080);
		add(background);
		background.add(numpad);
		numpad.setBounds(900,450,600,500);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(card);
		background.add(cardPanel);
		cardPanel.setBounds(200,300,500,600);
		cardPanel.setBorder(new TitledBorder(new LineBorder(Color.red,1)));
		//cardPanel.setBackground(new Color(73,67,68));
		
		cardPanel.add(loginpanel,"login");
		cardPanel.add(memberJoinPanel,"memberjoin");
		card.show(cardPanel, "login");
		
		
		
		setBounds(0,0,1920,1080);
		setVisible(true);
		//setBorder(new TitledBorder(new LineBorder(Color.CYAN,1)));
		
		
		
	
		
		
		//add(numpadPanel);
		
		
		//LoginPanel m1= new LoginPanel();
		
		//MemberJoinPanel m2 =new MemberJoinPanel();
		
//		m1.add(m1.memberJoinBtn);
		
		//add(m1, "p1");
		//add(m2, "p2");
		
		// 팝업 띄우기
		//SeatPopup popup = new SeatPopup();
		
		//card.show(MainPanel.this, "p1");
		
//		m1.memberJoinBtn.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        card.show(LoginMainPanel.this, "p2");
//		    }
//		});
		
		
		

		
		
		
		
	}

	

//	protected static void SeatPopup() {
//		JFrame frame = new JFrame("좌석 정보!!!!!!!");
//		
//		
//		JPanel p = new JPanel();
//		p.add(new JLabel("팝업 내용이야"));
//		
//		
//		JDialog dialog = new JDialog(frame,"좌석 정보!!!",true);
//		dialog.setAlwaysOnTop(true);
//		dialog.add(p);
//		dialog.setSize(500,500);
//		dialog.setLocationRelativeTo(null);
//		
//		dialog.setVisible(true);
//		
//	}
	
}

class NumberKeypad extends JPanel implements ActionListener {
    JTextField textField;// 입력값을 보여줄 텍스트 필드
    public  NumberKeypad() {
        setLayout(new GridLayout(4, 3));  // 4행 3열의 그리드 레이아웃
        
        // 버튼 생성
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(this);
            add(button);
        }
         
        // Clear 버튼 추가
        JButton clearButton = new JButton("지우기");
        clearButton.addActionListener(this);
        add(clearButton);
        
        // 0 버튼 추가
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(this);
        add(zeroButton);
        
        JButton confirmButton = new JButton("확인");
        clearButton.addActionListener(this);
        add(confirmButton);
    }
    
    // 버튼 클릭 시 호출되는 메서드
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("지우기")) {  // Clear 버튼 클릭 시 텍스트필드 초기화
        	textField.setText("");
        } else {  // 숫자 버튼 클릭 시 해당 숫자를 텍스트 필드에 추가
            textField.setText(textField.getText() + command);
        }
    }

    public void setTextField(JTextField textField) {
    	this.textField = textField;
    }
 }


