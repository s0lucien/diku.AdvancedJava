package assignment2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class AMonitor implements Monitor, Runnable {

	private final int SENSOR_READS_QUEUE_SIZE = 3;
	private ArrayBlockingQueue<SensorReading> sensorReads = new ArrayBlockingQueue<>(SENSOR_READS_QUEUE_SIZE);
	private SensorReading SensorValueMean;
	private HashMap<Subscriber, Integer> subscribers = new HashMap<>(); //A monitor can push discomfort warnings to one or many subscribers

	@Override
	public void pushReading(SensorReading sensorInput) {
		try {
			sensorReads.add(sensorInput);
		} catch (IllegalStateException ex) {
			// reads are dropped if queue is full
		}
	}

	@Override
	public void processReading(SensorReading sensorInput) {
//		SensorReadingSequentialAggregator agg = new SensorReadingSequentialAggregator();
//		ArrayList bufferedSensorReads = new ArrayList<SensorReading>();
//		sensorReads.drainTo(bufferedSensorReads);
//		AverageSensorReading c = new AverageSensorReading();
//		SensorReading bufferMean = agg.aggregate(c, bufferedSensorReads);
//		this.SensorValueMean = c.combine(bufferMean,SensorValueMean);

		int discomfortLevel = sensorInput.getDiscomfortLevel();
		Iterator i = subscribers.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry pair = (Map.Entry) i.next();
			Subscriber subscriber = (Subscriber) pair.getKey();
			Integer maxDiscomfortLevel = (Integer) pair.getValue();
			if (discomfortLevel >= maxDiscomfortLevel) {
				subscriber.pushDiscomfortWarning(discomfortLevel);
			}
		}
	}

	@Override
	public synchronized void registerSubscriber(int discomfortLevel, Subscriber subscriber) {
		this.subscribers.put(subscriber, discomfortLevel);
	}

	@Override
	public SensorReading getSensorReading() {
		return sensorReads.poll();
	}

	public void run() {
		SensorReading sensorInput;
		while(true) {
			sensorInput = getSensorReading();
			if (sensorInput != null)
				this.processReading(sensorInput);
		}
	}

}
