package java8;

public class Equillibrim {
	public static void main(String arg[]) {

		 int[] A = {13,7,16,18,14,17,18,8,10};
		 //int[] A = { 4, 4, 4 };
//		int[] sortedArray = sort(A);
//		for(int val:sortedArray) {
//			System.out.print(val+" ");
//		}
		System.out.println();
		int secondLargest = findSecondLargestNo(A);
		System.out.println(secondLargest);
	}

	private static int[] sort(int[] A) {
		int temp;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] < A[j]) {
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
		return A;
	}

	//if  you are using the below condition i.eA[i] != max then how it will work for int[] A = { 4, 4, 4 }
	private static int findSecondLargestNo(int[] A) {
		 int largest = Integer.MIN_VALUE;
	        int secondLargest = Integer.MIN_VALUE;
	        
	        // Traverse the array and update the largest and second-largest values
	        for (int i = 0; i < A.length; i++) {
	            if (A[i] > largest) {
	                secondLargest = largest;
	                largest = A[i];
	            } 
	            else if (A[i] > secondLargest && A[i] != largest) {
	                secondLargest = A[i];
	            }
	        }
	        
	        // If no second-largest element was found, return null
	        if (secondLargest == Integer.MIN_VALUE) {
	            return -1;
	        } else {
	            return secondLargest;
	        }


	}

}
