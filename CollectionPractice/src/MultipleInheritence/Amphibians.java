package MultipleInheritence;

public interface Amphibians {
	
	public void lives();
	
	default void print() {
		System.out.println("I am an Wild animal lover.");
	}

}
