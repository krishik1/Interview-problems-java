package designpattern.observer;

public class ParkingOperator implements Observer {
	private String name;
	
	

	public ParkingOperator(String name) {
		super();
		this.name = name;
	}



	@Override
	public void update(ParkingSlot parkingSlot) {
		System.out.println("Notification to Parking Attendant " + name + ": Spot " + parkingSlot.getSlotId() +
                " is now " + parkingSlot.getStatus());
	}

}
