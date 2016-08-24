package subtyping.consumers;

import subtyping.Bamboo;

public class Panda implements Consumer<Bamboo> {

    @Override
    public void consume(Bamboo energy) {
        System.out.println("Eating " + energy.toString());
    }
    

}
