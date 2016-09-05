package communication.jetty;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class SimpleKryoDemo {

    public static void main(String[] args) {
        Kryo kryo = new Kryo();
        Person pers = new Person(1, "John");
        System.out.println(pers);
        // ======== WRITE ==========
        OutputStream outStream = new ByteArrayOutputStream();        
        Output out = new Output(outStream);        
        kryo.writeObject(out, pers);        
        byte[] serializedPers = out.toBytes();
        out.close();
        
        System.out.println(Arrays.toString(serializedPers));
        
        // ========= READ ==========
        InputStream inStream = new ByteArrayInputStream(serializedPers);
        Input in = new Input(inStream);
        Person newPers = kryo.readObject(in, Person.class);

        System.out.println(newPers);
        assert(pers.equals(newPers));
    }
}
