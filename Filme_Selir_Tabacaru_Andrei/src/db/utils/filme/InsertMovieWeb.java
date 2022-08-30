package db.utils.filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.utils.actor.ConnectionManager;
import db.utils.others.ProductionWeb;

public class InsertMovieWeb {
	
	ConnectionManager cm = new ConnectionManager();
	
	public InsertMovieWeb(String movieTitle, String runTimeMins, String releaseYear, String productionName) {
		
		ProductionWeb pw = new ProductionWeb(productionName);
		pw.createOrCheckIfNameExists();
		
		int runTime, yearOfRelease;
		
		try {
			 runTime = Integer.parseInt(runTimeMins);
		} catch (Exception e) {
			 runTime = 0;
			e.printStackTrace();
		}
		
		try {
			 yearOfRelease = Integer.parseInt(releaseYear);
		} catch (Exception e) {
			 yearOfRelease = 0;
			e.printStackTrace();
		}
		
		Movie movieToBeInserted = new Movie(movieTitle, runTime, yearOfRelease, pw.getIdProduction());
		
		insertMovie(movieToBeInserted);
		
	}
	
	
	public void insertMovie(Movie m) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = cm.getConnection();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			String sqlCommand = "INSERT INTO film(titlu, durata, anAparitie, idCasaDeProductie) VALUES ( ?, ?, ?, ? );";
			
			System.out.println(sqlCommand);
			
			stmt = conn.prepareStatement(sqlCommand);
			
			stmt.setString(1, m.getTitle());
			stmt.setInt(2, m.getRunTime());	
			stmt.setInt(3, m.getReleaseYear());
			stmt.setInt(4, m.getIdProduction());
			
			stmt.executeUpdate();
			
			System.out.println("Inserted successfully into Movie.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
	}
	
}
