package java8;

class ClassNameHere {

	
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static int inversionCount(int arr[], int N)
    {
            return sort(arr, 0, N - 1);
    }
	// Driver code
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given array is");
		printArray(arr);
		//ClassNameHere obj = new ClassNameHere();
		//ClassNameHere.sort(arr, 0, arr.length-1);
		//ClassNameHere.inversionCount(arr, arr.length-1);
		System.out.println("\nSorted array is:"+ClassNameHere.inversionCount(arr, arr.length-1));
		//printArray(arr);
	}

	 static int sort(int[] arr, int l, int r) {
		 int c=0;
		while(l<r) {
			int mid=(l+(r-l))/2;
			c+=sort(arr,l,mid);
			c+=sort(arr,mid+1,r);
			c+=mergeSort(arr,l,mid,r);
		}
		return c;
		
	}

	static int mergeSort(int[] arr, int l, int mid, int r) {
		int[] arr1=new int[r-l+1];
		int temp=0,i=l,j=mid+1;
		int count=0;
		while(i<mid && j<r) {
			if(arr[i]<=arr[j]) {
				arr1[temp++]=arr[j++];
			} else {
				arr1[temp++]=arr[i++];
				count+=mid-i+1;
			}
		}
		while(l<mid) {
			arr1[temp++]=arr[i++];
		}
		while(j<r) {
			arr1[temp++]=arr[j++];
		}
		return count;
		
		
	}
}