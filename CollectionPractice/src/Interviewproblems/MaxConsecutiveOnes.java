package Interviewproblems;
/*
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * */
public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0}; 
		System.out.println("res : "+longestOnes(nums, 2));
	}
	
	public static int longestOnes(int[] nums, int k) {
		int n=nums.length,i=0,j=0,max=0,zeros=0;
		while(j<n) {
			if(nums[j]==0) {
				zeros++;
			}
			if(zeros>k) {
				if(nums[i]==0) {
					zeros--;
				}
				i++;
			}
			max=Math.max(max, j-i+1);
			j++;
		}
		return max;
	}

}
