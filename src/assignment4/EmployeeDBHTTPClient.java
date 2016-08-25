package assignment4;

import java.util.List;
import java.util.Map;

import org.eclipse.jetty.client.HttpClient;

/**
 * EmployeeDBHTTPClient implements the client side methods of EmployeeDB
 * interface using HTTP protocol. The methods must send HTTP requests to the
 * EmployeeDBHTTPServer
 * 
 * @author bonii
 * 
 */
public class EmployeeDBHTTPClient implements EmployeeDBClient, EmployeeDB {
	private HttpClient client = null;
	private Map<Integer, String> departmentToServerURLMap = null;

	public EmployeeDBHTTPClient(Map<Integer, String> mapping) {
		departmentToServerURLMap = mapping;
		// You need to initiate Jetty HttpClient here
	}

	@Override
	public void addEmployee(Employee emp) throws DepartmentNotFoundException, AccessException {
		// Create request using Jetty HTTP client, serialize Employee instance and it 
		// to the appropriate server (according to the server-department mapping) 
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

	/**
	 * Returns the server URL (starting with http:// and ending with /) to
	 * contact for a department
	 */
	public String getServerURLForDepartment(int departmentId) throws DepartmentNotFoundException {
		if (!departmentToServerURLMap.containsKey(departmentId)) {
			throw new DepartmentNotFoundException("department " + departmentId + " does not exist in mapping");
		}
		return departmentToServerURLMap.get(departmentId);
	}
}
