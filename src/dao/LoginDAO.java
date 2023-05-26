package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import dbConnection.OjdbcConnection;
import dialog.setPopup;
import frame.MainFrame;
import frame.MasterMenuFrame;

public class LoginDAO {
	
	MasterMenuFrame masterMenuFrame;
	
	public static boolean checkPhoneNum(String phoneNum, String password) {
		String query = "SELECT * FROM member WHERE phone_number=? AND member_password=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, phoneNum);
			pstmt.setString(2, password);
			try(
					ResultSet rs = pstmt.executeQuery();
					) {
				if (rs.next()) {
					MainFrame.member = MemberDAO.setMember(phoneNum);
					new MainFrame(MemberDAO.setMember(phoneNum));
					return true;
				} else {
					new setPopup(new ImageIcon("ui/main/loginPopup/passnot.png")).setVisible(true);
					return false;
				}
			}
		} catch (SQLException  e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkDup(String phoneNum) {
		String query = "SELECT * FROM member where phone_number = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, phoneNum);
			try(
					ResultSet rs = pstmt.executeQuery();
					) {
				if (rs.next()) {
             	   new setPopup(new ImageIcon("ui/main/memberjoinPopup/alreadyphonnum.png")).setVisible(true);
                   return false;
                }
			}
		} catch (SQLException  e2) {
			e2.printStackTrace();
		}
		return true;
	}
	
	public static int register(String phoneNum, String password) {
		String query = "INSERT INTO member VALUES ('M-' || member_id_seq.nextval,?, ?, 0 , null, null, null, null)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, phoneNum);
			pstmt.setString(2, password);
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException  e2) {
			e2.printStackTrace();
			
		}
		return 0;
	}
	
	// 관리자계정 확인
	public static boolean masterCheckPhoneNum(String phoneNum, String password) {
		
		String query = "SELECT * FROM master WHERE phone_number=? AND member_password=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
			pstmt.setString(1, phoneNum);
			pstmt.setString(2, password);
			try(
					ResultSet rs = pstmt.executeQuery();
					) {
				if (rs.next()) {
					//MainFrame.member = MemberDAO.setMember(phoneNum);
					new MasterMenuFrame();
					return true;
				} else {
					new setPopup(new ImageIcon("ui/main/loginPopup/passnot.png")).setVisible(true);
					return false;
				}
			}
		} catch (SQLException  e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	
}
