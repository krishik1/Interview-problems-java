package temp;

import java.util.LinkedList;
import java.util.Scanner;

public class ExceptionExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("ans : "+divByZero(n));
		int[] x = {12,14,16,13,18};
		LinkedList<Integer> ll = new LinkedList<>();
		//arrayOutOfBound(x);
		oddNumberException(x);
		
	}
	private static void oddNumberException(int[] x) {
        try {
            for (int val : x) {
                if (val % 2 == 1) {  // Check if the number is odd
                    throw new CustomException(400, "Odd Number Exist Exception.");
                }
            }
            System.out.println("All numbers are even.");
        } catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage() + " Code: " + e.getCode());
        }
    }

	public static int divByZero(int x) {
		int ans = 0;
		try {
			ans = x/0;
			
		} catch (ArithmeticException e) {
			System.out.println("Arithmathic Exception Encountered.");
			ans=-1;
		}
		return ans;
	}
	
	public static void arrayOutOfBound(int[] arr) {
		try {
			System.out.println(arr[2]);
		} catch (Exception e) {
			System.out.println("Please Enter Valid Data.");
		}
	}
	
}
