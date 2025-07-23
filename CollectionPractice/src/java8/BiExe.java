package java8;

import java.util.function.BinaryOperator;

/**
 * As of now we have see the functional interfaces which will accept only one parameter as input
 * but if we have to send 2 prams.To address the same java has Bi functional interfaces.
 * 1.java.util.function.BiPredicate<T,U> - similar to predicate but it can accept 2 input parameters and return a boolean value.
 * 2.java.util.function.Bifunction<T,U,R> - similar to function but it can accept 2 input parameters and return
 * a output as per the data type mentioned.
 * 3.java.util.function.BiConsumer<T,U> - Similar to consumer but it can accept 2 input parameters and 
 * no return value same as consumer.
 * 4.No BiSupplier for supplier functional interface as it not accept abny input parameters.
 * 5.java.util.function.BinaryOperator: it is child of bifunction.we will use this in the scenarios where the 2 input parameters
 * and 1 return parameter data type is same.In addition to the methods that it inherits from bifunction,it also has 2 utility static methods
 * inside it.they both will be used to identify the minimum or maximum of 2 elements based on the comparator logic that we pass.
 * i.e Static<T> BinaryOperator<T> minBy(Comparator<? super T> comparator
 * Static<T> BinaryOperator<T> maxBy(Comparator<? super T> comparator
 * **/
public class BiExe {
	public static void main(String[] args) {
		BinaryOperator<String> convertInput = (a,b) -> (a+b).toUpperCase();
		System.out.println("The Output after Concating is :"+convertInput.apply("krish", "jaga"));
		BinaryOperator<Integer> compareInput = (a,b) -> ((a>b) ? 1 : (a == b) ? 0 : -1);
		BinaryOperator<Integer> compareInput1 = (a,b) -> ((a<b) ? b : (a == b)? 0:-1);
		System.out.println("The Output after Compare is :"+compareInput.apply(17, 17));
		System.out.println("The Output after Compare is :"+compareInput1.apply(11, 17));
	}

}
