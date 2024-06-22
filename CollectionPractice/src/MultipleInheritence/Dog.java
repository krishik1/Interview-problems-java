package MultipleInheritence;

public class Dog implements LandAnimal,Animal {

	@Override
	public void lives() {
		System.out.println("Dog lives in land.");
	}

	@Override
	public void type() {
		System.out.println("Dog is a pet animal.");
	}

	@Override
	public void print() {
		Animal.super.print();
		LandAnimal.super.print();
	}

	

}
