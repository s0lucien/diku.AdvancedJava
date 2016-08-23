package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ASensor implements Sensor, Runnable {
	/*
		The following assumptions are based on Table 1 - Discomfort level
		temp random number between 0 - 60 - gives statistically best results when generating random SensorReading objects
		humidity random number between 40 - 100 - same reason as above
	*/

	private final float MIN_TEMPERATURE = 0;
	private final float MAX_TEMPERATURE = 60;
	private final float MIN_HUMIDITY = 40;
	private final float MAX_HUMIDITY = 100;
	private List<Monitor> monitors = new ArrayList<>(); //A sensor can push readings to one or many monitors

	public SensorReading generateSensorReading() {
		SensorReading reading = new SensorReading();
		Random rnd = new Random();
		reading.setTemperature((rnd.nextFloat() * (MAX_TEMPERATURE - MIN_TEMPERATURE)) + MIN_TEMPERATURE);
		reading.setHumidity((rnd.nextFloat() * (MAX_HUMIDITY - MIN_HUMIDITY)) + MIN_HUMIDITY);
		return reading;
	}

	public void run() {
		SensorReading reading;
		while (true) {
			reading = this.generateSensorReading();
			for (Monitor sm : monitors) {
				sm.pushReading(reading);
			}
			try {
				Thread.sleep(100); // 0.1 sec, so we don't get flooded
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public synchronized void registerMonitor(List<Monitor> sm) {
		this.monitors = sm;
	}

}
