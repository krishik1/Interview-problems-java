package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCount {
	 public static void main(String[] args) {
		 List<Integer> list = Arrays.asList(22,14,10,36,32,16,17,22,22,48,36,14,14,22);
		   Map<Integer, Integer> freq = list.stream().filter(e -> Collections.frequency(list, e)>1).collect(Collectors
				  .toMap(e->e,e->Collections.frequency(list, e),
						  (existing, replacement) -> existing));
		 System.out.println(freq);
		 
		 List<String> stringList = Arrays.asList(
				    "apple", "banana", "apple", "orange", 
				    "banana", "grape", "kiwi", "orange", 
				    "kiwi", "mango"
				);
		   Map<String, Integer> fruitFreq = stringList.stream().filter(e -> Collections.frequency(stringList, e)>1)
		 .collect(Collectors.toMap(e->e, e->Collections.frequency(stringList, e),
				 (x,y)->x));
		   System.out.println(fruitFreq);
	}
}
