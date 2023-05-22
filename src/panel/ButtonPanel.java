package panel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import button.LockerTicketButton;
import dialog.LockerPayDialog;
import dialog.PaymentDialog;
import dialog.TimeOrPeriodChargeDialog;
import frame.CheckInFrame;

public class ButtonPanel extends JPanel implements ActionListener{
   
	public static int lockerChargePrice; 
	public static int lockerChargeItem;

	int periodChargePrice = PeriodChargePanel.getPeriodChargePrice();
	int timeChargePrice = TimeChargePanel.getTimeChargePrice();
	int onePassChargePrice = OnePassChargePanel.getOnePassChargePrice();
	int studyRoomChargePrice = PaymentDialog.getStudyRoomchargePrice();
	
	ImageIcon[] images = new ImageIcon[] {
			new ImageIcon("ui/Locker_PopUp/Button_2.png"),
			new ImageIcon("ui/Locker_PopUp/Button_4.png"),
			new ImageIcon("ui/Locker_PopUp/Button_8.png"),
			new ImageIcon("ui/Locker_PopUp/Button_12.png")
	};
	
	ImageIcon[] selectedImages = new ImageIcon[] {
			new ImageIcon("ui/Locker_PopUp/Button_2_Selected.png"),
			new ImageIcon("ui/Locker_PopUp/Button_4_Selected.png"),
			new ImageIcon("ui/Locker_PopUp/Button_8_Selected.png"),
			new ImageIcon("ui/Locker_PopUp/Button_12_Selected.png")
	};
	
	List<LockerTicketButton> btns = new ArrayList<>();
	
	ButtonGroup togGroup = new ButtonGroup();
	
	String[] periods = new String[] {
			"2주", "4주", "8주", "12주"
	};
	
	String[] fees = new String[] {
			"6,000원", "10,000원", "20,000원", "30,000원"
	};
		
	JLabel periodLabel;
	JLabel feeLabel;
	
	public ButtonPanel(JLabel periodLabel, JLabel feeLabel) {
		this.periodLabel = periodLabel;
		this.feeLabel = feeLabel;
		
    	setLayout(new GridLayout(2, 2, 20, 20));  // 2행 2열의 그리드 레이아웃
    	setSize(420, 420);
    	
    	
        // 버튼 생성
        for (int i = 0; i < 4; i++) {
            LockerTicketButton ticketButton = new LockerTicketButton();
            btns.add(ticketButton);
            togGroup.add(ticketButton);
            ticketButton.setIcon(images[i]);
            ticketButton.addActionListener(this);
            add(ticketButton);
        }
        
        btns.get(0).setSelected(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		int btnNum = btns.indexOf(e.getSource());
		periodLabel.setText(periods[btnNum]);
		feeLabel.setText(fees[btnNum]);
		
		for(int i = 0; i < btns.size(); i++) {
			if(i == btnNum) {
				btns.get(btnNum).setIcon(selectedImages[btnNum]);
				
				/* 버튼 선택값 초기화 */
				OnePassChargePanel.onePassChargePrice = 0;
				TimeChargePanel.timeChargePrice  = 0; 
				PeriodChargePanel.periodChargePrice = 0;
				PaymentDialog.studyRoomChargePrice = 0;
				ButtonPanel.lockerChargePrice = 0;
				
				if(btnNum == 0) {
					CheckInFrame.ticket_order.setTicket_id("T-15");
					//CheckInFrame.member_dto.setLocker_remain("14");
					lockerChargePrice = 6000;
					lockerChargeItem = 2;
					
				} else if (btnNum == 1) {
					CheckInFrame.ticket_order.setTicket_id("T-16");
					lockerChargePrice = 10000;
					lockerChargeItem = 4;
					
				} else if (btnNum == 2) {
					CheckInFrame.ticket_order.setTicket_id("T-17");
					lockerChargePrice = 20000;
					lockerChargeItem = 8;
					
				} else if (btnNum == 3) {
					CheckInFrame.ticket_order.setTicket_id("T-18");
					lockerChargePrice = 30000;
					lockerChargeItem = 12;
				}
				
			} else {
				btns.get(i).setIcon(images[i]);
			}
		}
	}
	
	
	public static int getLockerChargePrice() {
		return lockerChargePrice;
	}
	
	public void setLockerChargePrice(int price) {
		lockerChargePrice = price;
	}
	
	public static int getLockerChargeItem() {
		return lockerChargeItem;
	}
	
	public void setLockerChargeItem(int item) {
		lockerChargeItem = item;
	}
	
}
