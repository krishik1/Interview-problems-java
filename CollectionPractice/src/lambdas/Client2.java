package lambdas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Count cnt = new Count();
		Lock lock = new ReentrantLock();
		Callable<Count> adder = () -> {
			for (int i = 1; i < 100; i++) {
				lock.lock();
				cnt.value = cnt.value + i;
				lock.unlock();
			}
			return cnt;
		};

		Callable<Count> subtractor = () -> {
			for (int i = 1; i < 100; i++) {
				lock.lock();
				cnt.value = cnt.value - i;
				lock.unlock();
			}
			return cnt;
		};
		ExecutorService executorService = Executors.newCachedThreadPool();

		Future<Count> fc = executorService.submit(adder);

		Future<Count> fc1 = executorService.submit(subtractor);

		fc.get();
		fc1.get();

		System.out.println(cnt.value);
	}

}
