package dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ChargeDialog extends JDialog {
	
	public ChargeDialog() {
		
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
		
        
        button1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                dispose(); // chargeDialogPanel 닫기
                
                // 팝업 다이얼로그 생성
                JDialog timeChargeDialog = new JDialog();
                timeChargeDialog.setResizable(false); // 크기 변경 불가능
                timeChargeDialog.setUndecorated(true); // 창틀 없음
                timeChargeDialog.setLocation(600, 100); // 위치 지정  
                JPanel timeChargePanel = new JPanel();
                timeChargePanel.setPreferredSize(new Dimension(800, 900)); // 크기 지정
                timeChargePanel.setLayout(null);

                JButton btnNewButton2_0 = new JButton("New button");
                btnNewButton2_0.setBounds(107, 405, 162, 113);
                timeChargePanel.add(btnNewButton2_0);
        		
        		JButton btnNewButton2_1 = new JButton("New button");
        		btnNewButton2_1.setBounds(321, 405, 162, 113);
        		timeChargePanel.add(btnNewButton2_1);
                
                JButton btnNewButton2_2 = new JButton("New button");
        		btnNewButton2_2.setBounds(535, 405, 162, 113);
        		timeChargePanel.add(btnNewButton2_2);
        		
        		JButton btnNewButton2_3 = new JButton("New button");
        		btnNewButton2_3.setBounds(107, 560, 162, 113);
        		timeChargePanel.add(btnNewButton2_3);
        		
        		JButton btnNewButton2_4 = new JButton("New button");
        		btnNewButton2_4.setBounds(321, 560, 162, 113);
        		timeChargePanel.add(btnNewButton2_4);
        		
        		JButton btnNewButton2_5 = new JButton("New button");
        		btnNewButton2_5.setBounds(535, 560, 162, 113);
        		timeChargePanel.add(btnNewButton2_5);
        		
                JButton btnNewButton_6 = new JButton("다음");
	     		btnNewButton_6.setBounds(224, 766, 141, 41);
	     		timeChargePanel.add(btnNewButton_6);
	     		
	     		JButton omePasscloseButton = new JButton("닫기");
	     		omePasscloseButton.setBounds(425, 766, 141, 41);
	     		timeChargePanel.add(omePasscloseButton);
	     		
	     		omePasscloseButton.addActionListener(new ActionListener() {
	     			public void actionPerformed(ActionEvent e) {
	     				timeChargeDialog.dispose(); // JDialog 종료
	     			}
                });
            }
        });
        setLayout(null);	
        setResizable(false); // 크기 고정 
        setUndecorated(true); // 윈도우 프레임 없애기
        setLocationRelativeTo(null); // 다이얼로그 화면 중앙에 위치
	    setLocation(500, 300);   
	    setSize(930, 700);
	    setVisible(true);
	}
}
