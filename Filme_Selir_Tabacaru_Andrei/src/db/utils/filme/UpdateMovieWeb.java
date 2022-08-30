package db.utils.filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.utils.actor.ConnectionManager;
import db.utils.others.ProductionWeb;

public class UpdateMovieWeb {
	
	ConnectionManager cm = new ConnectionManager();
	int ok = 404;
	
	public UpdateMovieWeb(String titleToBeUpdated, String title, String releaseYear, String production, String runTime) {
		
		List<Movie> movies = new SelectMovieWeb().getAllMovies();
		
		ProductionWeb pWeb = new ProductionWeb();
		
		int newReleaseYear = 404;
		int newRunTime = 404;
		
		if( !(releaseYear.equals("")) )
			try {
				newReleaseYear = Integer.parseInt(releaseYear);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		if( !(runTime.equals("")) )
			try {
				newRunTime = Integer.parseInt(runTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		for( Movie m : movies ) {
			if( m.getTitle().toLowerCase().equals(titleToBeUpdated.toLowerCase()) ) {
				
				if( title.equals("") )
					title = m.getTitle();
				
				if( newReleaseYear == 404 )
					newReleaseYear = m.getReleaseYear();
				
				if( newRunTime == 404 )
					newRunTime = m.getRunTime();
				
				if( production.equals("") ) {
					pWeb = new ProductionWeb();
					production = pWeb.getProductionFromId(m.getIdProduction());
				} else {
					pWeb = new ProductionWeb(production);
					pWeb.createOrCheckIfNameExists();
				}
				
				pWeb = new ProductionWeb(production);
				
				Movie movieToBeUpdated = new Movie(title, newRunTime, newReleaseYear, pWeb.getIdProduction());
				
				updateMovie(movieToBeUpdated, titleToBeUpdated);
				
				break;
			}
		}
		
	}
	
	public void updateMovie(Movie m, String titleToBeUpdated) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = cm.getConnection();
			
			String sqlCommand = "UPDATE film SET titlu = ?, durata = ?, anAparitie = ?, idCasaDeProductie = ? WHERE LOWER(titlu) = ?;";
			
			stmt = conn.prepareStatement(sqlCommand);
			
			stmt.setString(1, m.getTitle());
			stmt.setInt(2, m.getRunTime());
			stmt.setInt(3, m.getReleaseYear());
			stmt.setInt(4, m.getIdProduction());
			stmt.setString(5, titleToBeUpdated.toLowerCase());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
		
	}
	
}
