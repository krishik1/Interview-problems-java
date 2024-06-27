package Interviewproblems;

import java.util.Arrays;
import java.util.HashMap;
/*
 * You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.
*/
public class MaxNumberOfKSubPairs {

	public static void main(String[] args) {
		int[] arr = {3,1,3,4,3};
		System.out.println("res : "+maxOperations(arr, 6));
	}
	
	/** TC : O(n),SC : O(n) **/
	public static int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int c = 0;
        for(int val : nums) {
            int diff = k-val;
            if(hm.containsKey(diff)) {
                c++;
                if(hm.get(diff)==1){
                    hm.remove(diff);
                } else {
                    hm.put(diff,hm.get(diff)-1);
                }
            } else {
                hm.put(val,hm.getOrDefault(val,0)+1);
            }
        }
        return c;
    }
	
	/** TC : O(n*logn),SC : O(1) **/
	public static int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1,c=0;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum == k) {
                c++;
                i++;j--;
            } else if(sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return c;
    }
	
}
