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
import dao.LockerDAO;
import frame.MainFrame;
import label.RemainLockerLabel;

import javax.swing.JLabel;
import java.awt.Font;

public class LockerPanel extends JPanel {
	
	public static String lockerNum;
	private BufferedImage image;
	
	int btnCtn = 1;
	public static List<LockerButton> lockerBtns = new ArrayList<>();
	private List<String[]> isUse = LockerDAO.isUse();
	
	public static RemainLockerLabel remainLockerLabel = new RemainLockerLabel();
	public static JLabel myLockerLabel = new JLabel();
	LockerDAO lockerDao = new LockerDAO();
	int remain = lockerDao.remainLocker();
	
	public LockerPanel() {
		
		try {
            image = ImageIO.read(new File("ui/Select_Locker/lockerFrame.png"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				LockerButton lockerBtn = new LockerButton(btnCtn++, isUse);
				add(lockerBtn);
				lockerBtns.add(lockerBtn);
				lockerBtn.setLocation(310 + (110 * j), 110 + (110 * i));
			}
		}
		
		myLockerLabel.setForeground(new Color(255, 255, 255));
		myLockerLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 50));
		myLockerLabel.setBounds(240, 13, 800, 72);
		add(myLockerLabel);
		
		for(String[] use : isUse) {
			if(use[1] == (MainFrame.member.getLocker_number()) && use[0] != null) {
				myLockerLabel.setText(String.format("%s번 사물함을 사용중입니다", use[0]));
				myLockerLabel.setBounds(280, 13, 800, 72);
			} else {
				myLockerLabel.setText("이용하실 사물함을 선택해주세요");
			}
		}
		
		
		remainLockerLabel.setBounds(26, 3, 200, 100);
		add(remainLockerLabel);
		
		JLabel inUseLockerBg = new JLabel();
		inUseLockerBg.setBounds(23, 5, 150, 100);
		inUseLockerBg.setIcon(new ImageIcon("ui/Select_Locker/remain2.png"));
		inUseLockerBg.setBackground(new Color(0,0,0,0));
		add(inUseLockerBg);
		
		setBounds(633, 381, 1177, 617);
		setBackground(new Color(73, 67, 68));
		setLayout(null);
	}
	
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.drawImage(image, 0, 0, this);
	 }
	 
	 public static String getLockerNum() {

		 return lockerNum;
	 }
}
