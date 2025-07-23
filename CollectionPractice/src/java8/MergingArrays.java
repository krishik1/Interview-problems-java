package java8;

public class MergingArrays {
	public static void main(String[] args) {
		merge();
	}

	private static void merge() {
		//int n, m;
		long arr1[] = {1,3,5,7};
		long arr2[] = {0,2,6,8,9};
		int i=0,j=0,k=0;
		int n= arr1.length + arr2.length;
		long[] arr = new long[n];
        while((i< arr1.length) && (j< arr2.length)){
            if(arr1[i]<arr2[j]){
            	arr[k] = arr1[i];
                System.out.print(arr[k]+" ");
                i++;
                k++;
            } else{
            	arr[k] = arr2[j];
                System.out.print(arr[k]+" ");
                j++;
                k++;
            }	
                
        }
      //  System.out.println("j:"+j);
        //System.out.println("i:"+i);
        while(i<arr1.length) {
        	arr[k]=arr1[i];
        	System.out.print(arr[k]+" ");
        	i++;
        	k++;
        }
        while(j<arr2.length) {
        	arr[k]= arr2[j];
        	System.out.print(arr[k]+" ");
        	j++;
        	k++;
        }
        /**
		for(int k=0;k<n;k++) {
			if(arr1[i]>arr2[j]) {
				arr[k] = arr2[j];
				System.out.print(arr[k]+" ");
				j++;
			} else {
				arr[k] = arr1[i];
				System.out.print(arr[k]+" ");
				i++;
			}
		}**/
	}

}
