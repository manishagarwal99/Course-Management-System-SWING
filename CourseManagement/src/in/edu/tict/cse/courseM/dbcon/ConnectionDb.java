package in.edu.tict.cse.courseM.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * To store the connection credentials to the course_management database and
 * create a connection to it with user "root" and password "pass1234".
 */
public class ConnectionDb {

	/**
	 * The credentials for connecting to the database.
	 */
	private final static String DB_URL = "jdbc:mysql://localhost:3306/course_management";
	private final static String DB_NAME = "root";
	private final static String DB_PASSWORD = "system";
	private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	/**
	 * To set the driver for database connection.
	 *
	 * @exception ClassNotFoundException when the requested class is not found.
	 *
	 */
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To make a connection to the database.
	 * 
	 * @return Connection object.
	 * 
	 * @exception SQLException if the request for the connection to database could
	 *                         not be handled.
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
	}

}
