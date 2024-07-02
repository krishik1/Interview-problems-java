package Interviewproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
*/
public class FindDifference {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3};
		int[] nums2 = {2,4,6};
		List<List<Integer>> res = findDifference(nums1, nums2);
		
		for(List<Integer> list : res) {
			for(int val : list) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> res = new ArrayList<>();
		HashSet set1 = new HashSet<>();
		HashSet set2 = new HashSet<>();
		for (int val : nums1) {
			set1.add(val);
		}

		for (int val : nums2) {
			set2.add(val);
		}
		List<Integer> lis1 = new ArrayList<>();
		List<Integer> lis2 = new ArrayList<>();
		for (int val : nums1) {
			if (!set2.contains(val)) {
				lis1.add(val);
				set2.add(val);
			}
		}
		for (int val : nums2) {
			if (!set1.contains(val)) {
				lis2.add(val);
				set1.add(val);
			}
		}
		res.add(lis1);
		res.add(lis2);
		return res;

	}

}
