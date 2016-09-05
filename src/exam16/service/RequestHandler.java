package exam16.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.esotericsoftware.kryo.Kryo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import exam16.model.AWorldManager;

public class RequestHandler extends AbstractHandler {
    private final AWorldManager aWorldManager;
    // You can choose which serialization library to use.
    private final XStream xStream = new XStream(new StaxDriver());
    // Because Kryo implementation is not thread safe it's wrapped in ThreadLocal. 
    // In your code just use Kryo kryo = kryos.get() to obtain an instance
    private static final ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>() {
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            return kryo;
        };
    };

	public RequestHandler(AWorldManager s) {
		super();
		aWorldManager = s;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		// TODO: Handle requests and dispatch them to the game world manager.
		// Remember to propagate exceptions to the
		// client.
		throw new RuntimeException("Not implemented");
	}
}
