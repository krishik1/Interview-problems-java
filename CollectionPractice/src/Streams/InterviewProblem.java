package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewProblem {
	public static void main(String[] args) {
		List<Employee> empList = getEmpList();
		List<String> salList = empList.stream().map(Employee::getName).collect(Collectors.toList());
		salList.forEach(System.out::println);
	}	
	public static List<Employee> getEmpList(){
		List<Employee> empList = new ArrayList<>();
		Employee e1 = new Employee();
		e1.setName("A");
		e1.setSalary(12000);
		e1.setDept("IT");
		Employee e2 = new Employee();
		e2.setName("B");
		e2.setSalary(10000);
		e2.setDept("Test");
		Employee e3 = new Employee();
		e3.setName("C");
		e3.setSalary(11000);
		e3.setDept("DEV");
		Employee e4 = new Employee();
		e4.setName("D");
		e4.setSalary(13000);
		e4.setDept("OPS");
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		return empList;
	}
}
