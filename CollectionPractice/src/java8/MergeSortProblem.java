package java8;

public class MergeSortProblem {
	
	
	static long merge(long[] arr,int l, int r) {
		long count =0;
		if(l<r) {
			int mid=(l+r)/2;
			count+=merge(arr, l, mid);
			count+=merge(arr, mid+1, r);
			count+=sort(arr,mid,l,r);
		}
		return count;
	}
	private static long sort(long[] arr, int mid, int l, int r) {
		int i=l,j=mid+1,k=0;
		long[] temp = new long[r-l+1];
		long count=0;
		while(i<=mid && j<=r) {
			if(arr[i]<=arr[j]) {
				temp[k++]=arr[i++];
			} else {
				temp[k++]=arr[j++];
				count+=mid-i+1;
			}
		}
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		while(j<=r) {
			temp[k++]=arr[j++];
		}
		System.arraycopy(temp, 0, arr, l, temp.length);
		return count;
	}
	public static void main(String[] args) {
		long[] arr = {5,3,2,4,1};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		} 
		long c =merge(arr,0,(int)arr.length-1);
		System.out.println();
		System.out.println(c);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
