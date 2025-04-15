package MultiThreadingANDSynchronization;

import java.util.Date;

public class User {
	private int id;
	private String dob;
	public User(int id, String dob2) {
		super();
		this.id = id;
		this.dob = dob2;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	@Override
    public String toString() {
        return "User{id=" + id + ", dob='" + dob + "'}";
	}

}
