package challenge;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuoteDao {
	
	public Quote getQuote() throws SQLException {
		String query = "SELECT actor, detail FROM scripts " + "WHERE actor IS NOT NULL " + "ORDER BY RANDOM() LIMIT 1";
		Quote quote = null;
		Connection connection = null;

		try {
			connection = ConnectionFactory.createConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				quote = new Quote(rs.getString("actor"), rs.getString("detail"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return quote;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
		String query = "SELECT actor, detail FROM scripts " + "WHERE actor = '" + actor + "' " + "ORDER BY RANDOM() LIMIT 1";
		Quote quote = null;
		Connection connection = null;
		try {
			connection = ConnectionFactory.createConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				quote = new Quote(rs.getString("actor"), rs.getString("detail"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
		return quote;
	}
}