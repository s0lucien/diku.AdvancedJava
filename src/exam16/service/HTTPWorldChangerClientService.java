package exam16.service;

import java.util.Set;

import exam16.model.EntityType;
import exam16.model.NotFoundException;
import org.eclipse.jetty.client.HttpClient;

import com.esotericsoftware.kryo.Kryo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import exam16.interfaces.WorldViewChanger;
import exam16.model.ImmutablePokemonWorldEntity;
import exam16.model.IntegerLocation2D;
import exam16.model.InvalidLocationException;

public class HTTPWorldChangerClientService implements WorldViewChanger {
    private final String serverUrl;
    private final HttpClient jettyClient = new HttpClient();
    // You can choose which serialization library to use.
    private final XStream xStream = new XStream(new StaxDriver());
    // Because Kryo implementation is not thread safe
    // it's wrapped in ThreadLocal. In your code just use Kryo kryo = kryos.get();
    // to obtain an instance
    private static final ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>() {
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            return kryo;
        };
    };

	public HTTPWorldChangerClientService(String serverUrl) throws Exception {
		this.serverUrl = serverUrl;
		this.jettyClient.start();
	}

	@Override
	public Set<ImmutablePokemonWorldEntity> getNearbyEntities(IntegerLocation2D worldLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createEntity(IntegerLocation2D spawnLocation, EntityType typeOfEntity)
			throws InvalidLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroyEntities(Set<Integer> entityIds) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}
}
