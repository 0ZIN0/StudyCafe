package panel;

import java.awt.Component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberKeypad extends JPanel implements ActionListener {
    
    JTextField textField;// 입력값을 보여줄 텍스트 필드
    
    public NumberKeypad() {
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