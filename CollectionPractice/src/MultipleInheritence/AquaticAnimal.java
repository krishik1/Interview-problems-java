package MultipleInheritence;

public interface AquaticAnimal {

	public void lives();
	default void print() {
		System.out.println("I am an aquatic animal lover.");
	}

}
