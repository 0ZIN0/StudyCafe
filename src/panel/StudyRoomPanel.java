package panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import label.DateLabel;

public class StudyRoomPanel extends JPanel {

	/* 배경 */
	backgroundPanel image = new backgroundPanel(new ImageIcon("ui/study_room/studyRoom_Frame.png"), new Color(0x494344));

	/* 버튼 */
	JButton topLeftBtn = new JButton(new ImageIcon("ui/study_room/Main_Arrow_01.png"));
	JButton topRightBtn = new JButton(new ImageIcon("ui/study_room/Main_Arrow_03.png"));
	JButton bottomLeftBtn = new JButton(new ImageIcon("ui/study_room/Sub_Arrow_01.png"));
	JButton bottomRightBtn = new JButton(new ImageIcon("ui/study_room/Sub_Arrow_03.png"));
	JButton upBtn = new JButton();
	JButton downBtn = new JButton();
	JButton paymentBtn = new JButton();

	/* 라벨 */
	JLabel roomNumLabel = new JLabel(new ImageIcon("ui/study_room/studyRoom_01.png"));
	JLabel isTodayLabel = new JLabel("TODAY");
	DateLabel dateLabel = new DateLabel();
	JLabel startTimeLabel = new JLabel();
	JLabel whatTimeLabel = new JLabel(); // 1 or 2

	public StudyRoomPanel() {

		/* 버튼 설정 */
		topLeftBtn.setBounds(122, 40, 40, 60);
		topLeftBtn.setBorderPainted(false);
		topLeftBtn.setContentAreaFilled(false);
		topLeftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String room1 = "ui/study_room/studyRoom_01.png";
				roomNumLabel.setIcon(new ImageIcon(room1));

				topLeftBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_01.png"));
				topRightBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_03.png"));
			}
		});

		topRightBtn.setBounds(434, 40, 40, 60);
		topRightBtn.setBorderPainted(false);
		topRightBtn.setContentAreaFilled(false);
		topRightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String room2 = "ui/study_room/studyRoom_02.png";
				roomNumLabel.setIcon(new ImageIcon(room2));

				topLeftBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_04.png"));
				topRightBtn.setIcon(new ImageIcon("ui/study_room/Main_Arrow_02.png"));
			}
		});

		//		======================================================================================s

		bottomLeftBtn.setBounds(122, 162, 34, 52);
		bottomLeftBtn.setBorderPainted(false);
		bottomLeftBtn.setContentAreaFilled(false);

		bottomLeftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dateLabel.getSelectDay().add(Calendar.DATE, -1);
				dateLabel.setSelectDay(dateLabel.getSelectDay());
			}
		});

		bottomRightBtn.setBounds(440, 162, 34, 52);
		bottomRightBtn.setBorderPainted(false);
		bottomRightBtn.setContentAreaFilled(false);
		bottomRightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dateLabel.getSelectDay().add(Calendar.DATE, 1);
				dateLabel.setSelectDay(dateLabel.getSelectDay());
			}
		});
		
		/* 라벨 설정 */
		roomNumLabel.setBounds(175, 48, 237, 38);
		dateLabel.setBounds(272, 169, 160, 34);

		/* 버튼, 라벨 붙이기 */
		image.add(topLeftBtn);
		image.add(topRightBtn);
		image.add(bottomLeftBtn);
		image.add(bottomRightBtn);

		image.add(roomNumLabel);
		image.add(dateLabel);

		/* 패널 설정 */
		image.setLayout(null);
		add(image);
	}
	
	
	
}
