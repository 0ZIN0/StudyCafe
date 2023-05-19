package thread;

import dao.MemberDAO;
import dto.Member;
import frame.CheckInFrame;
import panel.MyPagePanel;

public class UpdateInfo implements Runnable {
	
	Member member = CheckInFrame.member;
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(60000);
				System.out.println("member update");
				int minute = member.getRemain_time() - 1;
				member.setRemain_time(minute);
				MyPagePanel.time.setText(String.format("%d분", minute));
			} catch (Exception e) {
			}
		}	
	}
}
