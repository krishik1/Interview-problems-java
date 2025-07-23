package Interviewproblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsOfaString {

	public static void main(String[] args) {
		String str = "the sky is blue";
		String res = reverseWords(str);
		System.out.println("res : "+res);
	}
	
	public static String reverseWords(String s) {
		List<String> words = Arrays.stream(s.trim().split("\\s+")).collect(Collectors.toList());
		Collections.reverse(words);
		return words.stream().collect(Collectors.joining(" "));
    }
}
