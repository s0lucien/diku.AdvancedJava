package communication.jetty;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

public class TrivialHTTPClient {
    private static HttpClient client;

    public static void startClient() throws Exception {
        client = new HttpClient();
        //client.setMaxConnectionsPerDestination(300);
        //client.setConnectTimeout(30000);
        //client.setExecutor(new QueuedThreadPool(20));
        client.start();
    }
    
    public static void main(String[] args) throws Exception {
        
        startClient();
        ContentResponse resp = 
        client.GET("http://www.google.com/finance/historical?q=AAPL&startdate=2016-01-01&enddate=2016-02-01&output=csv");
        System.out.println(resp.getContentAsString());
        client.stop();
               
    }
}
