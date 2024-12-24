package completable.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Client {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Integer> list = Arrays.asList(8, 1, 4, 3, 9, 7, 6);
//		ExecutorService es = Executors.newCachedThreadPool();
//		MergeSorter sorter = new MergeSorter(list, es);
//		Future<List<Integer>> futureList = es.submit(sorter);
//		List<Integer> resList = futureList.get();
//		for(int val:resList) {
//			System.out.print(val+" ");
//		}
		// UsingCompletable Future
		MergeSortCF sorter = new MergeSortCF(list);
		CompletableFuture<List<Integer>> futureList = sorter.sort();
		List<Integer> resList = futureList.get();
		for(int val:resList) {
			System.out.print(val+" ");
		}

	}
}
