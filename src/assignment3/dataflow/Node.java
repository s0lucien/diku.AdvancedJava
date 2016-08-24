package assignment3.dataflow;

import assignment3.processors.Processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * A generic dataflow node.
 * 
 * @author fmma
 * 
 */
public class Node<I, O> extends Thread {

	/**
	 * The capacity of the blocking queue.
	 */
	private static final int QUEUE_SIZE = 10;

	/**
	 * The list of subscribers to this node.
	 */
	private List<Node<O, ?>> subscribers;

	/**
	 * The queue of inputs (contains values of type I).
	 */
	private BlockingDeque<I> inputs;

	/**
	 * The processor of this node. See {@link Processor}.
	 */
	private Processor<I,O> processor;

	/**
	 * Constructs a new node.
	 * 
	 * @param processor
	 *            The {@link Processor} of this node.
	 */
	public Node(Processor processor) {
		this.processor = processor;
		subscribers = new ArrayList();
		inputs = new LinkedBlockingDeque(QUEUE_SIZE);
	}

	/**
	 * Subscribe another node to this node. The subscriber will receive pushes
	 * from this node.
	 * 
	 * @param subscriber
	 *            A subscriber that can receive values of type O.
	 */
	public void subscribe(Node subscriber) {
		subscribers.add(subscriber);
	}

	/**
	 * Inputs data pushed to this node. Note that this method is _not_ called by
	 * this thread but by other threads that this node subscribes to.
	 * 
	 * @param in
	 *            Input data (of type I).
	 */
	public void push(I in) {
		inputs.offerFirst(in);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {

				Iterator<O> iter = processor.process(inputs.takeLast());
				while (iter.hasNext()) {
					O next = iter.next();
					for (Node<O,? > sub : subscribers) {
						sub.push(next);
					}
				}

			} catch (InterruptedException e) {
			}
		}
	}
}
