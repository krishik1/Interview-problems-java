package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListMapping {
	public static void main(String[] a) {
		ArrayList<User> userList = getUser();

		userList.forEach(u -> { System.out.println("userId is: " + u.getUserID() +
                ", name is: " + u.getUserName() + ", DEPT is: " + u.getUserDept() +
                ", Salary is: " + u.getSalary() + ", Address is: " + u.getAddress().getStreet() +
                ", " + u.getAddress().getCity() + ", " + u.getAddress().getZipCode());
				
		u.getTasks().forEach(task -> {
            System.out.println("Task Name: " + task.getTaskName() + ", Task Description: " + task.getTaskDescription());
        });
		
		System.out.println();
	});
		
	

	}

	public static ArrayList<Employee> getEmployee() {
		ArrayList<Employee> empList = new ArrayList<>();
		Employee e = new Employee();

		List<Task> tasks = new ArrayList<>();
		Task task1 = new Task();
		task1.setTaskName("Develop Feature");
		task1.setTaskDescription("Develop the new feature for the project.");
		tasks.add(task1);

		Task task2 = new Task();
		task2.setTaskName("Fix Bug");
		task2.setTaskDescription("Fix the bug reported by QA.");
		tasks.add(task2);

		e.setName("Raju");
		e.setEmpId(211);
		e.setDept("Developer");
		e.setSalary(1000000);
		Address address = new Address();
		address.setStreet("MIG-1-563");
		address.setCity("PMP");
		address.setZipCode("530041");
		e.setAddress(address);
		e.setTasks(tasks);
		empList.add(e);

		Employee e1 = new Employee();
		e1.setName("Chidvi");
		e1.setEmpId(210);
		e1.setDept("Tester");
		e1.setSalary(1000000);
		Address address1 = new Address();
		address1.setStreet("MIG-1-554");
		address1.setCity("PMP");
		address1.setZipCode("530041");
		e1.setAddress(address1);
		e1.setTasks(tasks);
		empList.add(e1);

		Employee e2 = new Employee();
		e2.setName("Ajay");
		e2.setEmpId(212);
		e2.setDept("devops");
		e2.setSalary(1000000);
		Address address2 = new Address();
		address2.setStreet("SteelPlant Colony");
		address2.setCity("Gajuwaka");
		address2.setZipCode("530045");
		e2.setAddress(address2);
		e2.setTasks(tasks);
		empList.add(e2);

		return empList;
	}

	public static ArrayList<User> getUser() {
		ArrayList<User> userList = new ArrayList<>();
		ArrayList<Employee> empList = getEmployee();

		return (ArrayList<User>) empList.stream().map(e -> {
			User user = new User();
			user.setUserID(e.getEmpId());
			user.setUserName(e.getName());
			user.setUserDept(e.getDept());
			user.setSalary(e.getSalary());
			Address addr = new Address();
			addr.setCity(e.getAddress().getCity());
			addr.setStreet(e.getAddress().getStreet());
			addr.setZipCode(e.getAddress().getZipCode());
			user.setAddress(addr);
			List<Task> userTasks = e.getTasks().stream().map(task -> {
				Task userTask = new Task();
				userTask.setTaskName(task.getTaskName());
				userTask.setTaskDescription(task.getTaskDescription());
				return userTask;
			}).collect(Collectors.toList());
			user.setTasks(userTasks);

			return user;
		}).collect(Collectors.toList());
	}

}
