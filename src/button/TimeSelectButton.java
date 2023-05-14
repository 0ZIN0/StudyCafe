package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

import label.StartTimeLabel;

public class TimeSelectButton extends JButton {

	LocalTime time;

	public TimeSelectButton(JButton upBtn, JButton downBtn, StartTimeLabel startTimeLabel) {

		setBorderPainted(false);

		upBtn.setEnabled(false);
		downBtn.setEnabled(false);

		setBackground(new Color(0xD9D9D9));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				upBtn.setEnabled(true);
				downBtn.setEnabled(true);
				setBackground(new Color(0xFF5C01));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				String timeText = time.format(formatter);
				startTimeLabel.setText(timeText);
			}
		});

	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public LocalTime getTime() {
		return time;
	}
}
