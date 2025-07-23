package future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		getEmpList().stream().map(e ->e.getMobile()).sorted().forEach(System.out::println);
		getEmpListExecutor().stream().map(e->e.getName()).sorted().forEach(System.out::println);
	}
	
	public static List<Employee> getEmpList() throws InterruptedException, ExecutionException {
		CompletableFuture<List<Employee>> futureList = CompletableFuture.supplyAsync(
				() -> {
					System.out.println("Executed Thread is : "+Thread.currentThread().getName());
					List<Employee> empList=RunAsyncDemo.getEmpList();
					return empList;
				}
				);
		return futureList.get();
	}

	public static List<Employee> getEmpListExecutor() throws InterruptedException, ExecutionException{
		ExecutorService exe = Executors.newCachedThreadPool();
		CompletableFuture<List<Employee>> futureList = CompletableFuture.supplyAsync(()->{
			System.out.println("Executed Thread is : "+Thread.currentThread().getName());
			List<Employee> empList = RunAsyncDemo.getEmpList();
			return empList;
		}, exe);
		return futureList.get();
		
	}
	
}
