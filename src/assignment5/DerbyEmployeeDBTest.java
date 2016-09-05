package assignment5;

import org.junit.BeforeClass;
import org.junit.AfterClass;

public class DerbyEmployeeDBTest {
	private static EmployeeDB employeeDB = null;

	/**
	 * The method runs just once before the test cases run. If you want to
	 * change the behavior look at @Before and other annotations in JUnit
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws InstantiationException {
		//employeeDB = new DerbyEmployeeDB();
		//assert (employeeDB != null);
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
