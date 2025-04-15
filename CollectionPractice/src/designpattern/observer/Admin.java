package designpattern.observer;

public class Admin implements Observer{
	
	private String name;
	
	

	public Admin(String name) {
		super();
		this.name = name;
	}



	@Override
	public void update(ParkingSlot parkingSlot) {
		System.out.println("Notification to Parking Admin " + name + ": Spot " + parkingSlot.getSlotId() +
                " is now " + parkingSlot.getStatus());
	}

}
