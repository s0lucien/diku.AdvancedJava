package subtyping.consumers;

import subtyping.Plant;

public class PlantConsumer implements Consumer<Plant> {

    @Override
    public void consume(Plant energy) {
        System.out.println("Comsuming " + energy.toString());
    }

}
