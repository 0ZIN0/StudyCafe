package dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import panel.OnePassChargePanel;
import panel.TimeChargePanel;

public class TimeOrPeriodChargeDialog extends JDialog {
	
	
	public TimeOrPeriodChargeDialog() {
		
		
		
		JButton button1 = new JButton("시간충전권"); // 시간충전권
        JButton button2 = new JButton("기간이용권"); // 기간이용권
     // 닫기 버튼 생성
        JButton closeButton = new JButton("닫기");
        closeButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              dispose(); // JDialog 종료
           }
        });
        add(button1);
        add(button2);
        add(closeButton);
        // 시간충전권, 기간이용권 버튼 위치, 크기 설정
        button1.setBounds(240, 167, 182, 169);  
        button2.setBounds(502, 167, 182, 169); 
        closeButton.setBounds(362, 433, 210, 49); 
		
        // // "시간충전권"버튼 눌렀을 때의 이벤트 
        button1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                dispose(); // chargeDialog 닫기
                //TimeChargeDialog timeChargeDialog = new TimeChargeDialog();
             //   OnePassChargeDialog onePassChargeDialog = new OnePassChargeDialog();
                TimeChargeDialog timeCharge = new TimeChargeDialog();
            }
        });
        setLayout(null);	
        setResizable(false); // 크기 고정 
        setUndecorated(true); // 윈도우 프레임 없애기
        setLocationRelativeTo(null); // 다이얼로그 화면 중앙에 위치
	    setBounds(500, 300, 930, 700);
	    setModal(true);
	    setVisible(true);
	    
	}
}
