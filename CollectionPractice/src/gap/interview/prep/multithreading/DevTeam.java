package gap.interview.prep.multithreading;

import java.util.concurrent.CountDownLatch;

public class DevTeam implements Runnable {
	CountDownLatch countDownLatch;
	String name;

	public DevTeam(CountDownLatch countDownLatch, String name) {
		this.countDownLatch = countDownLatch;
		this.name = name;
	}


	@Override
	public void run() {
		System.out.println("Task Assigned to Devlopment Team "+name);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Task Finished to Devlopment Team "+name);
		countDownLatch.countDown();
	}

}
