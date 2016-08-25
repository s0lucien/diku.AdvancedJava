package assignment4;

import org.junit.BeforeClass;
import org.junit.AfterClass;

/**
 * Generated JUnit test class to test the EmployeeDB interface. It can be used
 * to test both the client and the server implementation.
 * 
 * @author bonii
 * 
 */
public class EmployeeDBTest {
	private static EmployeeDB employeeDB = null;
	
	// use path to configuration for HTTP client tests
	// private static final String CLIENT_CONFIG = "/absolute/path/to/clientdepartmentservermapping.xml";
	// private static final String SERVER_CONFIG = "/absolute/path/to/serverdepartmentservermapping.xml";
	
	/**
	 * The method runs just once before the test cases run. If you want to
	 * change the behavior look at @Before and other annotations in JUnit
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Use Utility class to get appropriate map for database/server 
		// initialization.
		
		// employeeDB = new SimpleEmployeeDB(); By setting the employeeDB
		// to either the server implementation first, you can write the server
		// implementation and test it. You don't even have to run the Jetty
		// HTTP server, you can just implement SimpleEmployeeDB and test it
		//
		// employeeDB = new EmployeeDBHTTPClient(); Once you have written the
		// client you can test the full system for the same test cases and it
		// should work, welcome to Unit testing :-)
		
		// Initialize servers here to test HTTP client (see EmployeeDBHTTPSampleServer).
	}

	/**
	 * This method is run just once after the test cases finish to cleanup. If
	 * you want to change the behavior look at @After and other annotations in
	 * JUnit
	 */
	@AfterClass
	public static void tearDownAfterClass() {

	}
}
