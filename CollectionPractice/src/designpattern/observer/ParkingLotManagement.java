package designpattern.observer;

import java.util.List;

public class ParkingLotManagement {

	private List<ParkingSlot> parkingLots;

	// check
	public ParkingLotManagement(List<ParkingSlot> parkingLots) {
		if (parkingLots == null || parkingLots.isEmpty()) {
			throw new IllegalArgumentException("Parking slots cannot be null or empty");
		}
		this.parkingLots = parkingLots;
	}

	public void parkVehicle(Vehicle vehicle) {
		for (ParkingSlot slot : parkingLots) {
			if (slot.getStatus().equals(ParkingSlotStatus.AVAILABLE)) {
				slot.setStatus(ParkingSlotStatus.BOOKED);
				System.out.println("Vehicle " + vehicle.getVehicleId() + " parked in spot " + slot.getSlotId());
				return;
			}

		}
		System.out.println("No available spots for vehicle " + vehicle.getVehicleId());
	}

	public void unParkVehicle(Vehicle vehicle, int spotNumber) {
		for(ParkingSlot slot : parkingLots) {
			if (slot.getSlotId() == spotNumber && slot.getStatus().equals(ParkingSlotStatus.BOOKED)) {
				slot.setStatus(ParkingSlotStatus.AVAILABLE);
				System.out.println("Vehicle " + vehicle.getVehicleId() + " unparked in spot " + slot.getSlotId());

				return;
			}

		}
	}

}
