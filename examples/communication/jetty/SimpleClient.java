package communication.jetty;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class SimpleClient {
    private static HttpClient client;

    public static void startClient() throws Exception {
        client = new HttpClient();
        //client.setMaxConnectionsPerDestination(300);
        //client.setConnectTimeout(30000);
        //client.setExecutor(new QueuedThreadPool(20));
        client.start();
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        try {
            startClient();
            sendGetRequest();
            sendPostRequest();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            client.stop();
        }

    }

    public static void sendGetRequest()
            throws InterruptedException, ExecutionException, TimeoutException {
        ContentResponse resp = client.GET("http://localhost:8080/foo?time=a&pan=b&time=b");
        System.out.println("Exchange completed");
        System.out.println(resp.getStatus());
        System.out.println(resp.getContentAsString());

    }

    public static void sendPostRequest()
            throws InterruptedException, TimeoutException, ExecutionException {
        Request req = client.POST("http://localhost:8080/foo?time=a&pan=b&time=b")
                .content(new StringContentProvider("Hello \n WWWorld"));
        ContentResponse resp = req.send();
        System.out.println("Exchange completed");
        System.out.println(resp.getStatus());
        System.out.println(resp.getContentAsString());
    }

}
