/**
 * 
 */
package communication.bin.jetty;

import org.eclipse.jetty.server.*;


/**
 * @author bonii
 *
 */
public class SimpleServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		//server.setHandler(new SimpleHandler());
		//server.setHandler(new CounterHandler());
		server.setHandler(new SimplePostHandler());
		server.start();
		server.join();
	}

}
