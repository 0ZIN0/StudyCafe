package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import button.BuyButton;
import button.LeaveButton;
import button.OpenDoorButton;
import button.SeatButton;
import dto.Seat;
import panel.LockerPanel;
import panel.MainPanel;
import panel.MyPagePanel;
import panel.SeatReportPanel;
import panel.StudyRoomPanel;
import toggle.LockerToggle;
import toggle.SeatReportToggle;
import toggle.StudyRoomToggle;

/*
 * 이 프레임이 메인 프레임입니다.
 *  */
public class CheckInFrame extends JFrame {
	/* 레이아웃 */
	CardLayout card = new CardLayout();
	
	/* 이미지들 */
	// 백그라운드 이미지
	ImageIcon backgroundImageIcon = new ImageIcon("ui/background/Select_Seat_last_1.png");
	Image backgroundImage = backgroundImageIcon.getImage(); 
	
	// 개인석 패널 이미지
	ImageIcon seatReportPanelImageIcon = new ImageIcon("ui/Select_Seat_Parts_img/seatReport_Frame.png");
	Image seatReportImage = seatReportPanelImageIcon.getImage(); 
	
	// 개인석 이미지
	ImageIcon seatReportImageIcon = new ImageIcon("ui/seatReportToggleButton.png");
	
	// 스터디룸 이미지
	ImageIcon studyRoomdImageIcon = new ImageIcon("ui/studyRoomToggleButton.png");

	// 사물함 이미지
	ImageIcon lockerImageIcon = new ImageIcon("ui/lockerToggleButton.png");
	
	// 출입문열림 이미지
	ImageIcon openDoorImageIcon = new ImageIcon("ui/Select_Seat_Parts_img/Top_button_1.png");
	
	// 퇴실예정좌석 이미지
	ImageIcon leaveImageIcon = new ImageIcon("ui/Select_Seat_Parts_img/Top_button_2.png");
	
	// 상품충전 이미지
	ImageIcon buyImageIcon = new ImageIcon("ui/Select_Seat_Parts_img/Top_button_3.png");
	
	/* 패널 */
	JPanel mainPanel = new MainPanel(backgroundImage); // 백그라운드 패널
	JPanel subPanel = new JPanel(); // seat, study, locker 패널들의 부모가 될 서브 패널
	JPanel seatReportPanel = new SeatReportPanel(seatReportImage); // 좌석현황 패널
	JPanel studyRoomPanel = new StudyRoomPanel(); // 스터디룸 예약 패널
	JPanel lockerPanel = new LockerPanel(); // 사물함 구매 패널
	MyPagePanel myPagePanel = new MyPagePanel(); // 마이페이지 패널
	
	List<Seat> seats = SeatReportPanel.getSeats();
	/* 메인 토글버튼 */
	JToggleButton seatReportTog = new SeatReportToggle(seatReportImageIcon, card, seatReportPanel, subPanel);
	JToggleButton studyRoomTog = new StudyRoomToggle(studyRoomdImageIcon, card, studyRoomPanel, subPanel);
	JToggleButton lockerTog = new LockerToggle(lockerImageIcon, card, lockerPanel, subPanel);
	ButtonGroup togGroup = new ButtonGroup(); // 토글버튼 그룹 지정

	/* 탑 버튼 */
	JButton openDoorBtn = new OpenDoorButton(openDoorImageIcon, this);
	JButton leaveBtn = new LeaveButton(leaveImageIcon, seats);
	JButton buyBtn = new BuyButton(buyImageIcon);
	
	/* 마이페이지, 로그아웃 버튼 */
	JButton logoutBtn = new JButton("로그아웃");
	JButton mypageBtn = new JButton("마이페이지");
	
	/* x버튼 */
	JButton xBtn = new JButton("X");

	/**
	 * Create the frame.
	 */
	public CheckInFrame() {
		
		
		System.out.println(seats.size());
		
		this.seats = seats;
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
			}
		});
		/******************************************************************************************************************/
		
		/* 서브 패널 설정 */
		subPanel.setBounds(633, 381, 1177, 617); // seat, study, locker 패널들의 부모가 될 서브 패널
		subPanel.setLayout(card);

		/* 서브 패널의 하위 패널 레이아웃 설정 */
		seatReportPanel.setLayout(null);
		studyRoomPanel.setLayout(null);
		lockerPanel.setLayout(null);

		/* 서브 패널의 하위 패널 위치 지정 */
		seatReportPanel.setBounds(633, 381, 1177, 617);
		studyRoomPanel.setBounds(633, 381, 1177, 617);
		lockerPanel.setBounds(633, 381, 1177, 617);

		/* 서브 패널의 하위 패널 배경 지정 */
		seatReportPanel.setBackground(new Color(0x494344));
		studyRoomPanel.setBackground(new Color(0x494344));
		lockerPanel.setBackground(new Color(0x494344));

		/* 서브 패널을 컨테이너로 지정하여 컨테이너에 카드 추가 */
		subPanel.add(seatReportPanel, "seat");
		subPanel.add(studyRoomPanel, "study");
		subPanel.add(lockerPanel, "locker");

		/* 탑 버튼 설정 */
		openDoorBtn.setBounds(841, 240, 240, 80);
		leaveBtn.setBounds(1101, 240, 240, 80);
		buyBtn.setBounds(1361, 240, 240, 80);
		
		/* 로그아웃, 마이페이지 버튼 */
		logoutBtn.setBounds(62, 114, 200, 40);
		logoutBtn.setForeground(new Color(0xFF5C00));
		logoutBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		logoutBtn.setContentAreaFilled(false);
		logoutBtn.setBorderPainted(false);

		mypageBtn.setBounds(1592, 114, 300, 40);
		mypageBtn.setForeground(new Color(0xFF5C00));
		mypageBtn.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 30));
		mypageBtn.setContentAreaFilled(false);
		mypageBtn.setBorderPainted(false);
		
		// 프레임(getContentPane())에 메인 패널 붙이기
		getContentPane().add(mainPanel, "main");
		getContentPane().add(myPagePanel, "myPage");
		
		// 메인 패널에 잡것들 붙이기
		mainPanel.add(subPanel);
		mainPanel.add(seatReportTog);
		mainPanel.add(studyRoomTog);
		mainPanel.add(lockerTog);
		mainPanel.add(logoutBtn);
		mainPanel.add(mypageBtn);
		mypageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getContentPane(), "myPage");
			}
		});
		
		mainPanel.add(openDoorBtn);
		mainPanel.add(leaveBtn);
		mainPanel.add(buyBtn);
		
		/* 스윙 창 끄기(임시 버튼. 추후에 관리자 모드에서 만들 거임) */
		xBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		xBtn.setBounds(1850, 10, 50, 50);
		mainPanel.add(xBtn);

		/* 기본 설정 */
		mainPanel.setLayout(null);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckInFrame();
		//InstallmentPaymentDialog sc = new InstallmentPaymentDialog();
	}
}
