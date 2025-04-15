package Interviewproblems;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr={1,3,2,5,-1,6,3,-1,4,-1};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					arr[j]=-1;
				}
			}
		}
		int j=0;
		 for(int i=0;i<arr.length;i++){
	            if(arr[i]!=-1){
	                int temp=arr[j];
	                arr[j]=arr[i];
	                arr[i]=temp;
	                j++;
	            }
		 }
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}

}
