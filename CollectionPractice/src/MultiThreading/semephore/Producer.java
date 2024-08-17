package MultiThreading.semephore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
	Store store;
	Semaphore producerSema;
	Semaphore consumerSema;

	public Producer(Store store, Semaphore producerSema, Semaphore consumerSema) {
		this.store = store;
		this.producerSema = producerSema;
		this.consumerSema = consumerSema;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				producerSema.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			store.addItem(new Object());
			System.out.println("Adding an item from display display");
			consumerSema.release();
		}
	}

}
