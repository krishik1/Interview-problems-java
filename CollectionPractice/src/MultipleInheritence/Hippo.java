package MultipleInheritence;

public class Hippo implements Animal, LandAnimal, AquaticAnimal,Amphibians {

	@Override
	public void lives() {
		System.out.println("Hippo can live in both land and water.");
	}

	@Override
	public void type() {
		System.out.println("Hippo is an Wild Animal.");
	}

	@Override
	public void print() {
		Animal.super.print();
		Amphibians.super.print();
	}
	
	public String concat(String x) {
		x+="code";
		return x;
	}

}
