package exam16.tests;

import org.junit.BeforeClass;

import exam16.service.HTTPHunterClientService;
import exam16.service.HTTPRejuvenatorClientService;
import exam16.service.HTTPWorldChangerClientService;

public class PokemonTest {
    private static final String SERVER = "http://localhost:8080";
    
    HTTPHunterClientService hunterClient;
    HTTPRejuvenatorClientService rejuvenatorClient;
    HTTPWorldChangerClientService worldChangerClient;
    
    @BeforeClass
    public void setUp() throws Exception {
        hunterClient = new HTTPHunterClientService(SERVER);
        rejuvenatorClient = new HTTPRejuvenatorClientService(SERVER);
        worldChangerClient = new HTTPWorldChangerClientService(SERVER);        
    }
    
    // TODO -> Write your tests here

}
