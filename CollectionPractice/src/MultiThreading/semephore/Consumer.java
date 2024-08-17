package MultiThreading.semephore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
	
	Store store;
	Semaphore producerSema;
	Semaphore consumerSema;
	
	public Consumer(Store store, Semaphore producerSema, Semaphore consumerSema) {
		this.store = store;
		this.producerSema = producerSema;
		this.consumerSema = consumerSema;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
				consumerSema.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			store.removeItem();
			System.out.println("Removing an item from display display");
			producerSema.release();
			
		}
	}

}
