package sorting;

public class Solution {
	public static void main(String[] args) {
//		int[][] x= {{1,2,3},{4,5,6},{7,8,9}};
//		diagonal(x);
//		System.out.println(x);
//		solve(x);
		//int[] A= {15,7,11,7,9,8,18,1,16,18,6,1,1,4,18};
		int[] A= {15,16, 17, 4, 3, 5, 2};
//		int b=1,c=2;
//		int s=solve(A,b,c);
		int B=3;
		int d=4;
		String s=addBinary("1110110101", "1110111011");
		System.out.println("ans : "+s);
		//System.out.println("val : "+solve(d,B));
		//int s=solve(A,B);
		//int[] c=solve(A);
//		for(int val:c) {
//			System.out.println("val : "+val);
//		}
		//System.out.println("Sum:"+c);
	}
	public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
//	public static int solve(int A, int B) {
//		int sum=0,var=1;
//        while(A>0){
//            sum+=A%B*var;
//            var*=10;
//            A=A/B;
//        }
//        return sum;
//    }
//	
//	public static int[] solve(int[] A) {
//        int n=A.length;
//        int count =1,temp=A[n-1];
//        for(int i=n-2;i>=0;i--){
//            if(temp<A[i]){
//                count++;
//                temp=A[i];
//            }
//        } 
//        int[] arr=new int[count];
//        arr[0]=A[n-1];
//        int temp1=A[n-1],c=1;
//        for(int i=n-2;i>=0;i--){
//            if(temp1<A[i]){
//                arr[c++]=A[i];
//                temp1=A[i];
//            }
//        }
//        return arr;
//        }
//	
//	public static int repeatedNumber(int[] A) {
//		int n=A.length;
//		int maj1=A[0],c1=1,maj2=A[1],c2=1;
//        for(int i=2;i<n;i++){
//            if(A[i]==maj1) {
//            	c1++;
//            } else if(A[i]==maj2) {
//            	c2++;
//            } else if(c1==0) {
//            	maj1=A[i];
//            	c1=1;
//            } else if(c2==0) {
//            	maj2=A[i];
//            	c2=1;
//            } else {
//            	c1--;
//            	c2--;
//            }
//        }
//        
//        c1=0;c2=0;
//        for(int i=0;i<n;i++){
//            if(A[i]==maj1){
//                c1++;
//            }else if(A[i]==maj2) {
//            	c2++;
//            }
//        }
//        if(c1>n/3){
//            return maj1;
//        } 
//        if(c2>n/3){
//        	return maj2;
//        }
//    return -1;
//        
//    }
//	
//	 public static int tSum(int[] a){
//	        int sum=0,n=a.length;
//	        for(int i=0;i<n;i++){
//	            sum+=a[i];
//	        }
//	        System.out.println("sum :"+sum);
//	        return sum;
//	    }
//	    public static int min(int[] a){
//	        int min= a[0],index=0;
//	        for(int i=1;i<a.length;i++){
//	            if(min>a[i]){
//	                min=a[i];
//	                index=i;
//	            }
//	        }
//	        System.out.println("min : "+index);
//	        return index;
//	    }


//	    public static int solve(int[] A, int B) {
//	        int n=A.length;
//	        //int tSum=tSum(A);
//	        int i=0,j=B-1;
//	        int index = 0;
//	        double min= Double.POSITIVE_INFINITY;
////	        if(B==1){
////	            index=min(A);
////	            return index;
////	        }
//	        while(j<n){
//	            int sum=0;
//	            for(int s=i;s<=j;s++){
//	                sum+=A[s];
//	            }
//	           
//	            double avg=sum/B;
//	            
//	            if(sum<min){
//	                //min=(double)avg;
//	            	min=sum;
//	                index=i;
//	                //System.out.println("errrrrrrrrrrrrrrrr "+i);
//	            }
//	            i++;j++;
//	        }
//	        return index;
//	    }
	
	
	
	
//	 public static int sum(int[] A,int B){
//	        int sum=0;
//	        for(int i=1;i<=B;i++){
//	            sum+=A[i-1];
//	        }
//	        return sum;
//	    }
//	    public static int solve(int[] A, int B, int C) {
//	        int n=A.length;
//	        int sum=0,ans=0;
//	        if(n==1){
//	            sum=A[0];
//	        } else {
//	            sum=sum(A,B);
//	        }
//	        int s=1,e=B;
//	        while(e<n){
//	            if(sum==C){
//	                ans=1;
//	                return ans;
//	            }
//	            sum=sum+A[e]-A[s-1];
//	            e++;s++;
//	        }
//	        return ans;
//	    }
	
//	 public static int[][] solve(int[][] A) {
//	        int n=A.length;
//	        for(int i=0;i<n;i++){
//	            for(int j=i+1;j<n;j++){
//	                int temp=A[i][j];
//	                A[i][j]=A[j][i];
//	                A[j][i]=temp;
//	            }
//	        }
//	        return A;
//	    }
//	
//	public static int[][] diagonal(int[][] A) {
//        int n=A.length;
//        int[][]  dig=new int[2*n-1][n];
//        int k=n;
//        for(int col=0;col<n;col++){
//            int i=0,j=col;
//            int c=0;
//            while(i<n && j>=0){
//            	dig[col][c]=A[i][j];
//                i++;j--;c++;
//            }
//        }
//        for(int row=1;row<n;row++) {
//        	int i=row,j=n-1;
//        	int c=0;
//        	while(i<n && j>=1) {
//        		dig[k][c]=A[i][j];
//        		i++;j--;c++;
//        	}
//        	k++;
//        }
//        return dig;
//    }

}
