package db.utils.filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.utils.actor.ConnectionManager;
import db.utils.others.ProductionWeb;

public class SelectMovieWeb {
	
	ConnectionManager cm = new ConnectionManager();
	
	List<Movie> selectedMovies = new ArrayList<Movie>();
	List<Movie> allMovies = new ArrayList<Movie>();
	
	public SelectMovieWeb() {
		
	}
	
	public SelectMovieWeb(String title, String releaseYear, String production) {
		
		allMovies = getAllMovies();
		ProductionWeb pWeb = new ProductionWeb();
		
		int release = 404;
		int idProduction = 404;
		
		if( production != "" ) {
			ProductionWeb pw = new ProductionWeb(production);
			idProduction = pw.getIdProduction();
		}
		
		try {
			release = Integer.parseInt(releaseYear);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if( title != "" && releaseYear != "" && production != "" )
			for( Movie a : allMovies ) {
				if( a.getTitle().toLowerCase().equals(title.toLowerCase()) && release == a.getReleaseYear() && a.getIdProduction() == idProduction ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else if( title != "" && releaseYear != "" )
			for( Movie a : allMovies ) {
				if( a.getTitle().toLowerCase().equals(title.toLowerCase()) && release == a.getReleaseYear() ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else if( title != "" && production != "" )
			for( Movie a : allMovies ) {
				if( a.getTitle().toLowerCase().equals(title.toLowerCase()) && a.getIdProduction() == idProduction ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else if( releaseYear != "" && production != "" )
			for( Movie a : allMovies ) {
				if( release == a.getReleaseYear() && a.getIdProduction() == idProduction ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else if( title != "" )
			for( Movie a : allMovies ) {
				if( a.getTitle().toLowerCase().equals(title.toLowerCase()) ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else if( releaseYear != "" )
			for( Movie a : allMovies ) {
				if( release == a.getReleaseYear() ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else if( production != "" )
			for( Movie a : allMovies ) {
				if( a.getIdProduction() == idProduction ) {
					a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
					selectedMovies.add(a);
				}
			}
		else
			for( Movie a : allMovies ) {
				a.setProductionName(pWeb.getProductionFromId(a.getIdProduction()));
				selectedMovies.add(a);
			}
	}
	
	public List<Movie> getAllMovies() {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = cm.getConnection();
			
			String sqlCommand = "SELECT titlu, durata, anAparitie, idCasaDeProductie FROM film;";
			
			stmt = conn.prepareStatement(sqlCommand);
			
			rs = stmt.executeQuery();
			
			while( rs.next() ) {
				
				Movie movieToBeAdded = new Movie(rs.getString("titlu"), rs.getInt("durata"), rs.getInt("anAparitie"), rs.getInt("idCasaDeProductie"));
				
				movies.add(movieToBeAdded);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt, rs);
		}
		
		return movies;
		
	}
	
	public List<Movie> getSelectedMovies() {
		
		return selectedMovies;
		
	}
	
}
