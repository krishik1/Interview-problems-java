package MultipleInheritence;

public interface Animal {
	
	public void type();
	
	default void print() {
		System.out.println("I am an animal lover.");
	}
}
