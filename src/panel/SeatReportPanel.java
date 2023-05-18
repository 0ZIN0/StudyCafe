package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.SeatButton;
import dao.SeatDAO;
import dto.Member;
import dto.Seat;
import frame.CheckInFrame;
import label.RemainSeatLabel;
import label.SeatReportLabel;

public class SeatReportPanel extends JPanel {
	
	Image seatImage;
	
	static List<Seat> seats = new ArrayList<>();
	static List<SeatButton> seatBtns = new ArrayList<>();
	
	/* 스터디룸, 사물함 버튼 */
	JButton studyRoom1Btn = new JButton(new ImageIcon("ui/Select_Seat_Parts_img/StudyRoom_1.png"));
	JButton studyRoom2Btn = new JButton(new ImageIcon("ui/Select_Seat_Parts_img/StudyRoom_2.png"));

	JButton Locker1Btn = new JButton(new ImageIcon("ui/Select_Seat_Parts_img/storage_box1.png"));
	JButton Locker2Btn = new JButton(new ImageIcon("ui/Select_Seat_Parts_img/storage_box2.png"));
	
	/* 잔여좌석을 알려주는 라벨 */
	JLabel remainSeatPanel = new JLabel(new ImageIcon("ui/Select_Seat_Parts_img/Seat_list_box.png"));
	JLabel remainSeatLabel = new RemainSeatLabel();
	
	/* 사용자가 이용하고 있는 좌석 안내 라벨 */
	public static JLabel seatInfoLabel = new SeatReportLabel();
	public static int mySeat = SeatDAO.isUsingMySeat(CheckInFrame.member.getMember_id());
	public static JLabel seatNumLabel = new JLabel(String.valueOf(mySeat));
	
	
	public SeatReportPanel(Image seatImage, Member member) {
		
		for(int i = 0; i < 32; i++) {
			Seat seat = new Seat();
			seats.add(seat);
		}
		
		for(int i = 0; i < 32; i++) {
			SeatButton seatBtn = new SeatButton(Integer.toString(i + 1));
			seatBtns.add(seatBtn);
		}
		this.seatImage = seatImage;
		
		/* 잔여 좌석 라벨 설정 */
		remainSeatPanel.setBounds(114, 22, 130, 54);
		remainSeatLabel.setBounds(119, 19, 200, 54);
		/* 스터디룸, 사물함 설정 */
		studyRoom1Btn.setBounds(100, 113, 160, 60);
		studyRoom1Btn.setContentAreaFilled(false);
		studyRoom1Btn.setBorderPainted(false);

		studyRoom2Btn.setBounds(100, 203, 160, 60);
		studyRoom2Btn.setContentAreaFilled(false);
		studyRoom2Btn.setBorderPainted(false);

		Locker1Btn.setBounds(100, 323, 160, 60);
		Locker1Btn.setContentAreaFilled(false);
		Locker1Btn.setBorderPainted(false);

		Locker2Btn.setBounds(100, 413, 160, 60);
		Locker2Btn.setContentAreaFilled(false);
		Locker2Btn.setBorderPainted(false);

		/* 좌석 버튼 설정 */
		seatBtns.get(0).setBounds(388, 124, 60, 60);
		seatBtns.get(1).setBounds(388, 192, 60, 60);
		seatBtns.get(2).setBounds(388, 260, 60, 60);
		seatBtns.get(3).setBounds(388, 328, 60, 60);
		seatBtns.get(4).setBounds(388, 400, 60, 60);
		seatBtns.get(5).setBounds(457, 400, 60, 60);
		seatBtns.get(6).setBounds(527, 400, 60, 60);
		seatBtns.get(7).setBounds(597, 400, 60, 60);
		seatBtns.get(8).setBounds(667, 400, 60, 60);
		seatBtns.get(9).setBounds(737, 400, 60, 60);
		seatBtns.get(10).setBounds(807, 400, 60, 60);
		seatBtns.get(11).setBounds(877, 400, 60, 60);
		seatBtns.get(12).setBounds(947, 400, 60, 60);
		seatBtns.get(13).setBounds(1017, 400, 60, 60);
		seatBtns.get(14).setBounds(483, 129, 60, 60);
		seatBtns.get(15).setBounds(560, 129, 60, 60);
		seatBtns.get(16).setBounds(692, 129, 60, 60);
		seatBtns.get(17).setBounds(769, 129, 60, 60);
		seatBtns.get(18).setBounds(910, 129, 60, 60);
		seatBtns.get(19).setBounds(987, 129, 60, 60);
		seatBtns.get(20).setBounds(482, 227, 60, 60);
		seatBtns.get(21).setBounds(559, 227, 60, 60);
		seatBtns.get(22).setBounds(691, 227, 60, 60);
		seatBtns.get(23).setBounds(768, 227, 60, 60);
		seatBtns.get(24).setBounds(909, 227, 60, 60);
		seatBtns.get(25).setBounds(986, 227, 60, 60);
		seatBtns.get(26).setBounds(482, 325, 60, 60);
		seatBtns.get(27).setBounds(559, 325, 60, 60);
		seatBtns.get(28).setBounds(691, 325, 60, 60);
		seatBtns.get(29).setBounds(768, 325, 60, 60);
		seatBtns.get(30).setBounds(909, 325, 60, 60);
		seatBtns.get(31).setBounds(986, 325, 60, 60);
		
		add(studyRoom1Btn);
		add(studyRoom2Btn);

		add(Locker1Btn);
		add(Locker2Btn);
		
		for(int i = 0; i < seatBtns.size(); i++) {
			add(seatBtns.get(i));
		}
		
		/* 좌석 현황 라벨 설정 */
		add(remainSeatLabel);
		add(remainSeatPanel);
		
		/* 좌석 이용 유무 라벨 설정 */
		
		if (mySeat != 0) {
			seatNumLabel.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 45));
			seatNumLabel.setForeground(new Color(0xFF5C01));
			seatNumLabel.setBounds(497, 28, 550, 50);
			seatNumLabel.setVisible(true);
		} else {
			seatNumLabel.setVisible(false);
		}
		add(seatNumLabel);
		add(seatInfoLabel);
	}

	/** 좌석현황 패널 이미지 적용하는 메서드 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(seatImage, 0, 0, getWidth(), getHeight(), this);
	}
	
	public static List<Seat> getSeats() {
		return seats;
	}
}
