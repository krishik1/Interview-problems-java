package java8;

public class Audi implements Vehicle{

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		int a=1000;
		return a;
	}

	@Override
	public void applyBreak() {
	   System.out.println("Braks Applied");
	}
	@Override
	public void autoPilot() {
		System.out.println("Honda Auto Pilot 2*x Apllied.");
	}
	
	public static void welcome() {
		System.out.println("Welcome to Eclipse");
	}
	public static void getMilage() {
		System.out.println("Honda Milage is 30kmph");
	}
	public static void main(String[] args) {
		Audi audi =new Audi();
		System.out.println(audi.getSpeed());
		audi.applyBreak();
		audi.autoPilot();
		audi.welcome();
		Vehicle.getMilage();
		Audi.getMilage();
	}

}
