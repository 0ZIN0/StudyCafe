
package dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class TimeChargeDialogPrevious extends JDialog {
	
	// 나중에 없앨 예정  
	public TimeChargeDialogPrevious() {
		
		
		
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
		
		
		
		
       
 		
 		JButton onePasscloseButton = new JButton("닫기");
 		onePasscloseButton.setBounds(224, 766, 141, 41);
 		timeChargePanel.add(onePasscloseButton);
 		
 		onePasscloseButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				dispose(); // JDialog 종료
 			}
       });
 		
 		 JButton btnNewButton_6 = new JButton("다음");
  		btnNewButton_6.setBounds(425, 766, 141, 41);
  		timeChargePanel.add(btnNewButton_6);
  		
  		btnNewButton_6.addActionListener(new ActionListener() { 
             public void actionPerformed(ActionEvent e) {
                 dispose(); 
                 PaymentInformationDialog paymentInformationDialog = new PaymentInformationDialog();
             }
         });
 	    
 	  add(timeChargePanel);
 	  setBounds(600, 100, 800, 900);
 	  setModal(true);
	  setVisible(true);
		
		
	}

}
