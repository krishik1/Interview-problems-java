package java8;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 1, 9, 16, 8, 7, 6, 9, 2 };
		System.out.println("Before Sort:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("After Sort:");
		// insertionSort(arr);
		//selectionSort(arr);
		int n = arr.length;
		//quickSort(arr, 0, n-1);
		bubblesort(arr,n);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	//bubble sort
	private static void bubblesort(int[] arr,int n) {
		for(int i=0;i<n-1;i++) {
			int flag=0;
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=1;
				}
			}
			if(flag==0) {
				break;
			}
		}
	}

	// selection sort
	private static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
		
			if (min != i) {
				int smallerNumber = arr[min];
				arr[min] = arr[i];
				arr[i] = smallerNumber;
			}
		}
	}

	// insertion sort
	private static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int min = arr[i];
			int j = i - 1;
			while (j > -1 && arr[j] < arr[min]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = min;
		}
	}
	
	//quicksort
	private static void quickSort(int[] arr,int low,int up) {
		if(low<up) {
		int pos=partition(arr, low, up);
		quickSort(arr, low, pos-1);
		quickSort(arr, pos+1, up);
		}
	}
	
	private static int partition(int[] arr,int low,int up) {
		int start=low,end=up;
		int pivot=arr[low];
		while(start<end) {
			while(arr[start]<=pivot) {
				start++;
			}
			while(arr[end]>pivot) {
				end--;
			}
			if(start<end) {
				int temp=arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
			}
		}
		int temp=arr[low];
		arr[low]=arr[end];
		arr[end]=temp;
		return end;
	}

}
