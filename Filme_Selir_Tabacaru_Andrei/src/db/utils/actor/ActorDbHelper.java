package db.utils.actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.sql.Date;
import java.util.List;

public class ActorDbHelper {
	
	ConnectionManager cm = new ConnectionManager();
	
	public List<Actor> selectActors() throws ImdbExceptions {
		
		List<Actor> actori = new ArrayList<Actor>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Calendar dataNasterii = Calendar.getInstance();
		Date dataNasteriiDate = new Date(0);
		
		try {
			
			conn = cm.getConnection();
			
			String command = "SELECT idActor, nume, prenume, dataNasterii, sex FROM actor;";
			
			stmt = conn.prepareStatement(command);
			
			rs = stmt.executeQuery();
			
			while( rs.next() ) {
				
				dataNasterii.clear();
				
				dataNasteriiDate.setTime(rs.getDate("dataNasterii").getTime());
				
				int idActor = rs.getInt("idActor");
				String nume = rs.getString("nume");
				String prenume = rs.getString("prenume");
				
				dataNasterii.setTime(rs.getDate("dataNasterii"));
				String sex = rs.getString("sex");
				
				actori.add(new Actor(idActor, nume, prenume, dataNasteriiDate, sex));
			}
			
			Collections.sort(actori);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ImdbExceptions("Select failed.");
		} finally {
			cm.closeAll(conn, stmt, rs);
		}
		
		return actori;
		
	}
	
	@SuppressWarnings("deprecation")
	public void insertActor(Actor a) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = cm.getConnection();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			String sqlCommand = "INSERT INTO actor(nume, prenume, dataNasterii, sex) VALUES ( ?, ?, ?, ? );";
			
			System.out.println(sqlCommand);
			
			stmt = conn.prepareStatement(sqlCommand);
			
			stmt.setString(1, a.nume);
			stmt.setString(2, a.prenume);
			
			Date dataNasteriiDate = new Date(a.getDataNasteriiDate().getTime());
			
			stmt.setDate(3, dataNasteriiDate);
			stmt.setString(4, a.sex);
			
			stmt.executeUpdate();
			
			System.out.println("Inserted successfully into ACTOR");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
		
	}
	
	public void deleteActor(int idActor) {
		
		System.out.println("Trying to delete from ACTOR..");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = cm.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			String command = "DELETE FROM actor WHERE actor.idActor = ?;";
			
			stmt = conn.prepareStatement(command);
			
			stmt.setInt(1, idActor);
			
			stmt.executeUpdate();
			
			System.out.println("Deleted successfully from ACTOR");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
		
	}
	
	public void updateActor(int idActor, String nume, String prenume, Date dataNasterii, String sex) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = cm.getConnection();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			String sqlCommand = "UPDATE actor SET nume = ? , prenume = ? , dataNasterii = ? , sex = ? WHERE idActor = ?;";
			
			System.out.println(sqlCommand);
			
			stmt = conn.prepareStatement(sqlCommand);
			
			stmt.setString(1, nume);
			stmt.setString(2, prenume);
			stmt.setDate(3, dataNasterii);
			stmt.setString(4, sex);
			stmt.setInt(5, idActor);
			
			stmt.executeUpdate();
			
			System.out.println("Successfully updated ACTOR");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt);
		}
		
	}
	
}
