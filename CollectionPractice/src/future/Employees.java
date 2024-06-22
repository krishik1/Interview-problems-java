package future;

public class Employees {

	private int empId;
	private String name;
	private String emailId;
	private boolean newJoinee;
	private String gender;
	private boolean learningPending;
	private double salary;
	private int rating;
	public Employees(int empId, String name, String emailId, boolean newJoinee, String gender, boolean learningPending,
			double salary, int rating) {
		super();
		this.empId = empId;
		this.name = name;
		this.emailId = emailId;
		this.newJoinee = newJoinee;
		this.gender = gender;
		this.learningPending = learningPending;
		this.salary = salary;
		this.rating = rating;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public boolean isNewJoinee() {
		return newJoinee;
	}
	public void setNewJoinee(boolean newJoinee) {
		this.newJoinee = newJoinee;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isLearningPending() {
		return learningPending;
	}
	public void setLearningPending(boolean learningPending) {
		this.learningPending = learningPending;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
