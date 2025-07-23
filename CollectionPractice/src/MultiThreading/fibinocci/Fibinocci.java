package MultiThreading.fibinocci;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Fibinocci implements Callable<Integer> {
	
	int val;
	ExecutorService es; 
	
	
	public Fibinocci(int val, ExecutorService es) {
		this.val = val;
		this.es = es;
	}


	@Override
	public Integer call() throws Exception {
		if(val<=1) {
			return val;
		}
		Fibinocci last = new Fibinocci(val-1, es);
		Fibinocci secLast = new Fibinocci(val-2, es);
		Future<Integer> futureLast = es.submit(last);
		Future<Integer> futureSecLast = es.submit(secLast);
		Integer resl = futureLast.get();
		Integer resSl = futureSecLast.get();
		return resl+resSl;
	}
	 
}
