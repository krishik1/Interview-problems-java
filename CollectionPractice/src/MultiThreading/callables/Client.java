package MultiThreading.callables;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Integer> ls = Arrays.asList(12, 3, 9, 19, 22, 10, 6);
		ExecutorService es = Executors.newCachedThreadPool();
		MergeSorter ms = new MergeSorter(ls, es);
		Future<List<Integer>> futureList = es.submit(ms);
		List<Integer> resList = futureList.get();
		
		for( int val : resList) {
			System.out.print(val+" ");
		}
	}
}
