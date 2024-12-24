package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstRepeatingCharacter {
	public static void main(String[] args) {
		String str = "gopalal";
		String repChar = Arrays.stream(str.split("")).filter(x->str.indexOf(x)!=str.lastIndexOf(x)).findFirst().get();
		Map<Object, Long> freqMAp = str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()));
		
		String res = freqMAp.entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).findFirst().map(String::valueOf).orElse(null);
		System.out.println(repChar);
		System.out.println("res : "+res);
		 
	}

}
