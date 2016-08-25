package assignment4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * EmployeeDBHTTPHandler is invoked when an HTTP request is received by the
 * EmployeeDBHTTPServer
 * 
 * @author bonii
 * 
 */
public class EmployeeDBHTTPHandler extends AbstractHandler {
	private SimpleEmployeeDB db = null;

	public EmployeeDBHTTPHandler(SimpleEmployeeDB db) {
		this.db = db;
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
			// db.addEmployee(emp)
		}
	}

}
