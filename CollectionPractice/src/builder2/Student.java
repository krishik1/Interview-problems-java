package builder2;

public class Student {

	private String name;
	private String surname;
	private String fullName;
	private String id;
	private int age;
	private DepartMent departMent;
	private Address address;

	private Student() {

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getFullName() {
		return fullName;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public DepartMent getDepartMent() {
		return departMent;
	}

	public Address getAddress() {
		return address;
	}

	public static class Builder {
		private String name;
		private String surname;
		private String id;
		private int age;
		private DepartMent departMent;
		private Address address;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder surname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder stdId(String id) {
			this.id = id;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder departMent(DepartMent departMent) {
			this.departMent = departMent;
			return this;
		}

		public Builder address(Address address) {
			this.address = address;
			return this;
		}

		public String fullName() {
			return surname + " " + name;
		}

		public Student build() {
			Student std = new Student();
			std.name = name;
			std.surname = surname;
			std.id = id;
			std.age = age;
			std.departMent = departMent;
			std.address = address;
			std.fullName = fullName();
			return std;
		}

	}

}
