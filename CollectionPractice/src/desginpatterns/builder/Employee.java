package desginpatterns.builder;

public class Employee {

	private String name;
	private int age;
	private double salary;
	private String department;
	private String role;
	private String company;

	private Employee(EmployeeBuilder builder) {
		name = builder.name;
		age = builder.age;
		salary = builder.salary;
		department = builder.department;
		role = builder.role;
		company = builder.company;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	public String getRole() {
		return role;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", department=" + department
				+ ", role=" + role + ", company=" + company + "]";
	}

	public static class EmployeeBuilder {

		private String name;
		private int age;
		private double salary;
		private String department;
		private String role;
		private String company;
		private boolean isDeliverd;
		private long timestamp;
		private MessageType messageType;

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public void setMessageType(MessageType messageType) {
			this.messageType = messageType;
		}

		public EmployeeBuilder setDeliverd(boolean isDeliverd) {
			this.isDeliverd = isDeliverd;
			return this;
		}

		public EmployeeBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public EmployeeBuilder setSalary(double salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public EmployeeBuilder setRole(String role) {
			this.role = role;
			return this;
		}

		public EmployeeBuilder setCompany(String company) {
			this.company = company;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}

	}
}
