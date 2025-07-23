package Interviewproblems;
/*
 * Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.*/
public class PivotIndex {
	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		System.out.println("res is : "+pivotIndex2(nums));
	}

	/*TC:O(n),SC:O(n)*/
	public static int pivotIndex1(int[] nums) {
        int[] pf = new int[nums.length];
        pf[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pf[i]=pf[i-1]+nums[i];
        } 
        int sum=pf[nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(sum==pf[i]){
                return i;
            }
            sum-=nums[i];
        }
        return -1;
    }
	
	/*TC:O(n),SC:O(1)*/
	public static int pivotIndex2(int[] nums) {
        int right=0,left=0;
        for(int val:nums){
            right+=val;
        }
        for(int i=0;i<nums.length;i++){
            right-=nums[i];
            if(right==left){
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }
}
