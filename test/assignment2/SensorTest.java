package assignment2;

import assignment1.Aggregator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SensorTest {

    @Test
    public void testGenerateSensorReading() {
        ASensor sensor = new ASensor();
        for (int i = 0; i < 1000; i++) {
            SensorReading sensorReading = sensor.generateSensorReading();
            assertTrue(sensorReading.getTemperature() > ASensor.MIN_TEMPERATURE && sensorReading.getTemperature() < ASensor.MAX_TEMPERATURE);
            assertTrue(sensorReading.getHumidity() > ASensor.MIN_HUMIDITY && sensorReading.getHumidity() < ASensor.MAX_HUMIDITY);
        }
    }


    @Test
    public void testAverageSensorReadingCombinator (){
        SensorReading sr1 = new SensorReading();
        sr1.setHumidity(23);
        sr1.setTemperature(32);
        SensorReading sr2 = new SensorReading();
        sr2.setHumidity(20);
        sr2.setTemperature(33);
        AverageSensorReading combinator = new AverageSensorReading();
        SensorReading meanReading = combinator.combine(sr1,sr2);
        assertThat(meanReading.getHumidity(), is(21.5f));
        assertThat(meanReading.getTemperature(), is(32.5f));
    }

    @Test
    public void testSensorReadingSequentialAggregator (){
        ArrayList<SensorReading> reads = new ArrayList<SensorReading>();
        SensorReading sr1 = new SensorReading();
        sr1.setHumidity(23);
        sr1.setTemperature(32);
        reads.add(sr1);
        SensorReading sr2 = new SensorReading();
        sr2.setHumidity(20);
        sr2.setTemperature(33);
        reads.add(sr2);
        SensorReading sr3 = new SensorReading();
        sr3.setHumidity(25);
        sr3.setTemperature(40);
        reads.add(sr3);
        SensorReading sr4 = new SensorReading();
        sr4.setHumidity(0);
        sr4.setTemperature(50);
        // woah the sensor is giving bad results
        reads.add(sr4);
        SensorReading sr5 = new SensorReading();
        sr5.setHumidity(23);
        sr5.setTemperature(32);
        //getting back in shape
        reads.add(sr5);
        SensorReading sr6 = new SensorReading();
        sr6.setHumidity(23);
        sr6.setTemperature(32);
        reads.add(sr6);
        SensorReading sr7 = new SensorReading();
        sr7.setHumidity(23);
        sr7.setTemperature(32);
        reads.add(sr7 );
        SensorReading sr8 = new SensorReading();
        sr8.setHumidity(23);
        sr8.setTemperature(32);
        reads.add(sr8);

        SensorReading meanReading = (new SensorReadingSequentialAggregator()).aggregate(new AverageSensorReading(),reads);
        assertThat(meanReading.getHumidity(), is(23));
        assertThat(meanReading.getTemperature(), is(32));
    }

}
