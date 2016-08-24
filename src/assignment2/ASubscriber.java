package assignment2;

import java.util.concurrent.ArrayBlockingQueue;

public class ASubscriber implements Subscriber, Runnable {

	private final int DISCOMFORT_READS_QUEUE_SIZE = 3;
	ArrayBlockingQueue<Integer> discomfortReads = new ArrayBlockingQueue<>(DISCOMFORT_READS_QUEUE_SIZE);

	public void run() {
		while (true) {
			int discomfortLevel = this.getDiscomfortWarning();
			if (discomfortLevel != -1) {
				this.processDiscomfortWarning(discomfortLevel);
			}
		}
	}

	@Override
	public void pushDiscomfortWarning(int discomfortlevel) {
		try {
			discomfortReads.add(discomfortlevel);
		} catch (IllegalStateException ex) {
			// discomfort reads are dropped if queue is full
		}
		
	}

	@Override
	public void processDiscomfortWarning(int discomfortLevel) {
		switch (discomfortLevel) {
			case 0: System.out.println("Discomfort level of " + discomfortLevel + " ! Look, a penguin.."); break;
			case 1: System.out.println("Discomfort level of " + discomfortLevel + " ! Chilly"); break;
			case 2: System.out.println("Discomfort level of " + discomfortLevel + " ! Nice and cosy. Definitely not Denmark."); break;
			case 3: System.out.println("Discomfort level of " + discomfortLevel + " ! You start sweating while coding and its not because of the code"); break;
			case 4: System.out.println("Discomfort level of " + discomfortLevel + " ! You start passing out while coding"); break;
			case 5: System.out.println("Discomfort level of " + discomfortLevel + " ! You must be dead at this point, so what is the point of coding anyway?");
			default:
		}

		
	}

	@Override
	public int getDiscomfortWarning() {
		if (discomfortReads.size() > 0) {
			return discomfortReads.poll();
		}
		else {
			return -1;
		}
	}



}
