package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import button.LockerButton;

import javax.swing.JLabel;
import java.awt.Font;

public class LockerPanel extends JPanel {
	private BufferedImage image;
	List<LockerButton> lockerBtns = new ArrayList<>();
	int btnCtn = 1;
	/**
	 * Create the panel.
	 */
	public LockerPanel() {
		
		try {
            image = ImageIO.read(new File("ui/Select_Locker/lockerFrame.png"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				LockerButton lockerBtn = new LockerButton();
				lockerBtn.setText(Integer.toString(btnCtn++));
				lockerBtn.setBackground(new Color(217, 217, 217));
				lockerBtn.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 30));
				add(lockerBtn);
				lockerBtns.add(lockerBtn);
				lockerBtn.setLocation(310 + (110 * j), 110 + (110 * i));
			}
		}
		
		JLabel myLockerLabel = new JLabel("이용하실 사물함을 선택해주세요");
		myLockerLabel.setForeground(new Color(255, 255, 255));
		myLockerLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 50));
		myLockerLabel.setBounds(240, 13, 800, 72);
		add(myLockerLabel);
		
		JLabel myUsedLockerLabel = new JLabel();
		myUsedLockerLabel.setBounds(23, 23, 150, 100);
		myUsedLockerLabel.setIcon(new ImageIcon("ui/Select_Locker/remain2.png"));
		add(myUsedLockerLabel);
		
		setBounds(633, 381, 1177, 617);
		setBackground(new Color(73, 67, 68));
		setLayout(null);
	}
	
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.drawImage(image, 0, 0, this);
	 }
}
