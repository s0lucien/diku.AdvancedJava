package assignment4;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

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
	private XStream xmlStream = null;
	private final static String[] routes = {
			"addemployee",
			"listemployeesindept",
			"incrementsalaryofdepartment",
			"cleanupdb",
	};

	public EmployeeDBHTTPClient(Map<Integer, String> mapping) throws Exception {
		departmentToServerURLMap = mapping;
		xmlStream = new XStream(new StaxDriver());
		// You need to initiate Jetty HttpClient here
		client = new HttpClient();
		client.setMaxConnectionsPerDestination(300);
		client.setExecutor(new QueuedThreadPool(20));
		client.setConnectTimeout(30000);
		client.start();
	}

	@Override
	public void addEmployee(Employee emp) throws DepartmentNotFoundException, AccessException {
		// Create request using Jetty HTTP client, serialize Employee instance and it 
		// to the appropriate server (according to the server-department mapping)
		Request req = client.POST(getServerURLForDepartment(emp.getDepartment()) + routes[0])
				.content(new StringContentProvider(xmlStream.toXML(emp)));
		try {
			ContentResponse resp = req.send();
			System.out.println(resp.getContentAsString());
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> listEmployeesInDept(List<Integer> departmentIds)
			throws DepartmentNotFoundException, AccessException {
		if (departmentIds.size() > 0) {
			Request req = client.POST(getServerURLForDepartment(departmentIds.get(0)) + routes[1])
					.content(new StringContentProvider(xmlStream.toXML(departmentIds)));
			try {
				ContentResponse resp = req.send();
				List<Employee> list = (List<Employee>) xmlStream.fromXML(resp.getContentAsString());
				return list;
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}

	@Override
	public void incrementSalaryOfDepartment(List<SalaryIncrement> salaryIncrement)
			throws DepartmentNotFoundException, NegativeSalaryIncrementException, AccessException {
		if (salaryIncrement.size() > 0) {
			Request req = client.POST(getServerURLForDepartment(salaryIncrement.get(0).getDepartment()) + routes[2])
					.content(new StringContentProvider(xmlStream.toXML(salaryIncrement)));
			try {
				ContentResponse resp = req.send();
				System.out.println(resp.getContentAsString());
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void cleanupDB() throws AccessException {
		try {
			for (int id: departmentToServerURLMap.keySet()) {
				Request req = client.POST(getServerURLForDepartment(id) + routes[3]);
				ContentResponse resp = req.send();
				System.out.println(resp.getContentAsString());
			}
		} catch (InterruptedException | ExecutionException | TimeoutException | DepartmentNotFoundException e) {
			e.printStackTrace();
		}
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

	public String getServerURLs() throws DepartmentNotFoundException {
//		return departmentToServerURLMap.values();
		System.out.println("");
		return null;
	}
}
