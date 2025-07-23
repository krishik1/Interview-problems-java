package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
	public static void main(String[] args) {
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8, 9));

//		List<Integer> resList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
//		//int sumation = resList.stream().reduce(0,(sum,val)->{return sum+val;});
//		
//		int maxVal=resList.stream().reduce(Integer.MIN_VALUE,(max,val)->{return Math.max(max,val);});
//		System.out.println(maxVal);
		List<Integer> list = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
		for(int val:list) {
			System.out.print(val+" ");
		}

	}
}
