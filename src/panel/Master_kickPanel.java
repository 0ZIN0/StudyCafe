package panel;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import color.MyColor;

public class Master_kickPanel extends JPanel {

	CardLayout card = new CardLayout();

	ImageIcon panel_icon = new ImageIcon("ui/master_seat_kick/Master_UserDischarge_ContentsArea.jpg");
	Image panel_image = panel_icon.getImage();

	JPanel backgroundPanel = new JPanel() {
		/** 백그라운드 이미지 페인팅 메서드 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(panel_image, 0, 0, this);
		};
	};

	JPanel parentPanel = new JPanel(); // 부모패널
	JPanel seatKickPanel = new Master_SeatKickPanel();
	JPanel studyRoomKickPanel = new Master_StudyRoomKickPanel();
	JPanel lockerKickPanel = new Master_LockerKickPanel();

	ButtonGroup group = new ButtonGroup();
	public static JButton seatBtn = new JButton(new ImageIcon("ui/master_seat_kick/Seat_Button_On.png"));
	JButton studyRoomBtn = new JButton(new ImageIcon("ui/master_seat_kick/StudyRoom_Button_Off.png"));
	JButton lockerBtn = new JButton(new ImageIcon("ui/master_seat_kick/Locker_Button_Off.png"));

	public Master_kickPanel() {

		group.add(seatBtn);
		group.add(studyRoomBtn);
		group.add(lockerBtn);

		seatBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(parentPanel, "seatKick");
				
				Master_StudyRoomKickPanel.table.clearSelection();
				Master_LockerKickPanel.table.clearSelection();
				seatBtn.setIcon(new ImageIcon("ui/master_seat_kick/Seat_Button_On.png"));
				studyRoomBtn.setIcon(new ImageIcon("ui/master_seat_kick/StudyRoom_Button_Off.png"));
				lockerBtn.setIcon(new ImageIcon("ui/master_seat_kick/Locker_Button_Off.png"));
			}
		});

		studyRoomBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(parentPanel, "studyRoomKick");
				
				Master_SeatKickPanel.table.clearSelection();
				Master_LockerKickPanel.table.clearSelection();
				seatBtn.setIcon(new ImageIcon("ui/master_seat_kick/Seat_Button_Off.png"));
				studyRoomBtn.setIcon(new ImageIcon("ui/master_seat_kick/StudyRoom_Button_On.png"));
				lockerBtn.setIcon(new ImageIcon("ui/master_seat_kick/Locker_Button_Off.png"));
			}
		});
		
		lockerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(parentPanel, "lockerKick");
				
				Master_SeatKickPanel.table.clearSelection();
				Master_StudyRoomKickPanel.table.clearSelection();
				seatBtn.setIcon(new ImageIcon("ui/master_seat_kick/Seat_Button_Off.png"));
				studyRoomBtn.setIcon(new ImageIcon("ui/master_seat_kick/StudyRoom_Button_Off.png"));
				lockerBtn.setIcon(new ImageIcon("ui/master_seat_kick/Locker_Button_On.png"));
			}
		});

		seatBtn.setBounds(224, 68, 420, 141);
		studyRoomBtn.setBounds(650, 68, 420, 141);
		lockerBtn.setBounds(1076, 68, 420, 141);

		seatBtn.setOpaque(false);
		studyRoomBtn.setOpaque(false);
		lockerBtn.setOpaque(false);

		seatBtn.setContentAreaFilled(false);
		studyRoomBtn.setContentAreaFilled(false);
		lockerBtn.setContentAreaFilled(false);


		seatBtn.setBorderPainted(false);
		studyRoomBtn.setBorderPainted(false);
		lockerBtn.setBorderPainted(false);

		backgroundPanel.setSize(1700, 760);
		backgroundPanel.setLayout(null);
		backgroundPanel.setBackground(MyColor.CLEAR);

		parentPanel.setLayout(card);
		parentPanel.add(seatKickPanel, "seatKick");
		parentPanel.add(studyRoomKickPanel, "studyRoomKick");
		parentPanel.add(lockerKickPanel, "lockerKick");
		parentPanel.setBounds(50, 210, 1600, 540);
		

		backgroundPanel.add(seatBtn);
		backgroundPanel.add(studyRoomBtn);
		backgroundPanel.add(lockerBtn);
		backgroundPanel.add(parentPanel);
		
		setOpaque(false);
		add(backgroundPanel);
		setSize(1700, 760);
		setLayout(null);
	}
}
