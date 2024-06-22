package MultipleInheritence;

public interface LandAnimal {
	
	public void lives();
	
	default void print() {
		System.out.println("I am an pet animal lover.");
	}

}
