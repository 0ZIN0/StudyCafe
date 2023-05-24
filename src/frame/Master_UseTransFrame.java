package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import button.BuyButton;
import button.LeaveButton;
import button.OpenDoorButton;
import dao.SeatDAO;
import dto.Member;
import dto.Seat;
import dto.StudyRoomButtonList;
import panel.LockerPanel;
import panel.MainPanel;
import panel.MyPagePanel;
import panel.SeatReportPanel;
import panel.StudyRoomPanel;
import toggle.LockerToggle;
import toggle.SeatReportToggle;
import toggle.StudyRoomToggle;

public class Master_UseTransFrame extends JFrame {

	/* 레이아웃 */
	public static CardLayout card = new CardLayout();
	
	/* 이미지들 */
	// 백그라운드 이미지
	ImageIcon backgroundImageIcon = new ImageIcon("ui/background/Select_Seat_last_1.png");
	Image backgroundImage = backgroundImageIcon.getImage(); 

	// 개인석 이미지
	ImageIcon seatReportImageIcon = new ImageIcon("ui/seatReportToggleButton.png");

	// 스터디룸 이미지
	ImageIcon studyRoomdImageIcon = new ImageIcon("ui/studyRoomToggleButton.png");

	// 사물함 이미지
	ImageIcon lockerImageIcon = new ImageIcon("ui/lockerToggleButton.png");

	/* 패널 */
	JPanel mainPanel = new MainPanel(backgroundImage); // 백그라운드 패널
	JPanel subPanel = new JPanel(); // seat, study, locker 패널들의 부모가 될 서브 패널
	public static SeatReportPanel seatReportPanel; // 좌석현황 패널
	JPanel studyRoomPanel; // 스터디룸 예약 패널
	JPanel lockerPanel; // 사물함 구매 패널
	MyPagePanel myPagePanel; // 마이페이지 패널

	List<Seat> seats = SeatReportPanel.getSeats();

	/* 메인 토글버튼 */
	JToggleButton seatReportTog = new SeatReportToggle(seatReportImageIcon, card, seatReportPanel, subPanel);
	JToggleButton studyRoomTog = new StudyRoomToggle(studyRoomdImageIcon, card, studyRoomPanel, subPanel);
	JToggleButton lockerTog = new LockerToggle(lockerImageIcon, card, lockerPanel, subPanel);
	ButtonGroup togGroup = new ButtonGroup(); // 토글버튼 그룹 지정


	// 시간 라벨
	public static JLabel timeLabel = new JLabel();

	/* DTO */ 
	public static Member member = SeatDAO.setMember("010-1111-1111");
	
	public static StudyRoomButtonList btns = new StudyRoomButtonList();
	
	/**
	 * Create the frame.
	 */
	public Master_UseTransFrame() {
//		this.member = member;
		/* 패널 */
		seatReportPanel  = new SeatReportPanel(member); // 좌석현황 패널
		studyRoomPanel = new StudyRoomPanel(member); // 스터디룸 예약 패널
		lockerPanel = new LockerPanel(); // 사물함 구매 패널
		
		studyRoomPanel.setVisible(false);
		
		timeLabel.setBounds(100, 0, 500, 100);
		timeLabel.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 24));
		timeLabel.setForeground(Color.white);

		/* 메인패널 투명화 설정 */
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		setLayout(card);
		/* 메인 토글버튼 그룹 설정 */
		togGroup.add(seatReportTog);
		togGroup.add(studyRoomTog);
		togGroup.add(lockerTog);

		/* 토글버튼 위치 설정 */
		seatReportTog.setBounds(123, 406, 483, 178);
		studyRoomTog.setBounds(123, 604, 483, 178);
		lockerTog.setBounds(123, 802, 483, 178);

		/**************************************************** 토글 전체 설정 ****************************************************/
		seatReportTog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatReportTog.setIcon(seatReportImageIcon);

				studyRoomTog.setIcon(null);
				lockerTog.setIcon(null);
				
				studyRoomPanel.removeAll();

				JPanel studyRoomPanel = new StudyRoomPanel(member);

				studyRoomPanel.setBackground(new Color(0x494344));
				studyRoomPanel.setLayout(null);
				studyRoomPanel.setBounds(633, 381, 1177, 617);

				subPanel.add(studyRoomPanel, "study");
				studyRoomPanel.repaint();

			}
		});


		studyRoomTog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				studyRoomTog.setIcon(studyRoomdImageIcon);

				seatReportTog.setIcon(null);
				lockerTog.setIcon(null);
			}
		});

		lockerTog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lockerTog.setIcon(lockerImageIcon);

				seatReportTog.setIcon(null);
				studyRoomTog.setIcon(null);

				studyRoomPanel.removeAll();

				JPanel studyRoomPanel = new StudyRoomPanel(member);

				studyRoomPanel.setBackground(new Color(0x494344));
				studyRoomPanel.setLayout(null);
				studyRoomPanel.setBounds(633, 381, 1177, 617);

				subPanel.add(studyRoomPanel, "study");
				
			}
		});
		/******************************************************************************************************************/

		/* 서브 패널 설정 */
		subPanel.setBounds(633, 381, 1177, 617); // seat, study, locker 패널들의 부모가 될 서브 패널
		subPanel.setLayout(card);

		/* 서브 패널의 하위 패널 레이아웃 설정 */
		
		studyRoomPanel.setLayout(null);
		lockerPanel.setLayout(null);

		/* 서브 패널의 하위 패널 위치 지정 */
		seatReportPanel.setBounds(633, 381, 1177, 617);
		studyRoomPanel.setBounds(633, 381, 1177, 617);
		lockerPanel.setBounds(633, 381, 1177, 617);

		/* 서브 패널의 하위 패널 배경 지정 */
		studyRoomPanel.setBackground(new Color(0x494344));
		lockerPanel.setBackground(new Color(0x494344));

		/* 서브 패널을 컨테이너로 지정하여 컨테이너에 카드 추가 */
		subPanel.add(seatReportPanel, "seat");
		subPanel.add(studyRoomPanel, "study");
		subPanel.add(lockerPanel, "locker");

		// 프레임(getContentPane())에 메인 패널 붙이기
		getContentPane().add(mainPanel, "main");

		// 메인 패널에 잡것들 붙이기
		mainPanel.add(subPanel);
		mainPanel.add(seatReportTog);
		mainPanel.add(studyRoomTog);
		mainPanel.add(lockerTog);
		mainPanel.add(timeLabel);

		/* 기본 설정 */
		mainPanel.setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Master_UseTransFrame();
	}
}
