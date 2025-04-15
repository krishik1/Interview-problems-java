package parallel.streams;

public class Student {
	
	private long id;
	private String name;
	private String mobileNumber;
	private int age;
	
	
	public Student(long id, String name, String mobileNumber, int age) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", age=" + age + "]";
	}
	
	
	

}
