package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class ExtendedJDBCDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager
					.getConnection("jdbc:derby:memory:example;create=true");
			
			if(conn == null) {
				System.out.println("Error getting connection");
				return;
			}
			
			conn.setAutoCommit(false);
			
			
			createTable(conn);
			createTableData(conn);
			createMoreTableData(conn);
			stmt = conn.createStatement();
			rs = readData(conn, stmt);
			while(rs.next()) {
				System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
				System.out.println(rs.getString("name") + " - " + rs.getString("email") + " - " + rs.getString("cpr"));
			}
			conn.commit();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			stmt.close();
			rs.close();
			conn.close();
		}
	}
	
	public static void createTable(Connection conn) throws SQLException {
		String createTableString = "CREATE TABLE ADVANCED_JAVA ( NAME VARCHAR(32) NOT NULL, EMAIL VARCHAR(20) NOT NULL, CPR VARCHAR(15) NOT NULL, PRIMARY KEY(CPR))";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			if(stmt == null) {
				System.out.println("Error creating statement");
				return;
			}
			stmt.executeUpdate(createTableString);
			//conn.rollback();
			//conn.commit();
		} catch(Throwable t) {
			t.printStackTrace();
		} finally {
			stmt.close();
		}
	}

	public static void createTableData(Connection conn) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			if(stmt == null) {
				System.out.println("Error creating statement");
				return;
			}
			conn.commit();
			stmt.executeUpdate("INSERT INTO ADVANCED_JAVA VALUES ('Bob', 'bob@bob.com','121087-3456')");
			//stmt.executeUpdate("INSERT INTO ADVANCED_JAVA VALUES ('Bob', 'bob@bob.com','121087-3456')");
			Savepoint s1 = conn.setSavepoint();
			stmt.executeUpdate("INSERT INTO ADVANCED_JAVA VALUES ('Joe', 'joe@bob.com','130987-1234')");
			Savepoint s2 = conn.setSavepoint();
			stmt.executeUpdate("INSERT INTO ADVANCED_JAVA VALUES ('Ryan', 'ryan@ryan.com','100288-0007')");
			//conn.rollback(s1);
			conn.rollback(s2);
			conn.releaseSavepoint(s1);
			//conn.commit();
		} catch(Throwable t) {
			t.printStackTrace();
		} finally {
			stmt.close();
		}
	}
	
	public static void createMoreTableData(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO ADVANCED_JAVA VALUES (?, ?,?)");
			if(ps == null) {
				System.out.println("Error creating prepared statement");
				return;
			}
			
			ps.setString(1, "Tim");
			ps.setString(2, "tim@tim.com");
			ps.setString(3, "090889-2468");
			ps.executeUpdate();
			
			ps.setString(1, "Rita");
			ps.setString(2, "rita@rita.com");
			ps.setString(3, "011187-9056");
			ps.executeUpdate();
			//conn.commit();
			
		} catch(Throwable t) {
			t.printStackTrace();
		} finally {
			ps.close();
		}
	}
	
	public static ResultSet readData(Connection conn, Statement stmt) throws SQLException {
		ResultSet rs = null;
		try {
			if(stmt == null) {
				System.out.println("Error creating statement");
				return null;
			}
			rs = stmt.executeQuery("SELECT * FROM ADVANCED_JAVA");
			//conn.commit();
		} catch(Throwable t) {
			t.printStackTrace();
		} 
		return rs;
	}
	

}
