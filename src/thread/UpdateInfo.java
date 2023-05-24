package thread;

import java.util.List;

import button.LockerButton;
import color.MyColor;
import dao.LockerDAO;
import dao.MemberDAO;
import dao.SeatDAO;
import dao.SeatReservationDAO;
import dto.Member;
import dto.Seat_reservation;
import frame.MainFrame;
import label.RemainSeatLabel;
import panel.LockerPanel;
import panel.MyPagePanel;
import panel.SeatReportPanel;

public class UpdateInfo implements Runnable {
   
   
   SeatReservationDAO seat_res = new SeatReservationDAO();
   SeatDAO seat = new SeatDAO();
   @Override
   public void run() {
      while(true) {
         try {
            Thread.sleep(1000);
            System.out.println("update start");
            if(MainFrame.member != null && SeatReportPanel.seatBtns.size() == 32) {
               seat_res.autoLeaveSystem();
               seat.checkUse();
               seat_res.UsingSeats();
               System.out.println("update seat");
               LockerDAO.updateLockerInfo();
               System.out.println("update lockerInfo");
               setMyPage();
               System.out.println("update MyInfo");
               setLocker();
               System.out.println("update locker");
            }
            System.out.println("update complete");
         } catch (Exception e) {
         }
      }   
   }
   
   public static void setMyPage() {
      
      MemberDAO.updateRemainTime(MainFrame.member.getMember_id());
      if(MainFrame.member.getRemain_date() == null) {
         MyPagePanel.period.setText("");
      } else {   
         MyPagePanel.period.setText(MainFrame.member.getRemain_date() + "까지");
      }
      if(MainFrame.member.getLocker_number() == null) {
         MyPagePanel.locker.setText("이용중인 사물함이 없습니다");
      } else {
         MyPagePanel.locker.setText("L-" + MainFrame.member.getLocker_number() + "번");
      }
   }
   
   public static void setLocker() {
      int remain = LockerDAO.remainLocker();
      LockerPanel.remainLockerLabel.setText(String.format("%02d / %02d", remain, 20));
      
      List<String[]> isUse = LockerDAO.isUse();
      for(int i = 0; i < LockerPanel.lockerBtns.size(); i++) {
         if(isUse.get(i)[1] != null) {
            if(isUse.get(i)[1].equals(MainFrame.member.getMember_id())) {
               LockerPanel.lockerBtns.get(i).setBackground(MyColor.ORANGE);
               LockerPanel.lockerBtns.get(i).setEnabled(false);
            } else {
               LockerPanel.lockerBtns.get(i).setBackground(MyColor.GRAY);
               LockerPanel.lockerBtns.get(i).setEnabled(false);
            }
         } else {
            LockerPanel.lockerBtns.get(i).setBackground(MyColor.LIGHTGRAY);               
            if(MainFrame.member.getLocker_number() != null) {
               LockerPanel.lockerBtns.get(i).setEnabled(false);
            } else {
               LockerPanel.lockerBtns.get(i).setEnabled(true);
            }
         }         
      }
   }
}