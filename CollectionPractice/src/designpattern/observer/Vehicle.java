package designpattern.observer;

public class Vehicle {
	private String vehicleId;
	private String userName;
	public Vehicle(String vehicleId, String userName) {
		super();
		this.vehicleId = vehicleId;
		this.userName = userName;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
