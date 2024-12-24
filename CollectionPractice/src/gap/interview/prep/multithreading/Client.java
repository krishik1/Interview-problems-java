package gap.interview.prep.multithreading;

import java.util.concurrent.CountDownLatch;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(2);
		Thread devA = new Thread(new DevTeam(cdl, "DEV-A")); 
		Thread devB = new Thread(new DevTeam(cdl, "DEV-B"));
		devA.start();
		devB.start();
		cdl.await();
		Thread qaTeam = new Thread(new QATeam("QA Team"));
		qaTeam.start();
		
		
	}

}
