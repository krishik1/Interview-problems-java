package MultiThreadingANDSynchronization;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 List<Integer> list = Arrays.asList(8, 1, 4, 3, 9, 7, 6);
		ExecutorService es=Executors.newCachedThreadPool();
		Sorter sorter=new Sorter(list, es);
		Future<List<Integer>> fList=es.submit(sorter);
		List<Integer> finalList=fList.get();
		
		for(int i=0;i<finalList.size();i++) {
			System.out.print(finalList.get(i)+" ");
		}
		
	}
}
