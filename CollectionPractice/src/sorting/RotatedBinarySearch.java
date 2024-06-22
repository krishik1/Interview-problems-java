package sorting;

public class RotatedBinarySearch {
	public static void main(String[] args) {
		int[] arr = {19,22,12,13,14,17};
		int key=13;
		System.out.println("Element At Index is : "+rotatedSearch(arr,key,0,arr.length-1));
		System.out.println("Element At Index is : "+rotatedSearchLoops(arr,key,0,arr.length-1));
		System.out.println("Element At Index is : "+rotatedSearchRecurrsion(arr,key,0,arr.length-1));
		
	}

	private static int rotatedSearchRecurrsion(int[] arr, int key, int low, int high) {
		int mid = low+(high-low)/2;
		if(low>high) {
			return -1;
		}
		if(arr[mid]==key) {
			return mid;
		}
		if(arr[low]<=mid) {
			if(arr[low]<=key && key<=arr[mid]) {
				high=mid-1;
			} else {
				low=mid+1;
			}
		} else {
			if(arr[mid]<=key && key<=arr[high]) {
				low=mid+1;
			} else {
				high=mid-1;
			}
		}
		return rotatedSearchRecurrsion(arr, key, low, high);
	}

	private static int rotatedSearchLoops(int[] arr, int key, int low, int high) {
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(arr[mid]==key) {
				return mid;
			}
			if(arr[low]<=arr[mid]) {
				if(arr[low]<=key && key<=arr[mid]) {
					high=mid-1;
				} else {
					low=mid+1;
				}
			} else {
				if(arr[mid]<=key && key<=arr[high]) {
					low=mid+1;
				} else {
					high=mid-1;
					
				}
			}
		}
		
		return -1;
	}

	private static int rotatedSearch(int[] arr, int key, int low, int up) {
		if(low>up) {
			return -1;
		}
		int mid=low+(up-low)/2;
		if(arr[mid]==key) {
			return mid;
		}
		if(arr[mid]>key) {
			return rotatedSearch(arr, key, low, mid-1);
		}
		
		return rotatedSearch(arr, key, mid+1, up);
	}

}
