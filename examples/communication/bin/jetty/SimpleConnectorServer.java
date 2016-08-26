package communication.bin.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class SimpleConnectorServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Server server = new Server(new QueuedThreadPool(20));
		
		ServerConnector httpConnector = new ServerConnector(server);
		httpConnector.setHost("127.0.0.1");
		httpConnector.setPort(8080);		
		httpConnector.setIdleTimeout(30000);
		
		server.addConnector(httpConnector);
		// or server.setConnectors(new Connector[] {httpConnector});
		// if you want to set several connectors an once.
		server.start();
		server.join();
	}

}
