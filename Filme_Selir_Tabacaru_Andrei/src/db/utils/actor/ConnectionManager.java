package db.utils.actor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private String user = "root";
	private String password = "";
	private String serverName = "localhost";
	private int portNumber = 3306;
	private String dbName = "filme";
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		Properties connectionProps = new Properties();
		
		connectionProps.put("user", this.user);
		connectionProps.put("password", this.password);
		
		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);
		
		System.out.println("Connected to database");
		
		return conn;
		
	}
	
	public void closeResultSet(ResultSet rs) {
		
		try {
			if( rs != null )
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeStatement(PreparedStatement stmt) {
		
		try {
			if( stmt != null )
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection(Connection conn) {
		
		try {
			if( conn != null )
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
		
		closeResultSet(rs);
		
		closeStatement(stmt);
		
		closeConnection(conn);
		
	}
	
	public void closeAll(Connection conn, PreparedStatement stmt) {
		
		closeAll(conn, stmt, null);
		
	}
	
}
