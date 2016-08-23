package assignment2;

import assignment1.Combinator;

/**
 * Created by Lu on 8/23/2016.
 */
public class AverageSensorReading implements Combinator<SensorReading, SensorReading> {
    @Override
    public SensorReading neutral() {
        return  new SensorReading(0f, 0f);

    }

    @Override
    public SensorReading combine(SensorReading x, SensorReading y) {
        SensorReading sen = new SensorReading();
        sen.setTemperature( (x.getTemperature() + y.getTemperature())/2 );
        sen.setHumidity ( (x.getHumidity() + y.getHumidity())/2 );
        return sen;
    }


    @Override
    public SensorReading get(SensorReading x) {
        return x;
    }

}
