package Streams;

import java.security.Identity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		String input = "Raju is a an SDE. Raju lives in Vsp.";
		System.out.println("Res is : "+getRes(input));
		List<Integer> list = Arrays.asList(10,12,9,6,9,12,19,20);
		//List<Integer> res = getNumList(list);
		List<Integer> res = fun(list);
		res.forEach(System.out::println);
		String str = "katrinakaif";
        System.out.println(fun1(str));
        String s ="My name is Raju. My qualification is B-TECh. My hometown is visakhapatnam.My name is Raju. My qualification is B-TECh. I have over 3 years of experience.";
		String[] words = s.split("\\s+");
		List<String> w = Arrays.asList(words);
		Map<String, Long> hm=  w.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		for (Map.Entry<String, Long> fre : hm.entrySet()) {
		    System.out.println(fre.getKey() + " " + fre.getValue());
		}
		
		char[] chars = str.toCharArray();
		List<Character> chList = new ArrayList<>(); 
		for(char ch : chars) {
			chList.add(ch);
		}
		Map<Character, Long> map = chList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		String s1 =chList.stream().filter(i->map.get(i)==1).map(String::valueOf).collect(Collectors.joining(""));
		System.out.println(s1);
		


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
	
	public static List<Integer> removeListEleWhichIsRepeated(List<Integer> list) {
		 Map<Integer, Long> res = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 List<Integer> ans = list.stream().filter(i -> res.get(i)==1).collect(Collectors.toList());
		return ans;
	}
	
	public static List<Integer> fun(List<Integer> list) {
        Map<Integer,Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> res = list.stream().filter(val -> map.get(val)==1).collect(Collectors.toList());
        return res;
    }
	
	public static String fun1(String str) {
        Map<Character,Long>map = str.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String res = str.chars().mapToObj(i->(char)i).filter(i->map.get(i)==1).map(String::valueOf).collect(Collectors.joining(""));
        return res;
        
    }
	
	
}
