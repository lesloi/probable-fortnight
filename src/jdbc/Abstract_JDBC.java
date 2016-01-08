package jdbc;

import java.sql.*;

abstract class Abstract_JDBC {

	// JDBC driver
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/clhyps";

	// Database authentification
	static final String USER = "root";
	static final String PASS = "skrull";

	// Object connection to the database
	static private Connection conn = null;

	/**
	 * Get Object connection to database
	 */
	static protected Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}
		} catch (Exception e) {
			System.err.println("Fail to connect to database");
			System.exit(-1);
		}

		return conn;
	}

	/**
	 * Close the connection
	 */
	public static void closeConnection() {
		if (conn == null)
			return;

		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			System.err.println("Fail to close connection to database");
		}
	}

}
