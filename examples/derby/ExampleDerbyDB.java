package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExampleDerbyDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:derby:example;create=true");
			try {
				DriverManager.getConnection("jdbc:derby:example;shutdown=true");
			} catch (SQLException se) {
				if (se.getSQLState().equals("08006")) {
					System.out
							.println("Database example shutdown successfully");
				} else {
					System.out
							.println("Database example shutdown failed");
				}
			}
			DriverManager.getConnection("jdbc:derby:example;");
			try {
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			} catch (SQLException se) {
				if (se.getSQLState().equals("XJ015")) {
					System.out
							.println("All Databases shutdown successfully");
				} else {
					System.out
							.println("Database shutdown failed");
				}
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
