package gap.interview.prep.multithreading;

import java.util.concurrent.CyclicBarrier;

public class ClientCyclicBarrier {
	public static void main(String[] args) {
		System.err.println(Thread.currentThread().getName()+" has started.");
		CyclicBarrier cb = new CyclicBarrier(4);
		CBPassengerThread p1 = new CBPassengerThread(cb, 1000, "Krish");
		CBPassengerThread p2 = new CBPassengerThread(cb, 2000, "Jaga");
		CBPassengerThread p3 = new CBPassengerThread(cb, 3000, "Adi");
		CBPassengerThread p4 = new CBPassengerThread(cb, 4000, "Chid");
		
		CBPassengerThread p5 = new CBPassengerThread(cb, 1000, "Prasad");
		CBPassengerThread p6 = new CBPassengerThread(cb, 2000, "Kalyan");
		CBPassengerThread p7 = new CBPassengerThread(cb, 3000, "Santosh");
		CBPassengerThread p8 = new CBPassengerThread(cb, 4000, "Avi");
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		
		System.out.println(Thread.currentThread().getName() + " has finished");
		
	}
}
