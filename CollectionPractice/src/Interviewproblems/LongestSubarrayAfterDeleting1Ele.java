package Interviewproblems;

public class LongestSubarrayAfterDeleting1Ele {
	public static void main(String[] args) {
		int[] nums = {0,1,1,1,0,1,1,0,1};
		System.out.println("res : "+longestSubarray(nums));
	}
	
	public static int longestSubarray(int[] nums) {
        int i=0,j=0,n=nums.length,zeros=0,max=0;
        while(j<n){
            if(nums[j]==0){
                zeros++;
            }
            if(zeros>1){
                if(nums[i]==0){
                    zeros--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max>0?max-1:0;

    }
}
