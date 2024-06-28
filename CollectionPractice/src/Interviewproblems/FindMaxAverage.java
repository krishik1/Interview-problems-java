package Interviewproblems;
/*
 * You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*/
public class FindMaxAverage {
	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println("res : "+findMaxAverage(nums, 4));
	}
	public static double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int s=0,e=k,n=nums.length;
        int maxSum=sum;
        while(e<n){
            sum-=nums[s];
            sum+=nums[e];
            maxSum=Math.max(maxSum,sum);
            s++;
            e++;
        }
        return (double)maxSum/k;
    }

}
