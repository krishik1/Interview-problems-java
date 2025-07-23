package java8;

import java.util.ArrayList;
import java.util.List;

/**MethodReference : Method References are a special type of lamda expressions which are often used to create
 * simple lamda expressions by referencing existing methods.
 * 2.There are 4 types of method references introduced in java 8.
 * ->Static Method Reference(Class :: staticMethod)
 * ->Reference to instance method from instance(objRef::instanceMethod)
 * ->Reference to instance method from class type(class :: instanceMethod)
 * ->Constructor Reference(Class :: new)**/
public class MethodRefExmple {

	public static void main(String[] args) {
		ArthematicOperation operation = (a,b) -> {int sum = a+b;
		System.out.println("Sum is :"+sum);
		return sum;
		};
		operation.performOperation(10, 15);
		/**ArthematicOperation metRef = MethodRefExmple :: summationVal;(Static Method Ref)
		 * metRef.performOperation(30, 50);;
		 **/
		MethodRefExmple methodRefExmple = new MethodRefExmple();
		ArthematicOperation metRef = methodRefExmple :: summationVal;//(object reference)
		metRef.performOperation(30, 50);
		//class refewrence
		List<String> lis = new ArrayList<>();
		lis.add("TCS");
		lis.add("IBM");
		lis.add("Infosys");
		lis.add("Nagarao");
		lis.add("JP Morgon");
		//lis.forEach(i -> System.out.println(i));
		lis.forEach(System.out :: println);
		//productInterface prod = (name,price) -> new Product(name, price);
		productInterface prod = Product :: new;
		Product product = prod.getProduct("Samsung", 10500);
		System.out.println("Mobile Name : "+product.pname);
		System.out.println("Price is : "+product.pprice);
	}
	/**
	public static  int summationVal(int a,int b) {
		int sum = a+b;
		System.out.println("The Sum of method is : "+sum);
		return sum;
	}**/
	public  int summationVal(int a,int b) {
		int sum = a+b;
		System.out.println("The Sum of method is : "+sum);
		return sum;
	}
	
}
