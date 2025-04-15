package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstRepeatingCharacter {
	public static void main(String[] args) {
		String str = "gopalal";
		String repChar = Arrays.stream(str.split("")).filter(x->str.indexOf(x)!=str.lastIndexOf(x)).findFirst().get();
		Map<Object, Long> freqMAp = str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()));
		
		String res = freqMAp.entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).findFirst().map(String::valueOf).orElse(null);
		System.out.println(repChar);
		System.out.println("res : "+res);
		
		List<Integer> list = Arrays.asList(1,3,13,4,76,19,16,20);
		Optional<Double> resList = list.stream().map(i->i*i*1.0).filter(j->j>100).max((a,b)->Double.compare(b, a));
		System.out.println(resList.get());
		
		//resList.forEach(val->System.out.print(val+" , "));
		 
	}

}
