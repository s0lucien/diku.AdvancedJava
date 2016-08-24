//package junitsamples.ringcounter;
//
//import static org.junit.Assert.*;
//
//import java.util.Random;
//
//import org.junit.Test;
//
//public class RingCounterTestConcurrent {
//
//	Random r = new Random();
//
//	private RingCounter fresh() {
//	    return null;
//		//return new RC_MOD();
//	}
//
//	@Test
//	public void testGet() {
//		RingCounter rc = fresh();
//		assertEquals(1, rc.get());
//	}
//
//	@Test
//	public void testConsistency() throws InterruptedException {
//		RingCounter rcConcurrent = fresh();
//
//		int[] incs = new int[10000];
//
//		for (int i = 0; i < incs.length; i++) {
//			incs[i] = r.nextInt(1000);
//		}
//
//		Thread[] threads = new Thread[10000];
//		for (int i = 0; i < threads.length; i++) {
//			threads[i] = new Thread(new IncrementTask(rcConcurrent, incs[i]));
//		}
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].start();
//		}
//
//		for (int i = 0; i < 1000000000; i++) {
//			assertTrue(rcConcurrent.get() > 0 && rcConcurrent.get() <= 16);
//		}
//	}
//
//
//	@Test
//	public void testInc() {
//		RingCounter rc = fresh();
//		rc.inc(16);
//		assertEquals(1, rc.get());
//		rc.inc(0);
//		assertEquals(1, rc.get());
//		rc.inc(5);
//		assertEquals(6, rc.get());
//		rc.inc(32);
//		assertEquals(6, rc.get());
//		try {
//			rc.inc(-4);
//			fail("Expected exception");
//		} catch (IllegalArgumentException e) {
//			// All good
//		}
//	}
//
//	@Test
//	public void testSerializability() throws InterruptedException {
//		RingCounter rcConcurrent = fresh();
//		RingCounter rcSerial = fresh();
//
//		int[] incs = new int[1000];
//
//		for (int i = 0; i < incs.length; i++) {
//			incs[i] = r.nextInt(1000);
//		}
//
//		Thread[] threads = new Thread[1000];
//		for (int i = 0; i < threads.length; i++) {
//			threads[i] = new Thread(new IncrementTask(rcConcurrent, incs[i]));
//		}
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].start();
//		}
//		for (int i = 0; i < threads.length; i++) {
//			threads[i].join();
//		}
//
//		for (int i = 0; i < incs.length; i++) {
//			rcSerial.inc(incs[i]);
//		}
//
//		assertEquals(rcSerial.get(), rcConcurrent.get());
//	}
//
//	public class IncrementTask implements Runnable {
//
//		private RingCounter rc;
//		private int i;
//
//		public IncrementTask(RingCounter rc1, int i) {
//			this.rc = rc1;
//			this.i = i;
//		}
//
//		@Override
//		public void run() {
//			rc.inc(i);
//		}
//
//	}
//}
