package assignment2;

import org.junit.Test;

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

}
