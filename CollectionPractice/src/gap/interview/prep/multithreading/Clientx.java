package gap.interview.prep.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Clientx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Integer> list = Arrays.asList(14,11,19,12,18,15,20);
		ExecutorService es = Executors.newCachedThreadPool();
		MergeSort res = new MergeSort(list,es);
		Future<List<Integer>> futureRes = es.submit(res);
		List<Integer> resList = futureRes.get();
		for(int val:resList) {
			System.out.print(val+" ");
		}
	}

}
