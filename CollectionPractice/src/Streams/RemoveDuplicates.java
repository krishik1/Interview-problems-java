package Streams;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		String input = "Raju is a an SDE. Raju lives in Vsp.";
		System.out.println("Res is : "+getRes(input));
		List<Integer> list = Arrays.asList(10,12,9,6,9,12,19,20);
		List<Integer> res = getNumList(list);
		res.forEach(System.out::println);
		
	}
	public static String getRes(String input) {
		Set<String> set = new LinkedHashSet();
		return Arrays.stream(input.split("\\s+")).filter(set::add).collect(Collectors.joining(" "));
		
	}
	
	public static String getRes1(String input) {
		return Arrays.stream(input.split("\\s+")).distinct().collect(Collectors.joining(" "));
		
	}
	
	public static List<Integer> getNumList(List<Integer> list){
		return list.stream().distinct().collect(Collectors.toList());
	}

}
