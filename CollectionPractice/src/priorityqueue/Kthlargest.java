package priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Kthlargest {
	public static void main(String[] args) {
		Integer[] arr= {10,10,20,12,9,22,6,6,6,8,25,44,4,4,4,4,4};
		int k=6;
		System.out.println("Kth largest element is : "+kthLargest(arr, k));
		sortEle(arr);
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}
	public static int kthLargest(Integer[] arr,  int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		int c=1;
		while(c!=k) {
			pq.poll();
			c++;
		}
		return pq.peek();
	}
	public static void sortEle(Integer[] arr) {
		Arrays.sort(arr,Collections.reverseOrder());
	}
}
