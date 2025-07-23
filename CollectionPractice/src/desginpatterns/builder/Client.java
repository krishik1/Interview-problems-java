package desginpatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		List<Developer> d = new ArrayList<>();
		
		Employee employee = new Employee.EmployeeBuilder()
				.setName("Krish")
				.setAge(26)
				.setSalary(27000)
				.setDepartment("IT").setRole("Backend Developer")
				.setCompany("TCS")
				.build();
		
		System.out.println("Employee details : "+employee);
		
		Developer developer = new Developer.DeveloperBuilder()
                .setEmpId(2009203)
                .setEmployee(employee)
                .build();
				
		System.out.println("Developer details : "+developer);	
				
	}
}
