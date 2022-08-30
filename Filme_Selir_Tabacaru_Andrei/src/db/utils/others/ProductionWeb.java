package db.utils.others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.utils.actor.ConnectionManager;

public class ProductionWeb {

	ConnectionManager cm = new ConnectionManager();
	
	private String name;
	
	public ProductionWeb( String productionName ) {
		
		this.setName(productionName);
		
	}
	
	public ProductionWeb() {
		
	}
	
	public List<String> getProductions() {
		
		List<String> productions = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = cm.getConnection();
			
			String sqlCommand = "SELECT nume FROM casa_de_productie;";
			
			stmt = conn.prepareStatement(sqlCommand);
			rs = stmt.executeQuery();
			
			while( rs.next() ) {
				
				String nume = rs.getString("nume");
				productions.add(nume);
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt, rs);
		}
		
		return productions;
	}
	
	public void createOrCheckIfNameExists() {
		
		List<String> productions = getProductions();
		boolean exists = false;
		
		for( String production : productions )
			if( name.toLowerCase().equals(production.toLowerCase()) ) {
				exists = true;
				System.out.println("The production exists!");
			}
		
		if( exists == false ) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
				conn = cm.getConnection();
				
				String sqlCommand = "INSERT INTO casa_de_productie(nume) VALUES (?); ";
				
				stmt = conn.prepareStatement(sqlCommand);
				stmt.setString(1, name);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cm.closeAll(conn, stmt);
			}
			
			System.out.println("Inserted new production.");
			
		}
		
	}

	public int getIdProduction() {
		
		int idProduction = -1;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = cm.getConnection();
			
			String sqlCommand = "SELECT idCasaDeProductie FROM casa_de_productie WHERE LOWER(nume) = ?;";
			
			stmt = conn.prepareStatement(sqlCommand);
			stmt.setString(1, getName().toLowerCase());
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				idProduction = rs.getInt("idCasaDeProductie");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt, rs);
		}
		
		return idProduction;
	}
	
	public String getProductionFromId(int idProd) {
		
		String productionName = "";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = cm.getConnection();
			
			String sqlCommand = "SELECT nume FROM casa_de_productie WHERE idCasaDeProductie = ?;";
			
			stmt = conn.prepareStatement(sqlCommand);
			stmt.setInt(1, idProd);
			
			rs = stmt.executeQuery();
			
			if( rs.next() )
				productionName = rs.getString("nume");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cm.closeAll(conn, stmt, rs);
		}
		
		return productionName;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
