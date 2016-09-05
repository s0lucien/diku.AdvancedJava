package derby;

public class SimpleDerbyDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	}
}
