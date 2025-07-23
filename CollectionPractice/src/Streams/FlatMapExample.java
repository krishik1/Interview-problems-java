package Streams;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
	public static void main(String[] args) {
		List<List<Integer>> dig = Arrays.asList(
	            Arrays.asList(1, 2, 3),
	            Arrays.asList(4, 5, 6),
	            Arrays.asList(7, 8, 9)
	        );
		
		//Integer sum = dig.stream().flatMap(List::stream).reduce(0,Integer::sum);
		Integer sum1 = dig.stream().flatMap(List::stream).reduce(0, (val,sum)->sum+val);
		System.out.println(sum1);
		
	}
}
