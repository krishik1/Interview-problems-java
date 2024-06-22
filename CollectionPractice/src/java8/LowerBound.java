package java8;

public class LowerBound { 
	public static void main(String[] args) {
		int[] arr= {1,3,6,9,12,14,17};
		int low=0,high=arr.length-1,ans=arr.length;
		int x=14;
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]>=x) {
				ans=mid;
				high=mid-1;
			} else {
				low=mid+1;
			}
		}
		System.out.println("ans : "+ans+ " ele : "+arr[ans]);
		
	}

}
