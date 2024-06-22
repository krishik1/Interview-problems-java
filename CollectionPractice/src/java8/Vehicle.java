package java8;

public interface Vehicle {

	public int getSpeed();
	public void applyBreak();
	public default void autoPilot() {
		System.out.println("Honda Auto Pilot Apllied.");
	}
	public static void getMilage() {
		System.out.println("70kmph");
	}
	
	//from java8 we can write static methods and deafault methods inside interface.
	public static void main(String[] args) {
		Vehicle.getMilage();
	}
}
