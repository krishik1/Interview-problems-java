package Behaviour.strategy.design.pattern;

public class GoogleMapFactory {
	public static PathCalculater getMode(String mode) {
		PathCalculater pathCalculater = null;
		if(mode.equalsIgnoreCase("car")) {
			pathCalculater = new CarPathCalculator();
		} else if(mode.equalsIgnoreCase("Bike")) {
			pathCalculater = new BikePathCalculator();
		} else if(mode.equalsIgnoreCase("walk")) {
			pathCalculater = new WalkPathCalculator();
		} else {
			System.out.println("please choose corrct option .");
			pathCalculater = null;
		}
		return pathCalculater;
	}
}
