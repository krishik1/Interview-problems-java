package Interviewproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

*/

public class FindCloseStrings {

	public static void main(String[] args) {
		String str1 = "cabbba", st2 = "abbccc";
		System.out.println("res is : " + closeStrings1(str1, st2));
	}

	/*Both closeStrings and closeStrings1 of TC:o(n) and SC:o(n) but closeStrings is more optimal solution. */
	public static boolean closeStrings(String word1, String word2) {
		if (word1.equals(word2))
			return true;
		if (word1.length() != word2.length()) {
			return false;
		}
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		for (int i = 0; i < word1.length(); i++) {
			freq1[word1.charAt(i) - 'a']++;
			freq2[word2.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
				return false;
			}
		}
		Arrays.sort(freq1);
		Arrays.sort(freq2);

		for (int i = 0; i < 26; i++) {
			if (freq1[i] != freq2[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean closeStrings1(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}

		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();
		HashMap<Integer, Integer> cnt1 = new HashMap<>();
		HashMap<Integer, Integer> cnt2 = new HashMap<>();
		for (int i = 0; i < word1.length(); i++) {
			hm1.put(word1.charAt(i), hm1.getOrDefault(word1.charAt(i), 0) + 1);
			hm2.put(word2.charAt(i), hm2.getOrDefault(word2.charAt(i), 0) + 1);
		}
		for (int i = 0; i < word1.length(); i++) {
			if (!hm1.containsKey(word2.charAt(i)) || !hm2.containsKey(word1.charAt(i))) {
				return false;
			}
		}

		for (Map.Entry<Character, Integer> entry : hm1.entrySet()) {
			int val = entry.getValue();
			cnt1.put(val, cnt1.getOrDefault(val, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : hm2.entrySet()) {
			int val = entry.getValue();
			cnt2.put(val, cnt2.getOrDefault(val, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : cnt1.entrySet()) {
			int key = entry.getKey();
			if (cnt1.get(key) != cnt2.get(key)) {
				return false;
			}
		}

		return true;
	}

}
