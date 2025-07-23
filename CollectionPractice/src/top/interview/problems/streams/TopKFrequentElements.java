package top.interview.problems.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
	public static void main(String[] args) {
		String s = "fhjhfgudh";
		Map<Character, Long> freqMap = s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		freqMap.forEach((k,v)->System.out.println(k+" "+v));
		String str = s.chars().mapToObj(c->(char) c).filter(ch -> freqMap.get(ch)==1L).map(String::valueOf).collect(Collectors.joining());
		System.out.println(str);
	}

}
