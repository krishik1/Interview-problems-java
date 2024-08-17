package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfNums {
	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(22, 21, 31, 15, 17, 16);
//		System.out.println(findSum(list));
//		System.out.println(findMax(list));
		
		//Using Aggregate Functions
		int[] arr = {22, 21, 31, 15, 17, 16};
		System.out.println(Arrays.stream(arr).sum());
		System.out.println(Arrays.stream(arr).max().orElseThrow());
	}

	public static int findSum(List<Integer> list) {
		/*Optional<Integer> res = list.stream().reduce((a,b)->a+b);
		 * return res.get();
		 * */
		 
		int res = list.stream().reduce(0, (sum, ele) -> sum + ele);
		return res;
	}
	public static int findMax(List<Integer> list) {
		int res = list.stream().reduce(Integer.MIN_VALUE,(max,ele) -> Math.max(max, ele));
		return res;
	}
	
	public static int mapToIntegerSum(List<Integer> list) {
		
		return list.stream().mapToInt(Integer::intValue).sum();
	}
	
	
	
	
}
