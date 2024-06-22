package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunAsyncDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		getRunAsync();
		getRunAsyncWithExec();
	}
	public static void getRunAsync() throws InterruptedException, ExecutionException {
		List<Employee> empList = getEmpList();
		System.out.println("Begin");
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			 try {
			        
			        System.out.println("Thread: " + Thread.currentThread().getName());
			        empList.stream().map(e->e.getName()).forEach(System.out::println);
			        System.out.println("Size : "+empList.size());
			        
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
        });
		runAsyncFuture.get();
		
	}
	
	public static void getRunAsyncWithExec() throws InterruptedException, ExecutionException {
		List<Employee> empList = getEmpList();
		System.out.println("Begin");
		Executor ex  = Executors.newCachedThreadPool();
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			 try {
			        
			        System.out.println("Thread: " + Thread.currentThread().getName());
			        empList.stream().map(e->e.getMobile()).forEach(System.out::println);
			        System.out.println("Size : "+empList.size());
			        ex.wait(5);
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
        },ex);
		runAsyncFuture.get();
		//runAsyncFuture.toCompletableFuture();
	}
	
	public static List<Employee> getEmpList(){
		Employee e1 = new Employee("Raju", 26, 27000, "POCO");
		Employee e2 = new Employee("Jaga", 27, 50000, "Samsung");
		Employee e3 = new Employee("Adhi", 25, 40000, "Nothing");
		Employee e4 = new Employee("Chidvi", 26, 28000, "IQ");
		Employee e5 = new Employee("Prasad", 28, 40000, "Realme");
		Employee e6 = new Employee("Santosh", 26, 25000, "VIVO");
		Employee e7 = new Employee("Bro", 27, 45000, "ONEPLUS");
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		return list;
		
	}
}
