package assignment2;

import java.util.Arrays;

public class SensorNetworkHarness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Using the same example as on Fig. 1
		ASensor sensor1 = new ASensor();
		ASensor sensor2 = new ASensor();
		ASensor sensor3 = new ASensor();

		AMonitor monitor1 = new AMonitor();
		AMonitor monitor2 = new AMonitor();

		ASubscriber subscriber1 = new ASubscriber();
		ASubscriber subscriber2 = new ASubscriber();

		sensor1.registerMonitor(Arrays.asList(monitor1));
		sensor2.registerMonitor(Arrays.asList(monitor1, monitor2));
		sensor3.registerMonitor(Arrays.asList(monitor2));

		monitor1.registerSubscriber(4, subscriber1);
		monitor2.registerSubscriber(3, subscriber1);
		monitor2.registerSubscriber(2, subscriber2);

		new Thread(sensor1).start();
		new Thread(sensor2).start();
		new Thread(sensor3).start();
		new Thread(subscriber1).start();
		new Thread(subscriber2).start();
		new Thread(monitor1).start();
		new Thread(monitor2).start();
	}
}
