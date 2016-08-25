package assignment4;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Generated JUnit test class to test the EmployeeDB interface. It can be used
 * to test both the client and the server implementation.
 * 
 * @author bonii
 * 
 */
public class EmployeeDBTest {
	private static EmployeeDB db = null;
	private static EmployeeDBHTTPClient client = null;
	// use path to configuration for HTTP client tests
	private static final String SERVER_CONFIG = "/Users/martinmetaksov/IdeaProjects/diku.AdvancedJava.Assignment1/src/assignment4/serverdepartmentservermapping.xml";
	private static final String CLIENT_CONFIG = "/Users/martinmetaksov/IdeaProjects/diku.AdvancedJava.Assignment1/src/assignment4/clientdepartmentservermapping.xml";
	final static int SERVER_1_PORT = 8080;
	final static int SERVER_2_PORT = 8081;
	static List<Employee> employees;

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

		Map<String, List<Integer>> serverMap = Utility.getServerURLToDepartmentMapping(SERVER_CONFIG);
		Map<String, List<Integer>> clientMap = Utility.getServerURLToDepartmentMapping(CLIENT_CONFIG);

		// By setting the employeeDB
		// to either the server implementation first, you can write the server
		// implementation and test it. You don't even have to run the Jetty
		// HTTP server, you can just implement SimpleEmployeeDB and test it

		db = new SimpleEmployeeDB(
				serverMap.get("http://localhost:"+ SERVER_1_PORT + "/"));
		// Once you have written the
		// client you can test the full system for the same test cases and it
		// should work, welcome to Unit testing :-)

		// Initialize servers here to test HTTP client (see EmployeeDBHTTPSampleServer).
		Map<Integer, String> departmentToServerURLMap = Utility
				.getDepartmentToServerURLMapping(CLIENT_CONFIG);
		client  = new EmployeeDBHTTPClient(departmentToServerURLMap);

	}

	/**
	 * This method is run just once after the test cases finish to cleanup. If
	 * you want to change the behavior look at @After and other annotations in
	 * JUnit
	 */
	@AfterClass
	public static void tearDownAfterClass() {

	}

	@Before
	public void setUp() {
		generateTestEmployees();
	}

	@After
	public void tearDown() {
		try {
			db.cleanupDB();
		} catch (AccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEmployeesCanBeAdded() throws AccessException, DepartmentNotFoundException {
		addAllValidEmployees();
		assertEquals(2, db.listEmployeesInDept(Arrays.asList(1)).size());
		assertEquals(3, db.listEmployeesInDept(Arrays.asList(2)).size());
		assertEquals(3, db.listEmployeesInDept(Arrays.asList(3)).size());
	}

	@Test(expected = DepartmentNotFoundException.class)
	public void testEmployeeCannotBeAddedToWrongDepartmentId() throws AccessException, DepartmentNotFoundException {
		db.addEmployee(employees.get(8));
	}

	@Test
	public void testEmployeesCanGetSalaryIncrease() throws AccessException, DepartmentNotFoundException, NegativeSalaryIncrementException {
		addAllValidEmployees();
		db.incrementSalaryOfDepartment(Arrays.asList(new SalaryIncrement(1, 100.0f)));
		db.incrementSalaryOfDepartment(Arrays.asList(new SalaryIncrement(2, 50.0f)));
		db.incrementSalaryOfDepartment(Arrays.asList(new SalaryIncrement(3, 20.0f)));
		assertEquals(employees.get(7).getSalary(), findEmployeeById(7, db.listEmployeesInDept(Arrays.asList(1, 2, 3))).getSalary());
		assertEquals(employees.get(0).getSalary(), findEmployeeById(0, db.listEmployeesInDept(Arrays.asList(1, 2, 3))).getSalary());
		assertEquals(employees.get(4).getSalary(), findEmployeeById(4, db.listEmployeesInDept(Arrays.asList(1, 2, 3))).getSalary());
	}

	@Test(expected = NegativeSalaryIncrementException.class)
	public void testEmployeesCannotGetSalaryIncreasedByNegativeNumber() throws AccessException, DepartmentNotFoundException, NegativeSalaryIncrementException {
		addAllValidEmployees();
		db.incrementSalaryOfDepartment(Arrays.asList(new SalaryIncrement(1, -5f)));
	}

	@Test
	public void testClientAddEmployee() throws AccessException, DepartmentNotFoundException {
		client.addEmployee(employees.get(0));
		List<Employee> list = client.listEmployeesInDept(Arrays.asList(2));
		assertEquals(1, list.size());
	}

	@Test
	public void testClientSalaryIncrement() throws AccessException, DepartmentNotFoundException, NegativeSalaryIncrementException {
		addAllValidEmployees();
		client.incrementSalaryOfDepartment(Arrays.asList(new SalaryIncrement(1, 100.0f)));
		assertEquals(employees.get(7).getSalary(), findEmployeeById(7, db.listEmployeesInDept(Arrays.asList(1))).getSalary());
		client.cleanupDB();
	}

	private static void generateTestEmployees() {
		employees = new ArrayList<>();
		employees.add(new Employee(0, "First", 2, 5000f));
		employees.add(new Employee(1, "Second", 1, 250f));
		employees.add(new Employee(2, "Third", 3, 999f));
		employees.add(new Employee(3, "Fourth", 3, 3330f));
		employees.add(new Employee(4, "Fifth", 3, 2660f));
		employees.add(new Employee(5, "Sixth", 2, 8880f));
		employees.add(new Employee(6, "Seventh", 2, 7770f));
		employees.add(new Employee(7, "Eight", 1, 5400f));
		employees.add(new Employee(8, "Ninth", 4, 3500f)); // with no such existing departmentId
		employees.add(new Employee(9, "Tenth", 7, 7600f)); // another with no existing departmentId
	}


	private void addAllValidEmployees() throws DepartmentNotFoundException, AccessException {
		db.addEmployee(employees.get(0));
		db.addEmployee(employees.get(1));
		db.addEmployee(employees.get(2));
		db.addEmployee(employees.get(3));
		db.addEmployee(employees.get(4));
		db.addEmployee(employees.get(5));
		db.addEmployee(employees.get(6));
		db.addEmployee(employees.get(7));
	}

	private Employee findEmployeeById(int id, List<Employee> employees) {
		Employee result = null;
		for (Employee e: employees) {
			if (e.getId() == id)
				result = e;
		}
		return result;
	}
}
