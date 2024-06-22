package sorting;

import java.util.ArrayList;

public class Solution1 {

	public static void main(String[] args) {
//		int[] arr= {-2,3,-1,-4,-2};
		int[] arr = { -1, 2, 3, -2,-4, -5 };
		int sum = cards(arr);
		// subsets(arr);
		System.out.println("sum: " + sum);
	}

	private static int cards(int[] A) {
// 		int n=arr.length,min=Integer.MAX_VALUE,temp=0,sum=0,k=0;
//		for(int i=0;i<n;i++) {
//			if(arr[i]<0) {
//				k+=arr[i];
//				temp+=arr[i];
//				min=Math.min(min, temp);
//			} else {
//				sum+=arr[i];
//				temp=0;
//			}
//		}
//		k=k-min;
//		return sum-min+k;
		ArrayList<Integer> old_contributed_elements = new ArrayList<Integer>(); // to add indexes

		int maxContributionSumSofar = 0;
		int contribution = 0,posContribution=0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0) {
				int partialContribution = Math.abs(A[i]);
				contribution += partialContribution;

				if (contribution > maxContributionSumSofar) {
					maxContributionSumSofar = contribution;
					
				}
			}

			else {

				contribution = 0;
				posContribution+=A[i];
			}
			
		}
		
		

		return maxContributionSumSofar+posContribution;
	}

//	public static List<List<Integer>> subsets(int[] nums) {
//		List<List<Integer>> ll = new ArrayList<>();
//		subsets(nums, new ArrayList<>(), 0,ll);
//		return ll;
//	}
//
//	public static void subsets(int[] nums, List<Integer> l, int idx,List<List<Integer>> ll) {
//		ll.add(new ArrayList<>(l));
//		for (int i = idx; i < nums.length; i++) {
//			l.add(nums[i]);
//			subsets(nums, l, i + 1,ll);
//			l.remove(l.size() - 1);
//		}
//	}

}
