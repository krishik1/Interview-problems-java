package java8;

public class SortTest {
	public static void main(String[] args) {
		//int[] arr = { 12, 4, 6, 1, 13, 9, 4 };
		int[] arr = {7 ,10 ,4 ,3 ,20 ,15};
		System.out.println("Before Sorting : ");
		for (int val : arr) {
			System.out.print(val + " ");
		}
		int n = arr.length;
		// slectionSort(arr,n);
		// bubbleSort(arr,n);
		// insertionSort(arr,n);
		 quickSort(arr, 0, n - 1);
		//mergeSort(arr, 0, n - 1);
		System.out.println("Output : "+kthSmallest(arr,0,n-1, 3));
		System.out.println("After Sorting : ");
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			sort(arr, l, mid+1 , r);
		}
	}

	private static void sort(int[] arr, int l, int mid, int r) {
		int i = l, j = mid, k = 0;
		int[] temp = new int[r - l + 1];
		while (i <= mid-1  && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid - 1) {
			temp[k++] = arr[i++];
		}
		while (j <= r) {
			temp[k++] = arr[j++];
		}
		
		System.arraycopy(temp, 0, arr, l, temp.length);
	}

	private static void quickSort(int[] arr, int lb, int ub) {
		if (lb < ub) {
			int loc = partition(arr, lb, ub);
			quickSort(arr, lb, loc - 1);
			quickSort(arr, loc + 1, ub);
		}

	}

	private static int partition(int[] arr, int lb, int ub) {
		int start = lb, end = ub;
		int pivot = arr[lb];
		while (start < end) {
			while (start <= ub && arr[start] <= pivot) {
				start++;
			}
			while (arr[end] > pivot) {
				end--;
				}
			if (start < end) { }
		}
		int temp = arr[lb];
		arr[lb] = arr[end];
		arr[end] = temp;
		return end;
	}

//	private static void insertionSort(int[] arr, int n) {
//		for (int i = 1; i < n; i++) {
//			
//			int key = arr[i];
//			int j = i - 1;
//			while (j > -1 && key < arr[j]) {
//				arr[j + 1] = arr[j];
//				j--;
//			}
//			arr[j + 1] = key;
//		}
//	}

	public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Arrays.sort(arr)
        //int n=arr.length-1;
        quickSort(arr,l,r);
        
        int min=arr[k-1];
        return min;
    } 
	private static void bubbleSort(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int smallerNumber = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = smallerNumber;
					flag = true;
				}
			}
			if (flag == false) {
				break;
			}
		}
	}

	private static void slectionSort(int[] arr, int n) {
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

}
