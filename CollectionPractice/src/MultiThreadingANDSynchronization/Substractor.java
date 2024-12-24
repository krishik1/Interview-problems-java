package MultiThreadingANDSynchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Substractor implements Callable<Count> {
	Count cnt;
	Lock lock;
	

	public Substractor(Count val, Lock lock) {
		this.cnt = val;
		this.lock = lock;
	}


	@Override
	public Count call() throws Exception {
		for(int i=0;i<100000;i++) {
			lock.lock();
			System.out.println(cnt.val);
			cnt.val = cnt.val-i;
			lock.unlock();
		}
		return cnt;
	}

}
