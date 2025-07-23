package MultiThreadingANDSynchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClient {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newCachedThreadPool();
		Lock lock = new ReentrantLock();
		Count cnt = new Count(0);
		Adder adder = new Adder(cnt, lock);
		Substractor sub = new Substractor(cnt, lock);
		Future<Count> fAdder = ex.submit(adder);
		Future<Count> fsub = ex.submit(sub);
		fAdder.get();
		fsub.get();
		System.out.println("res : "+cnt.val);
	}
}
