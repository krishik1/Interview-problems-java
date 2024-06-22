package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		//bubbleSort();
		//selectionSort();
		test();
	}
/**Formulae For Remarrangement of array alternately with space complexity O(1) is :
 * for even - arr[i] = (arr[i]+(arr[max]%me)*me) where me = arr[max]+1;
 *         arr[i]=arr[i]/me;
 * for odd - arr[i] = (arr[i]+(arr[min]%me)*me) where me = arr[max]+1;
 *         arr[i]=arr[i]/me;    **/
	private static void test() {
          long[] arr = {1,4,8,10,15,21};
          int max =arr.length-1;
          int min =0;
          long me=arr[max]+1;
          System.err.println(me);
          for(int i=0;i<arr.length;i++) {
        	  if(i%2==0) {
        		  arr[i] = (arr[i]+(arr[max]%me)*me);
        		 // arr[i] = arr[i]/me;
        		  System.out.print(arr[i]+" ");
        		  max--;
        	  } else {
        		  arr[i] = arr[i]+(arr[min]%me)*me;
        		 // arr[i] = arr[i]/me;
        		  System.out.print(arr[i]+" ");
        		  min++;
        	  }
          }
          System.out.println();
          for(long val: arr) {
        	  val=val/me;
        	  System.out.print(val+" ");
          }
	}

	private static void selectionSort() {
		int[] arr =new int[6];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int min,temp;
		for(int i=0;i<arr.length-1;i++) {
			min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}
			} 
			temp = arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		for(int val:arr) {
			System.out.print(val+" ");
		}
		
	}

	private static void bubbleSort() {



		int[] arr =new int[6];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr.length-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				} 
			}
		}
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}

}
