package MultipleInheritence;

public class Fish implements AquaticAnimal,Animal{

	@Override
	public void lives() {
		System.out.println("Fish lives in water.");
	}

	@Override
	public void type() {
		System.out.println("Fish is a Aquatic animal");
	}

	@Override
	public void print() {
		Animal.super.print();
		AquaticAnimal.super.print();
	}
	
	
}
