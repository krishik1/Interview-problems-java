package Inheritence;

public class Client {

	public static void main(String[] a) {
		Animal animal = new Animal();
		Dog dog = new Dog();
		System.out.println(animal instanceof Dog);
		System.out.println(dog instanceof Animal);
	}
}
