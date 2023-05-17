package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import panel.LoginMainPanel;

public class MemberDAO {
	void checkLogin() {
		String phon = userPhonNumber.getText();
		String pass = new String(userPassField.getPassword());
		
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM member WHERE phone_number=? AND member_password=?");
            stmt.setString(1, phon);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();	
            
			if (rs.next()) {
				JOptionPane.showMessageDialog(new LoginMainPanel().background, "@@로그인성공@@");
               System.out.println("로그인성공");
               
            } else {
            	JOptionPane.showMessageDialog(new LoginMainPanel().background, "로그인실패!!!");
                System.out.println("로그인 실패");
            }

            rs.close();
            stmt.close();
			
		} catch (SQLException  e2) {
			e2.printStackTrace();
		}
	}
	
	
	
}
