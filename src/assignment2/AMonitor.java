package assignment2;

import assignment1.Combinator;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class AMonitor implements Monitor, Runnable {

	private final int SENSOR_READS_QUEUE_SIZE = 100;
	ArrayBlockingQueue<SensorReading> SensorReads;
	public SensorReading SensorValueMean;

	public AMonitor(){
		SensorReads = new ArrayBlockingQueue<SensorReading>(SENSOR_READS_QUEUE_SIZE);

	}
	@Override
	public void pushReading(SensorReading sensorInput) {
		System.out.println("Received a reading");
		SensorReads.add( sensorInput);
	}

	@Override
	public void processReading(SensorReading sensorInput) {
		// TODO Auto-generated method stub
		SensorReadingSequentialAggregator agg = new SensorReadingSequentialAggregator();
		ArrayList bufferedSensorReads = new ArrayList<SensorReading>();
		SensorReads.drainTo(bufferedSensorReads);
		AverageSensorReading c = new AverageSensorReading();
		SensorReading bufferMean = agg.aggregate(c, bufferedSensorReads);
		this.SensorValueMean = c.combine(bufferMean,SensorValueMean);
		//Note that you need to push computed discomfort levels to the registered
		//subscribers using the pushDiscomfortWarning method in Subscriber interface
		
	}

	@Override
	public void registerSubscriber(int discomfortLevel, Subscriber subscriber) {
		// TODO Auto-generated method stub
	}

	@Override
	public SensorReading getSensorReading() {
		return SensorReads.poll();
	}

	public void run() {
		SensorReading sensorInput = null;
		while(true) {
			sensorInput = getSensorReading();
			this.processReading(sensorInput);
		}
	}

}
