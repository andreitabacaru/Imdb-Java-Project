package db.utils.filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.utils.actor.ConnectionManager;

public class DeleteMovieWeb {
	
	ConnectionManager cm = new ConnectionManager();
	
	public DeleteMovieWeb(String title) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = cm.getConnection();
			
			String sqlCommand = "DELETE FROM film WHERE titlu = LOWER(?);";
			
			stmt = conn.prepareStatement(sqlCommand);
			stmt.setString(1, title.toLowerCase());
			stmt.executeUpdate();
			
			System.out.println("Deleted successfully from Movie");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
		
	}
	
}
