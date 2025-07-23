package desginpatterns.builder;

public class Developer {
	
	private double empId;
	private String name;
	private int age;
	private double salary;
	private String department;
	private String role;
	private String company;
	
	private Developer(DeveloperBuilder builder) {
		empId=builder.empId;
		name = builder.name;
		age = builder.age;
		salary = builder.salary;
		department = builder.department;
		role = builder.role;
		company = builder.company;
	}
	
	
	
	@Override
	public String toString() {
		return "Developer [empId=" + empId + ", name=" + name + ", age=" + age + ", salary=" + salary + ", department="
				+ department + ", role=" + role + ", company=" + company + "]";
	}



	public static class DeveloperBuilder {
		private double empId;
		private String name;
		private int age;
		private double salary;
		private String department;
		private String role;
		private String company;
		
		public DeveloperBuilder setEmpId(double empId) {
			this.empId = empId;
			return this;
		}
		
		
		public DeveloperBuilder setEmployee(Employee employee) {
            this.name = employee.getName();
            this.age = employee.getAge();
            this.salary = employee.getSalary();
            this.department = employee.getDepartment();
            this.role = employee.getRole();
            this.company = employee.getCompany();
            return this;
        }
		
		public Developer build() {
			return new Developer(this);
		}
		
		
	}


}
