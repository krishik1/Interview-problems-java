package MultiThreading.fibinocci;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ExecutorService es = Executors.newCachedThreadPool();
		Fibinocci fc = new Fibinocci(n,es);
		Future<Integer> resFuture = es.submit(fc);
		Integer res = resFuture.get();
		System.out.println(res);
	}

}
