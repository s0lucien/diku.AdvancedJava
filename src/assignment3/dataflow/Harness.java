package assignment3.dataflow;

import assignment3.processors.*;

public class Harness {
	public static void main(String[] args) {
		Node<StartSignal, SensorReading> sensor1 = new Node<>(new SensorReadingGenerator());
		Node<StartSignal, SensorReadingExtended> sensor2 = new Node<>(new SensorReadingExtendedGenerator());
		
		Node<SensorReading, DiscomfortWarning> monitor1 = new Node<>(new DiscomfortProcessor());
		sensor1.subscribe(monitor1);
		sensor2.subscribe(monitor1);
		
		Node<DiscomfortWarning, Object> subscriber1 = new Node<>(new PrinterProcessor<DiscomfortWarning>("Printer 1"));
		monitor1.subscribe(subscriber1);
		
		Node<Object, Object> subscriber2 = new Node<>(new PrinterProcessor<>("Printer 2"));
		monitor1.subscribe(subscriber2);
		
		sensor1.start();
		sensor2.start();
		monitor1.start();
		subscriber1.start();
		subscriber2.start();
		
		sensor1.push(StartSignal.go);
		sensor2.push(StartSignal.go);
	}
}
