package fi;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FuctionalInterfaceExample {
	public static void main(String[] args) {
		//Function
		Function<Integer, String> intToString = (i) -> "Number: " + i;
		System.out.println(intToString.apply(5)); 	 
		//BiFunction
		BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
		System.out.println(sum.apply(3, 7));  // Output: 10
		//Predicate
		Predicate<String> isEmpty = (s) -> s.isEmpty();
		System.out.println(isEmpty.test(""));  // Output: true
		System.out.println(isEmpty.test("hello"));  // Output: false
		//Bi-Predicate
		BiPredicate<String, Integer> checkLength = (s, len) -> s.length() == len;
		System.out.println(checkLength.test("hello", 5));  // Output: true
		//Consumer
		Consumer<String> print = (s) -> System.out.println(s);
		print.accept("Hello, World!");  // Output: "Hello, World!"
		//BiConsumer
		BiConsumer<String, Integer> printDetails = (name, age) -> 
	    System.out.println(name + " is " + age + " years old.");
	    printDetails.accept("Alice", 30);  // Output: "Alice is 30 years old."
	    //UnaryOperator
	    UnaryOperator<Integer> square = (x) -> x * x;
	    System.out.println(square.apply(5));  // Output: 25
	    //BinaryOperator
	    BinaryOperator<Integer> multiply = (a, b) -> a * b;
	    System.out.println(multiply.apply(3, 4));  // Output: 12
	    //Comparator
	    Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
	    int result = comparator.compare(3, 5);  // Output: -1

	    
	    

	}
}
