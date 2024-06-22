package java8;

import java.util.ArrayList;
import java.util.List;

public class MethodRefExampl2 {
	public static void main(String[] args) {
		staticMethodReference();
		instanceMethodWithObjectReference();
		instatnceMethodWithClassReference();
		constructorReference();
		
	}

	private static void constructorReference() {

		productInterface pi = Product :: new;
		Product product = pi.getProduct("OnePlus",30000);
		System.out.println(product.pname);
		System.out.println(product.pprice);
	}
	

	private static void instatnceMethodWithClassReference() {

		List<String> friends = new ArrayList<>();
		friends.add("jaga");
		friends.add("krishik");
		friends.add("adhi");
		friends.add("chidvi");
		friends.add("santosh");
		friends.forEach(System.out :: println);
	}

	private static void instanceMethodWithObjectReference() {
		MethodRefExampl2 reference = new MethodRefExampl2();
		ArthimaticAddition operation = reference :: addition;
		operation.performOperation(72, 28);
	}
	public  int addition(int a,int b) {
		int sum = a+b;
		System.out.println("ADD is :"+sum);
		return sum;
	}

	private static void staticMethodReference() {
		/*
		 * ArthimaticAddition operation = (a,b) -> { int sum = a+b;
		 * System.out.println("Addition is :"+sum); return sum; };
		 */
		ArthimaticAddition operation = MethodRefExampl2 :: summation;
		operation.performOperation(4, 5);
	}
	public static int summation(int a,int b) {
		int sum = a+b;
		System.out.println("Sum is :"+sum);
		return sum;
	}

}
