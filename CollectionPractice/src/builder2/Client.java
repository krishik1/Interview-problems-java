package builder2;

public class Client {
	
	public static void main(String[] args) {
		Student student = new Student.Builder().name("Gopal").surname("Mahatho").age(19)
				.stdId("13146211").departMent(DepartMent.CSE).address(new Address.AddressBuilder().flatNumber("Babu Residency")
						.area("P.M.Palem").city("Vizag").pinCode("530041").state("Andhra Pradesh").build())
				.build();
		
		System.out.println("Name : "+student.getName());
		System.out.println("Full Name : "+student.getFullName());
		System.out.println("Id : "+student.getId());
		System.out.println("Age : "+student.getAge());
		System.out.println("DepartMent : "+student.getDepartMent());
		System.out.println("Address : ");
		System.out.println("Flat Number : "+student.getAddress().getFlatNumber());
		System.out.println("Area : "+student.getAddress().getArea());
		System.out.println("City : "+student.getAddress().getCity());
		System.out.println("State : "+student.getAddress().getState());
		System.out.println("Pin Code : "+student.getAddress().getPincode());
	}

}
