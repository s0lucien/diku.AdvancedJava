/**
 * 
 */
package communication.jetty;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.eclipse.jetty.client.HttpClient;

import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bonii
 * 
 */
public class SimpleXStreamDemo {
	private static HttpClient client;

	public static void startClient() throws Exception {
		client = new HttpClient();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//startClient();
		
		XStream xmlStream = new XStream(new StaxDriver());
		
		Person per = new Person(1, "John");
		
		String xmlString = xmlStream.toXML(per);
		
		System.out.println(xmlString);
		
		Person newper = (Person) xmlStream.fromXML(xmlString);
		
//		System.out.println(per);
//		System.out.println(per.equals(newper));
//		System.out.println(per == newper);
//		
		Person per1 = new Person(10, "Perry");
		List<Person> persons = new ArrayList<Person>();
		persons.add(per);
		persons.add(per1);

		xmlString = xmlStream.toXML(persons);
		
		System.out.println(xmlString);
		// Pretty-printed XML
		BufferedOutputStream ppOut = new BufferedOutputStream(System.out);
		xmlStream.marshal(persons, new PrettyPrintWriter(new OutputStreamWriter(ppOut))); 
//		
//		List<Person> newpersons = (List<Person>) xmlStream.fromXML(xmlString);
//		System.out.println(newpersons);
//		assert(persons.equals(newpersons));
		
		
//		ContentExchange exchange = new ContentExchange();
//		exchange.setMethod("POST");
//		exchange.setURL("http://localhost:8080/persons");
//		Buffer buffer = new ByteArrayBuffer(xmlString);
//		exchange.setRequestContent(buffer);
//		client.send(exchange);
//		int exchangeState = exchange.waitForDone();
//		
//		List<String> emails1 = new ArrayList<String>();
//		emails1.add("tom@gmail.com");
//		emails1.add("tom@yahoo.com");
//		ExtendedPerson exper1 = new ExtendedPerson(12, "Tom", emails1);
//		List<String> emails2 = new ArrayList<String>();
//		emails2.add("ben@gmail.com");
//		emails2.add("ben@yahoo.com");
//		ExtendedPerson exper2 = new ExtendedPerson(15, "Ben", emails2);
//		List<ExtendedPerson> expers = new ArrayList<ExtendedPerson>();
//		expers.add(exper1);
//		expers.add(exper2);
//		xmlString = xmlStream.toXML(expers);
//		System.out.println(xmlString);
//		
//		List<ExtendedPerson> newexpers = (List<ExtendedPerson>) xmlStream.fromXML(xmlString);
//		System.out.println(newexpers);
//		assert(expers.equals(newexpers));
//		
//		exchange = new ContentExchange();
//		exchange.setMethod("POST");
//		exchange.setURL("http://localhost:8080/extpersons");
//		buffer = new ByteArrayBuffer(xmlString);
//		exchange.setRequestContent(buffer);
//		client.send(exchange);
//		exchangeState = exchange.waitForDone();
//		
//		client.stop();
	}

}
