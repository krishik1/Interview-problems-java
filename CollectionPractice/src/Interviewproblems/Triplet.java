package Interviewproblems;

public class Triplet {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 0, 4, 6 };
		System.out.println("res is : " + increasingTriplet(arr));
	}

	public static boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE, sec = Integer.MAX_VALUE;
		for (int val : nums) {
			if (val <= first) {
				// storing least element
				first = val;
			} else if (val <= sec) {
				// storing second least element
				sec = val;
			} else {
				return true;
			}
		}
		return false;
	}

}
