package panel;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.SeatButton;
import dto.Seat;
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

	/* 좌석버튼 객체 */
	
	JButton seat1 = new SeatButton("1");
	JButton seat2 = new SeatButton("2");
	JButton seat3 = new SeatButton("3");
	JButton seat4 = new SeatButton("4");
	JButton seat5 = new SeatButton("5");
	JButton seat6 = new SeatButton("6");
	JButton seat7 = new SeatButton("7");
	JButton seat8 = new SeatButton("8");
	JButton seat9 = new SeatButton("9");
	JButton seat10 = new SeatButton("10");
	JButton seat11 = new SeatButton("11");
	JButton seat12 = new SeatButton("12");
	JButton seat13 = new SeatButton("13");
	JButton seat14 = new SeatButton("14");
	JButton seat15 = new SeatButton("15");
	JButton seat16 = new SeatButton("16");
	JButton seat17 = new SeatButton("17");
	JButton seat18 = new SeatButton("18");
	JButton seat19 = new SeatButton("19");
	JButton seat20 = new SeatButton("20");
	JButton seat21 = new SeatButton("21");
	JButton seat22 = new SeatButton("22");
	JButton seat23 = new SeatButton("23");
	JButton seat24 = new SeatButton("24");
	JButton seat25 = new SeatButton("25");
	JButton seat26 = new SeatButton("26");
	JButton seat27 = new SeatButton("27");
	JButton seat28 = new SeatButton("28");
	JButton seat29 = new SeatButton("29");
	JButton seat30 = new SeatButton("30");
	JButton seat31 = new SeatButton("31");
	JButton seat32 = new SeatButton("32");

	/* 스터디카페의 좌석 현황을 숫자로 보여주는 라벨 */
	JLabel seatReportLabel = new JLabel();
	
	/* 사용자가 이용하고 있는 좌석 안내 라벨 */
	JLabel seatInfoLabel = new SeatReportLabel();

	public SeatReportPanel(Image seatImage) {
		
		for(int i = 0; i < 32; i++) {
			Seat seat = new Seat();
			seats.add(seat);
		}
		
		for(int i = 0; i < 32; i++) {
			SeatButton seatBtn = new SeatButton(Integer.toString(i + 1));
			seatBtns.add(seatBtn);
		}
		this.seatImage = seatImage;

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
		
//		add(seat1);
//		add(seat2);
//		add(seat3);
//		add(seat4);
//		add(seat5);
//		add(seat6);
//		add(seat7);
//		add(seat8);
//		add(seat9);
//		add(seat10);
//		add(seat11);
//		add(seat12);
//		add(seat13);
//		add(seat14);
//		add(seat15);
//		add(seat16);
//		add(seat17);
//		add(seat18);
//		add(seat19);
//		add(seat20);
//		add(seat21);
//		add(seat22);
//		add(seat23);
//		add(seat24);
//		add(seat25);
//		add(seat26);
//		add(seat27);
//		add(seat28);
//		add(seat29);
//		add(seat30);
//		add(seat31);
//		add(seat32);
		
		/* 좌석 현황 라벨 설정 */
		add(seatInfoLabel);
		
		/* 좌석 이용 유무 라벨 설정 */
		add(seatReportLabel);
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
