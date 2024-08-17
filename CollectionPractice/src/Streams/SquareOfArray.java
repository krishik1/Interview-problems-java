package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfArray {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(22, 21, 31, 15, 17, 16);
		list.stream().map(i->i*i).forEach(System.out::println);
		for(int val : getSquareList(list)) {
			System.out.print(val+" ");
		}
	}
	
	private static List<Integer> getSquareList(List<Integer> list) {
		List<Integer> res = list.stream().map(i->i*i).collect(Collectors.toList());
		return res;
	}
	
}
