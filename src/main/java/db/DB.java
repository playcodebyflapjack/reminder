package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class DB {
	private static DB db;
	private String dbHost;
	private int dbPort;
	private String dbUser;
	private String dbPass;
	private String dbName;

	private DB() {
		this.dbHost = System.getProperty("DB_HOST");
		this.dbPort = Integer.parseInt(System.getProperty("DB_PORT"));
		this.dbUser = System.getProperty("DB_USER");
		this.dbPass = System.getProperty("DB_PASS");
		this.dbName = System.getProperty("DB_NAME");
	}

	public static DB getInstance() {
		if (db == null) {
			db = new DB();
		}
		return db;
	}

	public Connection getConnection() throws SQLException, SQLTimeoutException {
		String configDB = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "," + dbUser + "," + dbPass;

		return DriverManager.getConnection(configDB);
	}

	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection(Connection con, ResultSet rs, PreparedStatement ps) {

		try 
		{
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}

			closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
