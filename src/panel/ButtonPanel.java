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

public class ButtonPanel extends JPanel implements ActionListener{
   
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
			} else {
				btns.get(i).setIcon(images[i]);
			}
		}
		
	}
	
	
	
}
