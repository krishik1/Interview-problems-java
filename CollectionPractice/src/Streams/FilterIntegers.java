package Streams;

import java.util.List;
import java.util.stream.Collectors;

public class FilterIntegers {
	public static void main(String[] args) {
		List<String> strList = List.of("abc","123","143","jka","777","980","uak");
		List<String> res = strList.stream()
			    .filter(s -> Character.isDigit(s.charAt(0)))
			    .collect(Collectors.toList());
		 
		for(String val:res) {
			System.out.println(val+" ");
		}
	}

}
