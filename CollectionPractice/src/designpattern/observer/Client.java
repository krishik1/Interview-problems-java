package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		
		List<ParkingSlot> parkingSlots = new ArrayList<>(); 
		for(int i=0;i<15;i++) {
			ParkingSlot slot = new ParkingSlot(i);
			parkingSlots.add(slot);
		}
		Admin admin = new Admin("ADMIN");
		ParkingOperator operator1 = new ParkingOperator("Alice");
		ParkingOperator operator2 = new ParkingOperator("Bob");
		ParkingSlot s1 = parkingSlots.get(0);
		ParkingSlot s2 = parkingSlots.get(1);
		s1.registerObserver(admin);
		s1.registerObserver(operator1);
		s2.registerObserver(admin);
		s2.registerObserver(operator2);
		ParkingLotManagement parkinglot = new ParkingLotManagement(parkingSlots);
		
		Vehicle v1= new Vehicle("Jag@14AP", "Jaga");
		parkinglot.parkVehicle(v1);
		Vehicle v2= new Vehicle("Raj@29AP", "Raju");
		parkinglot.parkVehicle(v2);
		parkinglot.unParkVehicle(v1   , 0);
	}

}
