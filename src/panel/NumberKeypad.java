package panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberKeypad extends JPanel implements ActionListener {

	JTextField textField;// 입력값을 보여줄 텍스트 필드
	int max;
	StringBuilder sb;
	boolean phoneSelect;
	

	public  NumberKeypad() {
		setLayout(new GridLayout(4, 3, 5, 5));  // 4행 3열의 그리드 레이아웃
		setOpaque(false);
		

		// 버튼 생성
		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton(Integer.toString(i));
			button.setBackground(new Color(35,35,35));
			button.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
			button.setForeground(Color.white);
			button.addActionListener(this);
			add(button);
		}


		// Clear 버튼 추가
		JButton clearButton = new JButton("지우기");
		clearButton.setBackground(new Color(35,35,35));
		clearButton.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
		clearButton.setForeground(Color.white);
		clearButton.addActionListener(this);
		add(clearButton);

		// 0 버튼 추가
		JButton zeroButton = new JButton("0");
		zeroButton.setBackground(new Color(35,35,35));
		zeroButton.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
		zeroButton.setForeground(Color.white);
		zeroButton.addActionListener(this);
		add(zeroButton);

		JButton confirmButton = new JButton("확인");
		confirmButton.setBackground(new Color(35,35,35));
		confirmButton.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 20));
		confirmButton.setForeground(Color.white);
		clearButton.addActionListener(this);
		add(confirmButton);
	}

	// 버튼 클릭 시 호출되는 메서드
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("지우기")) {  // Clear 버튼 클릭 시 텍스트필드 초기화
			textField.setText("");
			return;
		} 
		
		if(phoneSelect) {
			if(textField.getText().length()<=max) {
				textField.setText(textField.getText() + command);
				if(textField.getText().length()==3) {
					textField.setText(textField.getText()+"-");
				}
				if(textField.getText().length()==8) {
					textField.setText(textField.getText()+"-");
				}
			}
		} else {
			// 숫자 버튼 클릭 시 해당 숫자를 텍스트 필드에 추가
			if(textField.getText().length()<=max) {
				textField.setText(textField.getText() + command);
			}
		}
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public void setMax(int num) {
		this.max =num;
	}
	
	
//	public void setString(Strin) {
//		this.sd =sd;
//	}
//	
	


}


