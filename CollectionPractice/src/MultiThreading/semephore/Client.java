package MultiThreading.semephore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
	
	public static void main(String[] args) {
		Store store = new Store(10);
		
		ExecutorService es = Executors.newCachedThreadPool();
		Semaphore producerSema = new Semaphore(5);
		Semaphore consumerSema = new Semaphore(0);
		Producer pd = new Producer(store,producerSema,consumerSema);
		Consumer cs = new Consumer(store,producerSema,consumerSema);
		for (int i=1; i< 10; i++){
            es.execute(pd);
        }

        for (int i=1; i< 25; i++){
            es.execute(cs);
        }
	}

}
