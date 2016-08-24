package subtyping.consumers;

import subtyping.EnergySource;

public class Burner implements Consumer<EnergySource>{

    @Override
    public void consume(EnergySource energy) {
        System.out.println("Burning " + energy.toString());
    }

}
