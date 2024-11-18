package builder2;

public class Address {
	
	private String flatNumber;
	private String area;
	private String city;
	private String state;
	private String pincode;
	
	private Address() {
		
	}
	
//	public Address(String flatNumber, String area, String city, String state, String pincode) {
//		super();
//		this.flatNumber = flatNumber;
//		this.area = area;
//		this.city = city;
//		this.state = state;
//		this.pincode = pincode;
//	}
	
	
	public String getFlatNumber() {
		return flatNumber;
	}


	public String getArea() {
		return area;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getPincode() {
		return pincode;
	}


	public static class AddressBuilder {
		private String flatNumber;
		private String area;
		private String city;
		private String state;
		private String pincode;
		
		public AddressBuilder flatNumber(String flatNumber) {
			this.flatNumber = flatNumber;
			return this;
		}
		public AddressBuilder area(String area) {
			this.area = area;
			return this;
		}
		public AddressBuilder city(String city) {
			this.city = city;
			return this;
		}
		public AddressBuilder state(String state) {
			this.state = state;
			return this;
		}
		public AddressBuilder pinCode(String pincode) {
			this.pincode = pincode;
			return this;
		}
		
		public Address build() {
			Address address = new Address();
			address.flatNumber=flatNumber;
			address.area=area;
			address.city=city;
			address.pincode=pincode;
			address.state=state;
			return address;
		}
		
		
	}
	
}
