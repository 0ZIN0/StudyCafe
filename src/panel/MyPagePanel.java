package panel;

import java.awt.Color;

import javax.swing.JPanel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPagePanel extends JPanel {
//	
//	// 패널 불러오기
//	InformationViewPanel infoPanel = new InformationViewPanel();
//	TicketViewPanel ticketPanel = new TicketViewPanel();
//	MileageViewPanel mileagePanel = new MileageViewPanel();
//	ModifyInfoDialog modifyInfo = new ModifyInfoDialog();
//	
//	private final ButtonGroup buttonGroup = new ButtonGroup();
//	
//	private BufferedImage image;
//	
//	CardLayout card = new CardLayout();
//	
//	/**
//	 * Create the panel.
//	 */
//	public MyPagePanel() {
//		
//		// 이미지 읽어 오기
//		try {
//            image = ImageIO.read(new File("ui/background.png"));
//        } catch (IOException ex) {
//        }
//		
//		// 패널 설정
//		setBounds(0, 0, 1920, 1080);
//		setBackground(new Color(73, 67, 68));
//		setLayout(null);
//		infoPanel.getModifyInfo(modifyInfo);
//		
//		modifyInfo.setVisible(false);
//		modifyInfo.setLocation(479, 312);
//		add(modifyInfo);
//		
//		// 카드 레이아웃을 사용할 기본 패널 만들기
//		JPanel initPanel = new JPanel();
//		initPanel.setBackground(new Color(63, 58, 60));
//		initPanel.setBounds(700, 350, 908, 613);
//		initPanel.setLayout(card);
//		add(initPanel);
//		
//		// 기본 패널에 각 기능의 패널 붙이기
//		initPanel.add(infoPanel, "info");
//		initPanel.add(ticketPanel, "ticket");
//		initPanel.add(mileagePanel, "mileage");
//		
//		
//		// 닫기 버튼
//		JButton btnNewButton = new JButton("닫기");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//					System.exit(0);
//			}
//		});
//		btnNewButton.setBounds(1774, 10, 117, 112);
//		add(btnNewButton);
//		
//		// 토글 버튼
//		//정보 보기 버튼
//		JToggleButton informationViewBtn = new JToggleButton("정보 보기");
//		informationViewBtn.setForeground(new Color(255, 255, 255));
//		informationViewBtn.setBounds(300, 350, 226, 145);
//		informationViewBtn.setSelected(true);
//		informationViewBtn.setContentAreaFilled(false);
//		informationViewBtn.setBorderPainted(false);
//		add(informationViewBtn);
//		informationViewBtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// 버튼을 누르면 정보 보기 패널 뜸
//				card.show(initPanel, "info");
//			}
//		});
//		informationViewBtn.setFont(new Font("맑은 고딕", Font.BOLD, 42));
//		buttonGroup.add(informationViewBtn);
//		
//		// 이용권 버튼
//		JToggleButton ticketViewBtn = new JToggleButton("이용권");
//		ticketViewBtn.setBounds(300, 580, 226, 145);
//		add(ticketViewBtn);
//		ticketViewBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// 버튼을 누르면 이용권 보기 패널 뜸
//				card.show(initPanel, "ticket");
//			}
//		});
//		ticketViewBtn.setFont(new Font("맑은 고딕", Font.BOLD, 32));
//		buttonGroup.add(ticketViewBtn);
//		
//		// 마일리지 버튼
//		JToggleButton mileageViewBtn = new JToggleButton("마일리지");
//		mileageViewBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// 버튼을 누르면 마일리지 보기 패널 뜸
//				card.show(initPanel, "mileage");
//			}
//		});
//		mileageViewBtn.setBounds(300, 810, 226, 145);
//		mileageViewBtn.setFont(new Font("맑은 고딕", Font.BOLD, 32));
//		add(mileageViewBtn);
//		buttonGroup.add(mileageViewBtn);
//		
//		// 라벨로 만든 로그아웃 버튼
//		JLabel rogOutLabel = new JLabel("로그아웃");
//		rogOutLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// 클릭하면 로그아웃
//				System.exit(0);
//			}
//		});
//		rogOutLabel.setForeground(new Color(255, 255, 255));
//		rogOutLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
//		rogOutLabel.setBounds(110, 201, 129, 64);
//		add(rogOutLabel);
//		
//		// 라벨로 만든 좌석 보기 버튼
//		JLabel seatViewLabel = new JLabel("좌석 보기");
//		seatViewLabel.setForeground(Color.WHITE);
//		seatViewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
//		seatViewLabel.setBounds(1672, 201, 144, 64);
//		add(seatViewLabel);
//
//	}
//	
//	 protected void paintComponent(Graphics g) {
//		 super.paintComponent(g);
//		 g.drawImage(image, 0, 0, this);
//	 }
}
