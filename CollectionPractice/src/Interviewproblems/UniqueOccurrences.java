package Interviewproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 * */
public class UniqueOccurrences {
	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,3};
		System.out.println("res : "+uniqueOccurrences(arr));
	}

	public static boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for (int val : arr) {
			hm.put(val, hm.getOrDefault(val, 0) + 1);
		}
		
		for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			Integer value = entry.getValue();
			if(!set.contains(value)) {
				set.add(value);
			} else { 
				return false;
			}
		}
		
		return true;
	}
}
