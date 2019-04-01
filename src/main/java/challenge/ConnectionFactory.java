package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/database.sqlite");
			return connection;
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return null;
	}
}