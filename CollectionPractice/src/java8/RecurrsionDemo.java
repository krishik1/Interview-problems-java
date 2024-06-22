package java8;

import java.util.ArrayList;
import java.util.Scanner;

public class RecurrsionDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();
//		int ans=fibinocci(n);
//		System.out.println("Nth fibinocci number is: "+ans);
		int[] arr = {12,14,18,20,18,22};
//		int bs=binarySearch(arr,0,arr.length-1,n);
//		System.out.println("pos of the input is : "+bs);
		funcBoth(5);
		// int n=factorial(5);
		// int n = sumOfDigits(1234);
		boolean flag =sorted(arr,0);
		System.err.println("Sorted ?"+flag);
		int n = reverse(2958);
		int x = count0(30104000);
		//lenear search
		int k=18;
		boolean flag1=linearSearch(arr,k,0);
		System.out.println("linear Search : "+flag1);
		int y=countSteps(20);
		System.out.println("y :"+y);
		System.out.println("x : "+x);
		System.out.println("n:" + n);
		System.out.println("SearchList :"+linearSearchIndex(arr,k,0,new ArrayList<Integer>()));
		System.out.println(linearSearchIndexWithoutArg(arr, k, 0));
	}

	private static ArrayList<Integer> linearSearchIndex(int[] arr, int k, int i, ArrayList<Integer> arrayList) {
		if(i==arr.length-1) {
			return arrayList;
		}
		if(arr[i]==k) {
			arrayList.add(i);
		}
		return linearSearchIndex(arr, k, i+1, arrayList);
	}

	//without passing list as argument
	private static ArrayList<Integer> linearSearchIndexWithoutArg(int[] arr, int k, int i) {
		ArrayList<Integer> list = new ArrayList<>();
		if(i==arr.length) {
			return list;
		}
		if(arr[i]==k) {
			list.add(i);
		}
		ArrayList<Integer> recurrList = linearSearchIndexWithoutArg(arr, k, i+1);
		list.addAll(recurrList);
		return list;
	}

	private static boolean linearSearch(int[] arr, int k, int i) {
		if(i==arr.length-1) {
			return false;
		}
		return arr[i]==k || linearSearch(arr, k, i+1);
	}

	private static boolean sorted(int[] arr, int i) {
		if(i==arr.length-1) {
			return true;
		}
		return arr[i]<arr[i+1] && sorted(arr, i+1);
	}

	private static int countSteps(int n) {
		int c=0;
		return helperSteps(n,c);
	}

	private static int helperSteps(int n, int c) {
		if(n==0) {
			return c;
		}
		if(n%2==0) {
			
			return helperSteps(n/2,c+1);
		} 
			return helperSteps(n-1,c+1);
		
	}

	private static int count0(int n) {
		int c =0;
		
		return helperCount(n,c);
	}

	private static int helperCount(int n, int c) {
		if(n%10==n) {
			return c;
		}
		if(n%10==0) {
			c++;
		}
		return helperCount(n/10, c);
	}

	private static int reverse(int n) {
		int c = (int) Math.log10(n);
		return logic(n, c);
	}

	private static int logic(int n, int c) {
		if (n % 10 == n) {
			return n;
		}
		int rem = n % 10;
		return rem * (int) Math.pow(10, c) + logic(n / 10, c - 1);
	}

	private static int helper(int n) {
		int c = 0;
		if (n == 0) {
			return 0;
		}
		n = n / 10;
		c++;
		return c;
	}

	private static int sumOfDigits(int n) {
		if (n <= 0) {
			return 0;
		}
		return n % 10 + sumOfDigits(n / 10);
	}

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}

	private static void funcBoth(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		funcBoth(n - 1);
		System.out.println(n);

	}

	private static int binarySearch(int[] arr, int s, int e, int n) {
		int mid = s + e / 2;
		if (s > e) {
			return -1;
		}
		if (arr[mid] == n) {
			return mid;
		}
		if (arr[mid] > n) {
			return binarySearch(arr, s, mid - 1, n);
		}

		return binarySearch(arr, mid + 1, e, n);
	}

	private static int fibinocci(int n) {
		if (n == 0) {
			return n;
		}
		if (n == 1) {
			return n;
		}

		return fibinocci(n - 1) + fibinocci(n - 2);
	}

}
