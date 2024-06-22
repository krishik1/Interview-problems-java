package Exception;

public class Employee {
	private String name;
	private int age;
	private String dept;
	public Employee(String name, int age, String dept) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Employee(Employee e1) {
		this.name=e1.name;
		this.age=e1.age;
		this.dept=e1.dept;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}
	
	
}
