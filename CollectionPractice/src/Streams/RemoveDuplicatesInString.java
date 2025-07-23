package Streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesInString {
	public static void main(String[] args) {
		String str = "rain rain go away rain ";
		System.out.println(removeDuplicates1(str));
	}
	public static String removeDuplicates(String str) {
		return Arrays.stream(str.split("\\s+")).distinct().collect(Collectors.joining(" "));
	}

	public static String removeDuplicates1(String str) {
		Set<String> set = new HashSet();
		return Arrays.stream(str.split("\\s+")).filter(set::add).collect(Collectors.joining(" "));
	}
}
