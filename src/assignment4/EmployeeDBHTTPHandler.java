package assignment4;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * EmployeeDBHTTPHandler is invoked when an HTTP request is received by the
 * EmployeeDBHTTPServer
 * 
 * @author bonii
 * 
 */
public class EmployeeDBHTTPHandler extends AbstractHandler {
	private SimpleEmployeeDB db = null;
	XStream xmlStream;

	public EmployeeDBHTTPHandler(SimpleEmployeeDB db) {
		this.db = db;
		xmlStream = new XStream(new StaxDriver());
	}

	/**
	 * Although this method is thread-safe, what it invokes is not thread-safe
	 */
	public void handle(String target, Request baseRequest,
			HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String uri = req.getRequestURI().trim().toUpperCase();
		// Add more URIs to perform corresponding actions on the database
		if (uri.equalsIgnoreCase("/addemployee")) {
			// Retrieve the employee record from req using serialization/deserialization library
			// and invoke methods on SimpleEmployeeDB instance
			String content = getContent(req);
			Employee employee = (Employee) xmlStream.fromXML(content);
			res.setContentType("text/html;charset=utf-8");
			try {
				db.addEmployee(employee);
				res.setStatus(HttpServletResponse.SC_OK);
				res.getWriter().println("Successfully added an employee");
				baseRequest.setHandled(true);
			} catch (DepartmentNotFoundException e) {
				res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				res.getWriter().println("Error while adding employee: " + e);
			}

		} else if (uri.equalsIgnoreCase("/listemployeesindept")) {
			String content = getContent(req);
			List<Integer> departments = (List<Integer>) xmlStream.fromXML(content);
			res.setContentType("text/html;charset=utf-8");
			try {
				List<Employee> result = db.listEmployeesInDept(departments);
				res.setStatus(HttpServletResponse.SC_OK);
				res.getWriter().println(xmlStream.toXML(result));
				baseRequest.setHandled(true);
			} catch (DepartmentNotFoundException e) {
				res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				res.getWriter().println("Error while fetching employees: " + e);
			}

		} else if (uri.equalsIgnoreCase("/incrementsalaryofdepartment")) {
			String content = getContent(req);
			List<SalaryIncrement> salaryIncrements = (List<SalaryIncrement>) xmlStream.fromXML(content);
			res.setContentType("text/html;charset=utf-8");
			try {
				db.incrementSalaryOfDepartment(salaryIncrements);
				res.setStatus(HttpServletResponse.SC_OK);
				res.getWriter().println("Successfully increased salaries");
				baseRequest.setHandled(true);
			} catch (NegativeSalaryIncrementException | DepartmentNotFoundException e) {
				res.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				res.getWriter().println("Error while incrementing salaries: " + e);
			}
		} else if (uri.equalsIgnoreCase("/cleanupdb")) {
			db.cleanupDB();
			res.setContentType("text/html;charset=utf-8");
			res.setStatus(HttpServletResponse.SC_OK);
			res.getWriter().println("Successfully cleaned up DB");
			baseRequest.setHandled(true);
		}
	}

	private String getContent(HttpServletRequest req) throws IOException {
		int len = req.getContentLength();
		BufferedReader reqReader = req.getReader();
		char[] cbuf = new char[len];
		reqReader.read(cbuf);
		reqReader.close();
		return new String(cbuf);
	}

}
