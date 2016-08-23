package assignment2;

import assignment1.Aggregator;
import assignment1.Combinator;

import java.util.List;

/**
 * Created by Lu on 8/23/2016.
 */
public class SensorReadingSequentialAggregator implements Aggregator<SensorReading, SensorReading> {
    SensorReading result;
    @Override
    public SensorReading aggregate(Combinator<SensorReading, SensorReading> c, List<SensorReading> lst) {
        for ( SensorReading reading: lst) {
            this.result = c.combine(this.result, reading);
        }
        return this.result;
    }
}
