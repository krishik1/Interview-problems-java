package MultiThreading.AddeSub;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Count>{
	Count cnt;
	Lock lock;
	

	public Adder(Count cnt, Lock lock) {
		this.cnt = cnt;
		this.lock = lock;
	}


	@Override
	public Count call() throws Exception {
		for(int i=0;i<1000;i++) {
			lock.lock();
			cnt.val += 1;
			System.out.println("Adder adding value : "+cnt.val);
			lock.unlock();
		}
		
		return cnt;
	}

}
