package MultipleInheritence;

public class Client {

	public static void main(String[] args) {
		//Hippo animal = new Hippo();
		//Dog animal = new Dog();
		//Fish animal=new Fish();
		String x = "leet";
		
		
		Hippo animal =new Hippo();
		x=animal.concat(x);
		System.out.println("x is : "+x);
		animal.lives();
		animal.type();
		animal.print();
	}
}
