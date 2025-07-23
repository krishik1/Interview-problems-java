package java8;

import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;

public class PremitiveFIExample {
	public static void main(String[] args) {
		problemwithNormalFunctions();
		predicatePremitiveFunctions();
		functionPremintiveFunctions();
		bifunctionPremitiveFunctions();
		bifunctionPremitiveFunctions();
		bifunctionPremitiveFunctions();
		bifunctionPremitiveFunctions();
		bifunctionPremitiveFunctions();
	}
	private static void bifunctionPremitiveFunctions() {
		// TODO Auto-generated method stub
		
	}
	private static void functionPremintiveFunctions() {
		IntFunction<String> intFunc = i -> Integer.toString(i);
		System.out.println("int func : "+intFunc.apply(10));
		LongFunction<String> longFunc = i -> Long.toString(i);
		System.out.println("Long func :"+longFunc.apply(109));

	}
	private static void predicatePremitiveFunctions() {
		IntPredicate checkInt = i -> i % 2 == 0;
		System.out.println("Int :"+checkInt.test(10));
		DoublePredicate checkDouble = i -> i % 2 == 0;
		System.out.println("Double :"+checkDouble.test(100.0));
		LongPredicate checkLoong = i -> i % 2 == 0;
		System.out.println("Long :"+checkLoong.test(1298023377));
		
	}
	public static void problemwithNormalFunctions() {
		Function<Integer,Integer> doubleTheValue = i -> i*2 ;
		int[] parray = {1,2,3,4,5,6,7,8};
		int[] oparray = new int[parray.length];
		for(int i=0;i<parray.length;i++) {
			oparray[i] = doubleTheValue.apply(parray[i]);
		}
		System.out.println("The ouput of array is : "+Arrays.toString(oparray));
	}

}
