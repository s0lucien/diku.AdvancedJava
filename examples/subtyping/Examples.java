package subtyping;

import java.util.ArrayList;
import java.util.List;

import subtyping.consumers.Burner;
import subtyping.consumers.Consumer;
import subtyping.consumers.Panda;
import subtyping.consumers.PlantConsumer;

public class Examples {
    
    public static void main(String[] args) {
        
        // Consumer/Producer examples
        Consumer<EnergySource> burner = new Burner();
        Consumer<Plant> plantConsumer = new PlantConsumer();
        Consumer<Bamboo> panda = new Panda();
        
        Consumer<? super Plant> consumer = burner;
        //consumer.consume(new EnergySource());
        //consumer.consume(new Plant());
        consumer.consume(new Bamboo());
        
        List<? super Plant> lst = new ArrayList<>();
        lst.add(new Bamboo());
        Object p = lst.get(0);
        
        // List of Numbers
        List<? super Number> numLstSuper = new ArrayList<>();
        numLstSuper.add(new Integer(1));
        //numLst.add(new Double(2.1));
        
        List<? extends Number> numLstExtends = new ArrayList<>();
        //Number i = numLstExtends.get(0);
        // numLstExtends.add(new Integer(0)); // can add only null
        
        // Array subtyping 
        Integer[] intArray = new Integer[]{1,2};
        Number[] numArray = intArray;
        //numArray[0] = 0.1f; //throws java.lang.ArrayStoreException         
    }

}
