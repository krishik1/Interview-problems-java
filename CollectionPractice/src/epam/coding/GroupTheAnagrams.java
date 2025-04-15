package epam.coding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupTheAnagrams {
	public static void main(String[] args) {
		List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
		/**
		 * HashMap<String, List<String>> resMap = new HashMap<String, List<String>>();
		 * for(String val:input) { String sortedStr = sortChar(val);
		 * if(!resMap.containsKey(sortedStr)) { List<String> list = new
		 * ArrayList<String>(); list.add(val); resMap.put(sortedStr, list); } else {
		 * resMap.get(sortedStr).add(val); } } for(String str:resMap.keySet()) {
		 * System.out.print(str+" : "); for(String val:resMap.get(str)) {
		 * System.out.print(val+" "); } System.out.println(); }
		 **/

		// Using Java 8
		// input.stream().collect(Collectors.groupingBy(GroupTheAnagrams::sortChar));
		Map<String, List<String>> resMap = input.stream().collect(Collectors.groupingBy(str -> sortChar(str)));
		resMap.forEach((k,v)-> {
			System.out.print(k+" : ");
			v.forEach(val->System.out.print(val+" "));
			System.out.println();
		});
	}

	private static String sortChar(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
