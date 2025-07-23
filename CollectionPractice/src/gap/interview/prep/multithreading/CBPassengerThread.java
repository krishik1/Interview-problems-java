package gap.interview.prep.multithreading;

import java.util.concurrent.CyclicBarrier;

public class CBPassengerThread extends Thread {
	CyclicBarrier cb;
	int duration;
	public CBPassengerThread(CyclicBarrier cb,int duration, String name) {
		super(name);
		this.cb=cb;
		this.duration=duration;
	}
	
	public void run() {
		
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName()+" has Started");
			int await = cb.await();
			System.out.println("await is :"+await);
			if(await==0) {
				System.out.println("Four Passegers has arrived . Cab is going to start.");
			}
		} catch (Exception e) {
			
		}
	}
	
}
