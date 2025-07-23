package gap.interview.prep.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortStringByLength {
	public static void main(String[] args) {
		List<String> lis = Arrays.asList("krish","jaga","Adi","Chidvi","santosh");
		List<String> res = lis.parallelStream().sorted((a,b)->a.length()-b.length()).collect(Collectors.toList());
		for(String str : res) {
			System.out.print(str+" ");
		}
		List<Integer> list = Arrays.asList(12,19,22,17,44,11,40);
		Integer maxi = list.stream().sorted((a,b)->b-a).findFirst().get();
		Integer max3 = list.stream().sorted((a,b)->b-a).skip(2).findFirst().get();
		System.out.println("max3 is : "+max3);
		System.out.println(maxi);
		System.out.println();
		List<String> stringList = Arrays.asList("banana", "apple", "pear", "orange","grapes","cherry");
		List<String> sortedString = stringList.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
		for(String str : sortedString) {
			System.out.print(str+" ");
		}
		System.out.println();
		List<String> str = stringList.stream().map(val->val.toUpperCase()).collect(Collectors.toList());
		for(String s:str) {
			System.out.print(s+" ");
		}
	}

}
