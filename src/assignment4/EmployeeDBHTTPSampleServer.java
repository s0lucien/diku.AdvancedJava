package assignment4;

import java.util.List;
import java.util.Map;

import org.eclipse.jetty.server.Server;

/**
 * EmployeeDBHTTPSampleServer is an example how EmployeeDB server could be created and started.
 * It serves client requests using Jetty HTTP server.
 * 
 * @author danil
 *
 */
public class EmployeeDBHTTPSampleServer {
	private static final String SERVER_CONFIG = "/absolute/path/to/clientdepartmentservermapping.xml";

	public static void main(String[] args) throws Exception {

		Map<String, List<Integer>> serverURLToDepartmentMap = Utility
				.getServerURLToDepartmentMapping(SERVER_CONFIG);
		// Pass the server-to-department mapping and port to create instance of the server
		Server myServer = EmployeeDBHTTPServerFactory.newInstance(serverURLToDepartmentMap, 8080);
		myServer.start();
		myServer.join();
	}
	
}
