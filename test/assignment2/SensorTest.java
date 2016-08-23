package assignment2;

import org.junit.Test;

import java.util.ArrayList;

public class SensorTest {

    @Test
    public void testSensorReadingGeneration() {
        ASensor sensor = new ASensor();
        new Thread(sensor).start();

        try {
            Thread.currentThread().sleep(3000);
            Monitor m_1 = new AMonitor();
            Monitor m_2 = new AMonitor();
            ArrayList<Monitor> monitors = new ArrayList<>();
            new Thread() {
                public void run() {
                    monitors.add(m_1);
                }
            }.start();

            new Thread() {
                public void run() {
                    monitors.add(m_2);
                }
            }.start();


            sensor.registerMonitor(monitors);
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
