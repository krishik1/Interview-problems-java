package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlot implements Subject {
	
	private int slotId;
	private ParkingSlotStatus parkingSlotStatus;
	private List<Observer> observers = new ArrayList<>();
	
	public ParkingSlot(int id) {
		slotId=id;
		parkingSlotStatus=ParkingSlotStatus.AVAILABLE;
	}
	
	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public ParkingSlotStatus getStatus() {
        return parkingSlotStatus;
    }
	
	public void setStatus(ParkingSlotStatus status) {
		parkingSlotStatus=status;
		notifyObserver();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer:observers) {
			observer.update(this);
		}
	}

}
