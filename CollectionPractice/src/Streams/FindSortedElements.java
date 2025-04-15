package Streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindSortedElements {
	public static void main(String[] args) {
		String str = "abjjhdiabaca";
		Map<Object, Long> map = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		map.forEach((k, v) -> {
			if (v == 1) {
				System.out.print(k + "");
			}
		});
	}

}
