package immutable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Set<String> departments = new HashSet<>();
		departments.add("HR");
		departments.add("TEST");
		departments.add("Production");
		Employee emp1 = new Employee(1L, "Harish", "AM", 28, departments);
		employees.add(emp1);
		departments=new HashSet<>();
		departments.add("HR");
		departments.add("DEV");
		departments.add("Production");
		Employee emp2 = new Employee(2L, "Raju", "SDE", 27, departments);
		employees.add(emp2);
		departments=new HashSet<>();
		departments.add("HR");
		departments.add("Managerial");
		departments.add("Production");
		Employee emp3 = new Employee(3L, "Jaga", "Manager", 27, departments);
		employees.add(emp3);
		departments=new HashSet<>();
		departments.add("Test");
		Employee emp4 = new Employee(4L, "Chid", "SD", 27, departments);
		employees.add(emp4);
		employees.forEach(System.out::println);
	}

}
