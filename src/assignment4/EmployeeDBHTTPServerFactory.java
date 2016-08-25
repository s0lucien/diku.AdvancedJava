package assignment4;

import org.eclipse.jetty.server.Server;
import java.util.List;
import java.util.Map;

/**
 * EmployeeDBHTTPServerFactory is a static factory for creating
 * configured server instances
 * 
 * @author danil
 * 
 */
public class EmployeeDBHTTPServerFactory {
	public static Server newInstance(Map<String, List<Integer>> mapping, int port) {
		Server myServer = new Server(port);
		SimpleEmployeeDB db = new SimpleEmployeeDB(
				mapping.get("http://localhost:"+ port + "/"));
		
		// This handler will handle all incoming HTTP requests
		EmployeeDBHTTPHandler handler = new EmployeeDBHTTPHandler(db); 
		myServer.setHandler(handler);
		return myServer;
	}
}
