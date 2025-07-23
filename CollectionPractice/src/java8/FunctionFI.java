package java8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/** 1.Function is similar to predicate except with a change that instead of boolean it can return data type.
 * 2.it has a single abstract method which is apply(T t)  T->data type
 * 3.it has one static method which is Identity() i.e static <T> Function<T,T> identity()
 * 4.it has two default methods which is compose ,andThen.
 * The Only difference between andThen and compose is that in andThen first function will be Executed followed by second function
 *  whereas in compose vice-versa.**/

/**UnaryOperator<T>
 * 1.This is same as Function FI but if we have scenario where both the input and output parameters data type is same then instead of 
 * Functioon<T,R> We can use UnaryOperator<T>.
 * In other words we can say that UnaryOperator is child of Function where it takes one argument and returns a result of the same type of 
 * its arguments.**/
public class FunctionFI {
	public static void main(String[] args) {
//		Function<String, String> convertStr = i -> i.toUpperCase();
//		System.out.println("The uppercase value of given input is : "+convertStr.apply("Krishik"));
		UnaryOperator<String> convertStr = i -> i.toUpperCase();
		System.out.println("The uppercase value of given input is : "+convertStr.apply("Krishik"));
		//Function<String, String> sameValue = Function.identity();
		UnaryOperator<String> sameValue = UnaryOperator.identity();
		System.out.println("The same value of given input is : "+sameValue.apply("Krishik"));
//		Function<Integer,Integer > multiplyoperation = i -> {
//			System.out.println("Double Operation .");
//			return 2*i;
//		};
//		multiplyoperation = multiplyoperation.compose(i -> {
//			System.out.println("Triple Operation .");
//			return 3*i;
//		});
//		System.out.println("The Multiplication Output is : "+multiplyoperation.apply(26));
		Function<Integer,Integer > multiplyoperation = i -> {
			System.out.println("Tripple Opperation .");
			return 3*i;
		};
		UnaryOperator<Integer> doubleOperation = i -> {
			System.out.println("Double Operation .");
			return 2*i;
		};
		multiplyoperation = multiplyoperation.andThen(doubleOperation);
		
		
		System.out.println("The Multiplication Output is : "+multiplyoperation.apply(26));
		
//		Function<Integer, Integer> divOperation = i -> {
//			System.out.println("Half Operation .");
//			return i/2;
//		};
//		divOperation = divOperation.andThen(i -> {
//			System.out.println("Quater Operation .");
//			return i/4;
//		});
		UnaryOperator<Integer> divOperation = i -> {
			System.out.println("Quater Operation .");
			return i/4;
		};
		Function<Integer, Integer> halfOperation = i -> {
			System.out.println("Half Operation .");
			return i/2;
		};
		
		halfOperation = halfOperation.compose(divOperation);

		System.out.println("The Division Output is :"+divOperation.apply(120));
	}

}
