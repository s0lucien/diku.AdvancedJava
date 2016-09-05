package exam16.service;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import exam16.model.AWorldManager;

public class HTTPServerApplication
{
    private static AWorldManager worldManager = new AWorldManager();

    public static void main(String[] args) throws Exception
    {
        Server myServer = new Server(8080);
        RequestHandler handler = new RequestHandler(worldManager);
        myServer.setHandler(handler);
        myServer.start();
        System.out.println("Pokemon state server up and running on port " + ((ServerConnector)myServer.getConnectors()[0]).getPort());
        myServer.join();
    }
}


