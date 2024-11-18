package temp;

public class Student extends User{
	private int studentId;
	private String course;

	public Student(String userName, String email) {
		super(userName, email);
	}

	public Student(String userName, String email, int studentId, String course) {
		super(userName, email);
		this.studentId = studentId;
		this.course = course;
	}
	public static void main(String[] args) {
		User user = User.getUser();
		String name = user.getUserName();
		String email = user.getEmail();
		Student chidvi = new Student(name,email, 2, "Backend");
		display(chidvi);
	}
	
	public static void display(Student chidvi) 
	{
		System.out.println(chidvi.getUserName()+" "+chidvi.getEmail()+" "+chidvi.studentId+" "+chidvi.course);
		
	}

}
