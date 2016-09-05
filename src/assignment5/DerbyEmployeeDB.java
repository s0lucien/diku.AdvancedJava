package assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * An implementation of EmployeeDB interface which uses the Derby database
 * engine for the back-end database
 * 
 * @author bonii
 * 
 */
public class DerbyEmployeeDB implements EmployeeDB {
	private Connection conn = null;
	private final String databaseName = "employeeDB";
	private final String derbyDriver = "org.apache.derby.jdbc.EmbeddedDriver";
	private final String databaseURL = "jdbc:derby:" + databaseName
			+ ";create=true";

	/**
	 * If the database does not exist, it creates a database else it creates a
	 * connection to the existing database. This does not mean it creates the
	 * tables as well.
	 * 
	 * @throws InstantiationException
	 */
	public DerbyEmployeeDB(List<Integer> departmentIds) throws InstantiationException {

		try {
			// Load the Derby database engine
			Class.forName(derbyDriver);
		} catch (ClassNotFoundException ex) {
			throw new InstantiationException(
					"Error loading Derby Database engine");
		}
		try {
			// Get a connection to the database and also creates the
			// database if it
			// does not exist
			conn = DriverManager.getConnection(databaseURL);

			// This should not happen, the API should throw exception,
			// guarding just in case
			if (conn == null) {
				throw new InstantiationException(
						"Got a null connection!!Weird case!");
			}
		} catch (SQLException ex) {
			throw new InstantiationException(ex.getMessage());
		}
	}

	@Override
	public void addEmployee(Employee emp) throws DepartmentNotFoundException, AccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> listEmployeesInDept(List<Integer> departmentIds)
			throws DepartmentNotFoundException, AccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incrementSalaryOfDepartment(List<SalaryIncrement> salaryIncrement)
			throws DepartmentNotFoundException, NegativeSalaryIncrementException, AccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanupDB() throws AccessException {
		// TODO Auto-generated method stub
		
	}

}
