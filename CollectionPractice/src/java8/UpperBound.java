package java8;

import java.util.Arrays;

public class UpperBound {

	public static void main(String[] args) {
		int[] arr = { 5, 9, 12, 6, 16, 8, 13, 19, 16 };
		int low = 0,high=arr.length-1,ans=-1;
		int x = 16;
		Arrays.sort(arr);
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]>=x) {
				ans=mid;
				high=mid-1;
			} else {
				low=mid+1;
			}
		}
//		int low = 0, high = arr.length - 1, ans = -1;
//		while (low <= high) {
//			int mid = (low + high) / 2;
//			if (arr[mid] > x) {
//				ans = mid;
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println("Ans is: " + ans + " size is :" + arr.length);
	}

}
