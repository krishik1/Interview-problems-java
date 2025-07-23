package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredcateExample {
	
	public static void main(String[] args) {
		Predicate<Integer> isEven = i -> i%2 == 0;
		System.out.println("output of This no is:"+isEven.test(62));
		
		Predicate<Integer> isGreaterThan =i -> i>22;
		System.out.println("output of This method is:"+isEven.or(isGreaterThan).test(22));
		System.out.println("output of This method  is:"+isEven.and(isGreaterThan).test(6));
		System.out.println("output of This method is:"+isEven.and(isGreaterThan).negate().test(41));
		Predicate<String> checkEquality = Predicate.isEqual("Jagadeesh");
		System.out.println("Output Of Equal Is :"+checkEquality.test("Jagadeesh"));
		
		List<Integer> lis = Arrays.asList(1,2,4,6,9,8,3,8);
		List<Integer> evenList = lis.stream().filter(i -> i%2 != 0).collect(Collectors.toList());
		System.out.println("The Even List Is :"+evenList);
	}

}
