package MultiThreading.AddeSub;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Count c = new Count(0);
		Lock lock = new ReentrantLock();
		Adder add = new Adder(c, lock);
		Substractor sub = new Substractor(c, lock);
		ExecutorService  es = Executors.newCachedThreadPool();
		Future<Count> adderFuture = es.submit(add);
		Future<Count> subFuture = es.submit(sub);
		adderFuture.get();
		subFuture.get();
		System.out.println(c.val);
	}
}
