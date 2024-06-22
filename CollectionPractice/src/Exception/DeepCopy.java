package Exception;

public class DeepCopy {
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Raju", 26, "CSE");
		Employee e2 = e1;
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		Employee e3 = new Employee(e1);
		e3.setName("Krishik");
		e3.setDept("IT");
		System.out.println(e3.toString());
	}

}
