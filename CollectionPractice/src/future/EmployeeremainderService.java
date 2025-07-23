package future;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class EmployeeremainderService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		filteredList().get();
		filteredListAsync().get();
	}
	  
	public static CompletableFuture<Void> filteredListAsync(){
		ExecutorService ex =Executors.newFixedThreadPool(5);
		CompletableFuture<Void> getFutureList = 
				CompletableFuture.supplyAsync(()->{
					System.out.println("Fetch Employees : "+Thread.currentThread().getId());
					return getEmpList();
				},ex).thenApplyAsync((employees)->{
					System.out.println("Filter new joined employees : "+Thread.currentThread().getId());
					return employees.stream().filter(Employees::isNewJoinee).collect(Collectors.toList());
				},ex).thenApplyAsync((employees)->{
					System.out.println("Filter employees whose training is pending : " + Thread.currentThread().getId());
					return employees.stream().filter(Employees::isLearningPending).collect(Collectors.toList());
				},ex).thenApplyAsync((employees)->{
					System.out.println("Fetch emailId : " + Thread.currentThread().getId());
					return employees.stream().map(Employees::getEmailId).collect(Collectors.toList());
				},ex).thenAccept((emails)->{
					System.out.println("Send notification : "+Thread.currentThread().getId());
					emails.forEach(EmployeeremainderService::sendNotification);
				});
		return getFutureList;
	}
	public static CompletableFuture<Void> filteredList() {
		CompletableFuture<Void> getFutureList = CompletableFuture.supplyAsync(()->{
			System.out.println("Fetch Employees : "+Thread.currentThread().getId());
			return getEmpList();
		}).thenApply((employees)->{
			System.out.println("Filter new joined employees : "+Thread.currentThread().getId());
			return employees.stream().filter(Employees::isNewJoinee).collect(Collectors.toList());
		}).thenApply((employees) -> {
	        System.out.println("Filter employees whose training is pending : " + Thread.currentThread().getId());
	        return employees.stream().filter(Employees::isLearningPending).collect(Collectors.toList());
	    }).thenApply((employees) -> {
	        System.out.println("Fetch emailId : " + Thread.currentThread().getId());
	        return employees.stream().map(Employees::getEmailId).collect(Collectors.toList());
	    }).thenAccept((emails)->{
			System.out.println("Send notification : "+Thread.currentThread().getId());
			emails.forEach(EmployeeremainderService::sendNotification);
		});
		
		
		return getFutureList;
	}
	public static void sendNotification(String mail) {
		System.out.println("Sending training remainder mail to : "+mail);
	}
	public static List<Employees> getEmpList(){
		List<Employees> employeeList = new ArrayList<>();
		Employees emp1 = new Employees(1, "John Doe", "john.doe@company.com", true, "Male", false, 55000.0, 4);
	    employeeList.add(emp1);

	    Employees emp2 = new Employees(2, "Jane Smith", "jane.smith@company.com", true, "Female", false, 56000.0, 2);
	    employeeList.add(emp2);

	    Employees emp3 = new Employees(3, "krish", "krish@company.com", false, "Male", false, 58000.0, 4);
	    employeeList.add(emp3);
	    
	    Employees emp4 = new Employees(4, "Raj", "Raj@company.com", true, "Male", false, 60000.0, 4);
	    employeeList.add(emp4);
	    
	    Employees emp5 = new Employees(5, "John", "john@company.com", true, "Male", true, 58000.0, 4);
	    employeeList.add(emp5);

	    Employees emp6 = new Employees(5, "Alice", "alice@company.com", true, "Female", true, 62000.0, 3);
	    employeeList.add(emp6);
	    
	    Employees emp7 = new Employees(7, "jaga", "jaga@company.com", true, "Male", false, 58000.0, 4);
	    employeeList.add(emp7);
	    Employees emp8 = new Employees(8, "chid", "chid@company.com", true, "Male", true, 52000.0, 3);
	    employeeList.add(emp8);
	    Employees emp9 = new Employees(9, "prasad", "prasad@company.com", true, "Male", false, 58000.0, 4);
	    employeeList.add(emp9);
	    Employees emp10 = new Employees(10, "Alex Johnson", "alex.johnson@company.com", true, "Male", false, 75000.0, 4);
	    employeeList.add(emp10);
	    Employees emp11 = new Employees(11, "bro", "bro@company.com", true, "Male", false, 50000.0, 3);
	    employeeList.add(emp11);

	    Employees emp12 = new Employees(12, "sant", "sant@company.com", true, "Male", true, 54000.0,4);
	    employeeList.add(emp12);

	    return employeeList;
	    
	}
}
