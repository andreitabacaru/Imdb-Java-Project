package db.utils.others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jasypt.util.password.BasicPasswordEncryptor;

import db.utils.actor.ConnectionManager;

public class LoginWeb {
	
	ConnectionManager cm = new ConnectionManager();
	private String username;
	private String password;
	
	public LoginWeb(String user, String pass) {
		
		setUsername(user);
		setPassword(pass);
		
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isCorrect() { 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String corrPass = "";
		
		try {
			
			conn = cm.getConnection();
			
			String sqlCommand = "SELECT password FROM cont WHERE username = ?;";
			
			stmt = conn.prepareStatement(sqlCommand);
			stmt.setString(1, getUsername());
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				corrPass = rs.getString("password");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt, rs);
		}
		
		if( corrPass != "" ) {
			BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
			if (passwordEncryptor.checkPassword(password, corrPass)) {
				return true;
			} else {	
				return false;
				}
		}
		else
			return false;
		
	}
	
	public void createAdmin() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = cm.getConnection();
			
			String sqlCommand = "INSERT INTO cont VALUES (?, ?);";
			
			stmt = conn.prepareStatement(sqlCommand);
			
			BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
			
			stmt.setString(1, getUsername());
			stmt.setString(2, encryptedPassword);
			
			stmt.executeUpdate();
			
			System.out.println("Created a new Admin! Username: " + getUsername());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
		
	}
	
}
