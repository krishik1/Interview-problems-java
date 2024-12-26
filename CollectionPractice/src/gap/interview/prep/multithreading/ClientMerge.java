package gap.interview.prep.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ClientMerge {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Integer> list = Arrays.asList(12,10,19,28,14,17,29);
		MergeSortCF ms = new MergeSortCF(list);
		CompletableFuture<List<Integer>> futureList = ms.sortList();
		List<Integer> res = futureList.get();
		
		for(int val:res) {
			System.out.print(val+" ");
		}
	}

}
