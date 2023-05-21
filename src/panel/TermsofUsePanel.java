package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TermsofUsePanel extends JPanel{
	
	ImageIcon im =new ImageIcon("ui/main/Main_UserInfoCheck_Frame.jpg");
	Image image=im.getImage();
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	};
	
	
	JPanel checkBox = new JPanel();
	JCheckBox a1 = new JCheckBox();
	JCheckBox a2 = new JCheckBox();
	JCheckBox a3 = new JCheckBox();
	
	
	
	public TermsofUsePanel() {
		setLayout(null);
		add(checkBox);
		checkBox.setBounds(0,0,830,430);
		checkBox.setBackground(new Color(0,0,0,0));
		checkBox.add(a1);
		a1.setBounds(300,100,0,0);
		checkBox.add(a2);
		checkBox.add(a3);
		
	}
	
}
